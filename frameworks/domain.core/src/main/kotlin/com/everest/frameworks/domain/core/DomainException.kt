package com.everest.frameworks.domain.core

open class DomainException @JvmOverloads constructor(message: String, cause: Throwable? = null) :
    RuntimeException(message, cause)
