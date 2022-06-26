package com.qomolangma.frameworks.persistence.spring

import com.qomolangma.frameworks.domain.core.Pagination
import com.qomolangma.frameworks.domain.core.Sort
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable

open class SpringPagination protected constructor(private val impl: Pageable) : Pagination {
    override fun pageNumber(): Int {
        return impl.pageNumber
    }

    override fun pageSize(): Int {
        return impl.pageSize
    }

    override fun sort(): Sort {
        return SpringSort.of(impl.sort)
    }

    companion object {
        @JvmStatic
        fun of(impl: PageRequest): Pagination {
            return SpringPagination(impl)
        }
    }
}
