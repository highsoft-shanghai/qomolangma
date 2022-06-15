package com.qomolangma.frameworks.bean.core

import java.util.function.BiFunction

open class ExceptionTranslator(private val messageResolver: MessageResolver) {
    private val handlerChain: MutableList<BiFunction<MutableMap<String, Any>, Throwable?, Boolean>> = ArrayList()

    init {
        initializeHandlerChain()
    }

    private fun initializeHandlerChain() {
        handlerChain.add(BiFunction { error, throwable -> handleApplicationException(error, throwable) })
    }

    fun handle(error: MutableMap<String, Any>, throwable: Throwable?) {
        handlerChain.stream().anyMatch { x -> x.apply(error, throwable) }
    }

    fun handleApplicationException(error: MutableMap<String, Any>, throwable: Throwable?): Boolean {
        if (throwable == null) return false
        throwable.printStackTrace()
        error["message"] = (throwable as ApplicationException).resolveMessage(messageResolver)
        return true
    }
}
