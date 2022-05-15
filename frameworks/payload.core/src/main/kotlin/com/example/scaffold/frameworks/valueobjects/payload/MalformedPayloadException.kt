package com.example.scaffold.frameworks.valueobjects.payload

import com.example.frameworks.domain.core.DomainException

class MalformedPayloadException(message: String) : DomainException(message)
