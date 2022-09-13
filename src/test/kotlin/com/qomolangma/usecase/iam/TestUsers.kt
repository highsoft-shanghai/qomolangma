package com.qomolangma.usecase.iam

import com.qomolangma.frameworks.domain.core.Identity
import com.qomolangma.frameworks.security.core.GrantedAuthorities
import com.qomolangma.iam.domain.User
import com.qomolangma.iam.domain.UserIdentityOwner

class TestUsers {
    companion object {
        @JvmStatic
        fun system(): User {
            return user("system")
        }

        @JvmStatic
        fun common(): User {
            return user("common")
        }

        @JvmStatic
        fun tester(authority: String): User {
            return User.restore(
                "tester",
                UserIdentityOwner.create(
                    Identity("qomolangma", "Qomolangma"),
                    Identity("tester", "Tester"),
                    Identity("qomolangma", "Qomolangma"),
                    "Qomolangma"
                ),
                GrantedAuthorities.of(authority)
            )
        }

        private fun user(authority: String): User {
            return User.restore(
                "1234",
                UserIdentityOwner.create(Identity.create(""), Identity.create("Neil"), Identity.create(""), "123456"),
                GrantedAuthorities.of(authority)
            )
        }
    }
}
