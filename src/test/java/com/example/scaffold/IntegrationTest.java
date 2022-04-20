package com.example.scaffold;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.util.UriComponentsBuilder;
import org.testcontainers.shaded.com.google.common.collect.ImmutableMap;

import javax.annotation.Resource;
import java.net.URI;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@Tag("slow")
@ExtendWith({TestContainersInitializer.class, SpringExtension.class, MocoInitializer.class})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("unittest")
public abstract class IntegrationTest {

    protected @Resource TestRestTemplate testRestTemplate;
    private @Resource TestContainersInitializer testContainersInitializer;
    protected String authorization;

    @BeforeEach
    void testIsContainerRunning() {
        assertThat(testContainersInitializer.isRunning()).isTrue();
    }

    protected TestResponse get(String urlTemplate, Object... vars) {
        return get(urlTemplate, ImmutableMap.of(), vars);
    }

    protected TestResponse put(String urlTemplate, Object body, Object... vars) {
        return exchange(getRequest(urlTemplate, body, vars, HttpMethod.PUT));
    }

    protected TestResponse post(String urlTemplate, Object body, Object... vars) {
        return exchange(getRequest(urlTemplate, body, vars, HttpMethod.POST));
    }

    protected TestResponse get(String urlTemplate, Map<String, Object> params, Object... vars) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(urlTemplate);
        params.forEach(builder::queryParam);
        URI uri = builder.buildAndExpand(vars).encode().toUri();
        RequestEntity<?> request = new RequestEntity<>(requestHeader(), HttpMethod.GET, uri);
        return exchange(request);
    }

    protected TestResponse delete(String url, Map<String, Object> params) {
        RequestEntity<Map<String, Object>> httpEntity = new RequestEntity<>(params, requestHeader(), HttpMethod.DELETE, URI.create(url));
        return exchange(httpEntity);
    }

    private TestResponse exchange(RequestEntity<?> request) {
        ResponseEntity<String> exchange = testRestTemplate.exchange(request, String.class);
        return new TestResponse(exchange);
    }

    private RequestEntity<?> getRequest(String urlTemplate, Object body, Object[] vars, HttpMethod put) {
        URI uri = UriComponentsBuilder.fromUriString(urlTemplate).buildAndExpand(vars).encode().toUri();
        return new RequestEntity<>(body, requestHeader(), put, uri);
    }

    private HttpHeaders requestHeader() {
        HttpHeaders headers = new HttpHeaders();
        addAuthorization(headers);
        return headers;
    }

    private void addAuthorization(HttpHeaders headers) {
        headers.add("Authorization", authorization);
    }

}
