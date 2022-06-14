package com.qomolangma.frameworks.payload.core

import com.qomolangma.frameworks.payload.core.MapFieldType.Companion.asMap

class Payload(private val value: Any) {
    operator fun <I> get(type: FieldType<I>): I {
        return type.from(value)
    }

    operator fun <I> get(key: String?, type: FieldType<I>): I {
        return type.from(get(asMap())[key])
    }

    class PayloadBuilder {
        private val value: LinkedHashMap<String, Any> = LinkedHashMap()

        fun append(key: String, value: Any): PayloadBuilder {
            this.value[key] = value
            return this
        }

        fun build(): Payload {
            return Payload(value)
        }
    }

    companion object {
        fun append(key: String, value: Any): PayloadBuilder {
            val builder = PayloadBuilder()
            builder.append(key, value)
            return builder
        }
    }
}
