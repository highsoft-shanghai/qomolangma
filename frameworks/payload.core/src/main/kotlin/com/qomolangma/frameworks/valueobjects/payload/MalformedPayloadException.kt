package com.qomolangma.frameworks.valueobjects.payload

import com.qomolangma.frameworks.domain.core.DomainException

class MalformedPayloadException(message: String) : DomainException(message)
