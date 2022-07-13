package com.qomolangma.iam.gateways.ohs

import com.qomolangma.frameworks.payload.core.Payload
import com.qomolangma.iam.application.GetAccessTokenContentUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.annotation.Resource

@RestController
@RequestMapping("/access-tokens")
class AccessTokenController(
    @Resource private val getAccessTokenContentUseCase: GetAccessTokenContentUseCase
) {

    @get:GetMapping("/current")
    val content: Payload
        get() = getAccessTokenContentUseCase.execute()
}
