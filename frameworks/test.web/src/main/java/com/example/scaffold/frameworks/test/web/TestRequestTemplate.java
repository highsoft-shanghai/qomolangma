package com.example.scaffold.frameworks.test.web;


import com.google.common.collect.ImmutableMap;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;

import javax.annotation.Resource;
import java.io.File;
import java.net.URI;
import java.util.Map;

@Component
public class TestRequestTemplate {
    private @Resource TestRestTemplate testRestTemplate;

    public TestResponse post(String urlTemplate, Object body, Object... vars) {
        return exchange(getRequest(urlTemplate, body, vars, HttpMethod.POST));
    }

    public TestResponse put(String urlTemplate, Object body, Object... vars) {
        return exchange(getRequest(urlTemplate, body, vars, HttpMethod.PUT));
    }

    public TestResponse delete(String urlTemplate, Object... vars) {
        return exchange(getRequest(urlTemplate, null, vars, HttpMethod.DELETE));
    }

    public TestResponse get(String urlTemplate, Object... vars) {
        return get(urlTemplate, ImmutableMap.of(), vars);
    }

    public TestResponse get(String urlTemplate, Map<String, Object> params, MultiValueMap<String, String> headers) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(urlTemplate);
        params.forEach(builder::queryParam);
        URI uri = builder.build().encode().toUri();
        RequestEntity<?> request = new RequestEntity<>(headers, HttpMethod.GET, uri);
        return exchange(request);
    }

    public TestResponse get(String urlTemplate, Map<String, Object> params, Object... vars) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(urlTemplate);
        params.forEach(builder::queryParam);
        URI uri = builder.buildAndExpand(vars).encode().toUri();
        RequestEntity<?> request = new RequestEntity<>(requestHeader(), HttpMethod.GET, uri);
        return exchange(request);
    }

    public RequestEntity<?> getRequest(String urlTemplate, Object body, Object[] vars, HttpMethod put) {
        URI uri = UriComponentsBuilder.fromUriString(urlTemplate).buildAndExpand(vars).encode().toUri();
        return new RequestEntity<>(body, requestHeader(), put, uri);
    }

    public TestResponse exchange(RequestEntity<?> request) {
        ResponseEntity<String> response = testRestTemplate.exchange(request, String.class);
        return new TestResponse(response);
    }

    public TestResponse postFile(String urlTemplate, File file) {
        HttpHeaders headers = requestHeader();
        headers.setContentType(MediaType.parseMediaType("multipart/form-data"));
        MultiValueMap<String, Object> form = new LinkedMultiValueMap<>();
        if (file != null) {
            form.add("file", new FileSystemResource(file));
        }
        HttpEntity<MultiValueMap<String, Object>> files = new HttpEntity<>(form, headers);
        ResponseEntity<String> response = testRestTemplate.postForEntity(urlTemplate, files, String.class);
        return new TestResponse(response);
    }

    public HttpHeaders requestHeader() {
        return new HttpHeaders();
    }

}
