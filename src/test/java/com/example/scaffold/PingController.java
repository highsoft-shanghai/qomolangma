package com.example.scaffold;

import com.example.frameworks.domain.core.Payload;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import static com.example.frameworks.domain.core.StringFieldType.asString;

@Tag(name = "Restful controller连通性测试接口")
@RestController
public class PingController {
    @PostMapping("/ping")
    public String ping(Payload payload) {
        return payload.get("data", asString());
    }
}
