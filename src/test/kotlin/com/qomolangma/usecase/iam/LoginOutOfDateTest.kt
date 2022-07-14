package com.qomolangma.usecase.iam

import com.qomolangma.IntegrationTest
import com.qomolangma.frameworks.context.test.FixClockTime
import com.qomolangma.frameworks.domain.core.GlobalClockResetter
import com.qomolangma.frameworks.test.web.PathVariables.Companion.variables
import com.qomolangma.frameworks.test.web.WithGrantedAuthorities
import org.hamcrest.Matchers.`is`
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test
import java.time.Instant

@FixClockTime("2022-04-01T11:22:33Z")
@WithGrantedAuthorities(["grantedAuthority"])
class LoginOutOfDateTest : IntegrationTest() {
    @Test
    fun should_error_if_out_of_date() {
        GlobalClockResetter.fixAt(Instant.parse("2022-04-10T11:22:33Z"))
        try {
            val post = post("/ping", variables(HashMap<String, Any>()), mapOf(Pair("data", "pong")), null)
            post.statusCode(`is`(200)).body("code", `is`("1")).body("msg", `is`("error.bad-token"))
        } catch (ignored: Exception) {
        }
    }

    @AfterEach
    internal fun tearDown() {
        GlobalClockResetter.reset()
    }
}
