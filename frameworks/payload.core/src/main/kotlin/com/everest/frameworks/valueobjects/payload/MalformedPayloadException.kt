package com.everest.frameworks.valueobjects.payload

import com.everest.frameworks.domain.core.DomainException

class MalformedPayloadException(message: String) : DomainException(message)
