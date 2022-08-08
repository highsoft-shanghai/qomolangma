package com.qomolangma.frameworks.test.web

import com.qomolangma.frameworks.context.core.SimpleUserContext
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
                SimpleUserContext(userAccount(), user(), tenant(), password()),
                SimpleSecurityContext("tester-token-id", grantedAuthorities)
            )
        }

        fun teardown() {
            INSTANCE.context = null
        }

        fun tenant(): Identity {
            return Identity("qomolangma", "Qomolangma")
        }

        fun user(): Identity {
            return Identity("tester", "Tester")
        }

        fun userAccount(): Identity {
            return Identity("qomolangma", "Qomolangma")
        }

        fun password() = "Qomolangma"
    }
}
