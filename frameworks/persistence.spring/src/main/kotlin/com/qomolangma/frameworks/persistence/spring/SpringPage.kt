package com.qomolangma.frameworks.persistence.spring

import com.qomolangma.frameworks.domain.core.Sort
import org.springframework.data.domain.Page
import java.util.function.Function

open class SpringPage<T> protected constructor(private val impl: Page<T>) :
    com.qomolangma.frameworks.domain.core.Page<T> {
    override fun content(): List<T> {
        return impl.content
    }

    override fun size(): Int {
        return impl.size
    }

    override fun number(): Int {
        return impl.number
    }

    override fun numberOfElements(): Int {
        return impl.numberOfElements
    }

    override fun numberOfTotalPages(): Int {
        return impl.totalPages
    }

    override fun numberOfTotalElements(): Long {
        return impl.totalElements
    }

    override fun first(): Boolean {
        return impl.isFirst
    }

    override fun last(): Boolean {
        return impl.isLast
    }

    override fun sort(): Sort {
        return SpringSort.of(impl.sort)
    }

    override fun <U> map(converter: Function<in T, out U>): com.qomolangma.frameworks.domain.core.Page<U> {
        return SpringPage(impl.map(converter))
    }

    companion object {
        @JvmStatic
        fun <T> from(page: Page<T>): SpringPage<T> {
            return SpringPage(page)
        }
    }
}
