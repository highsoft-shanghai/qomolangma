package com.qomolangma.frameworks.payload.core

import com.qomolangma.frameworks.payload.core.MapFieldType.Companion.asMap

class Payload(private val value: Any?) {
    fun <T> get(type: FieldType<T>): T {
        return type.from(value)
    }

    fun <T> get(key: String, type: FieldType<T>): T {
        return type.from(get(asMap())[key])
    }

    companion object {
        @JvmStatic
        fun append(key: String, value: Any?): PayloadBuilder {
            val builder = PayloadBuilder(LinkedHashMap())
            builder.append(key, value)
            return builder
        }
    }

    class PayloadBuilder(private val value: LinkedHashMap<String, Any?>) {
        fun append(key: String, value: Any?): PayloadBuilder {
            this.value[key] = value
            return this
        }

        fun build(): Payload {
            return Payload(this.value)
        }
    }
}
