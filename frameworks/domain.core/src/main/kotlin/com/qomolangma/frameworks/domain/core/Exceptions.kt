package com.qomolangma.frameworks.domain.core

object Exceptions {
    @JvmStatic
    fun execute(runnable: RunnableWithCheckedException) {
        try {
            runnable.run()
        } catch (e: Exception) {
            throw wrap(e)
        }
    }

    @JvmStatic
    fun <R> evaluate(supplier: SupplierWithCheckedException<R?>): R? {
        return try {
            supplier.get()
        } catch (e: Exception) {
            throw wrap(e)
        }
    }

    @JvmStatic
    fun ignored(runnable: RunnableWithCheckedException) {
        try {
            runnable.run()
        } catch (ignored: Exception) {
        }
    }

    @JvmStatic
    fun wrap(throwable: Throwable): RuntimeException {
        return if (throwable is RuntimeException) throwable else RuntimeException(throwable)
    }
}
