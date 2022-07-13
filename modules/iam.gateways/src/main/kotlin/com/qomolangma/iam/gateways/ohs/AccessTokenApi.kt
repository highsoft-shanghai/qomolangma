package com.qomolangma.iam.gateways.ohs

import com.qomolangma.frameworks.gateways.core.OpenHostService
import com.qomolangma.frameworks.payload.core.Payload
import com.qomolangma.iam.application.GetAccessTokenContentUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import javax.annotation.Resource

@OpenHostService
@RequestMapping("/access-tokens")
class AccessTokenApi(
    @Resource private val getAccessTokenContentUseCase: GetAccessTokenContentUseCase
) {

    @GetMapping("/current")
    fun content(): Payload {
        return getAccessTokenContentUseCase.execute()
    }
}
