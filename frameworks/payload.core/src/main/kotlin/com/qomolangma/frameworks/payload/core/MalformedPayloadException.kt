package com.qomolangma.frameworks.payload.core

import com.qomolangma.frameworks.domain.core.DomainException

class MalformedPayloadException(message: String) : DomainException(message)
