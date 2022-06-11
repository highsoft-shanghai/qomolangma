package com.everest.frameworks.test.web

class YesNo private constructor(private val value: Boolean) {
    override fun toString(): String {
        return if (value) "Yes" else "No"
    }

    companion object {
        @JvmStatic
        fun of(value: Boolean): YesNo {
            return YesNo(value)
        }
    }
}
