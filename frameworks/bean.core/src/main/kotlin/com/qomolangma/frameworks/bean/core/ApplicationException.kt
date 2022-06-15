package com.qomolangma.frameworks.bean.core

open class ApplicationException : RuntimeException {
    private val args: Array<Any?>

    constructor() : super(DEFAULT_MESSAGE_CODE) {
        args = arrayOfNulls(0)
    }

    constructor(message: String?, cause: Throwable?) : super(message, cause) {
        args = arrayOfNulls(0)
    }

    constructor(message: String?, args: Array<Any?>) : super(message) {
        this.args = args
    }

    fun resolveMessage(messageResolver: MessageResolver): String {
        return messageResolver.resolve(message!!, *args)
    }

    companion object {
        const val DEFAULT_MESSAGE_CODE = "error.default-application-error"
    }
}
