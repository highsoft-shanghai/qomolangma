package com.example.frameworks.domain.core

object Exceptions {
    @JvmStatic
    fun execute(runnable: RunnableWithCheckedException) {
        try {
            runnable.run()
        } catch (e: Exception) {
            throw wrap(e);
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
    fun wrap(throwable: Throwable): RuntimeException {
        return if (throwable is RuntimeException) throwable else RuntimeException(throwable)
    }
}
