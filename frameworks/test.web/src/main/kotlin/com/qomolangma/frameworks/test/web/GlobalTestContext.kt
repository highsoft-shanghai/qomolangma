package com.qomolangma.frameworks.test.web

import com.qomolangma.frameworks.context.core.SimpleUserContext
import com.qomolangma.frameworks.domain.core.Id
import com.qomolangma.frameworks.domain.core.Identity
import com.qomolangma.frameworks.security.core.*
import java.util.*

class GlobalTestContext {
    private var context: Context? = null

    companion object {
        private val INSTANCE = GlobalTestContext()

        fun context(): Optional<Context> {
            return Optional.ofNullable<Context>(INSTANCE.context)
        }

        fun token(): Optional<String> {
            return context().map(Context::securityContext).map(SecurityContext::id)
        }

        fun setup(grantedAuthorities: GrantedAuthorities?) {
            INSTANCE.context = SimpleContext(
                SimpleUserContext(
                    Id("tester"),
                    Identity("qomolangma", "Qomolangma"),
                    Identity("tester", "Tester"),
                    Identity("qomolangma", "Qomolangma"),
                    "Qomolangma"
                ),
                SimpleSecurityContext("tester-token-id", grantedAuthorities)
            )
        }

        fun teardown() {
            INSTANCE.context = null
        }

    }
}
