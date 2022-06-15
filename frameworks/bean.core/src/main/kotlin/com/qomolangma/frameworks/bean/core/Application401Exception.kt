package com.qomolangma.frameworks.bean.core

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.UNAUTHORIZED)
class Application401Exception(message: String, cause: Throwable) : ApplicationException(message, cause)
