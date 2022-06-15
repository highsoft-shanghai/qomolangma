package com.qomolangma.frameworks.bean.core

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.BAD_REQUEST)
class Application400Exception(message: String, throwable: Throwable) : ApplicationException(message, throwable)
