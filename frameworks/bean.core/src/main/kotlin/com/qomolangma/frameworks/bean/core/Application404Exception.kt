package com.qomolangma.frameworks.bean.core

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.NOT_FOUND)
class Application404Exception(message: String, throwable: Throwable) : ApplicationException(message, throwable)
