package com.qomolangma.frameworks.security.core

import java.util.*

interface ContextProvider {
    operator fun get(token: String): Optional<Context>
}
