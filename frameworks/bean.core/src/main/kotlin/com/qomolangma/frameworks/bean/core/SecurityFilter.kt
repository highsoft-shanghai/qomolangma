package com.qomolangma.frameworks.bean.core

import com.qomolangma.frameworks.domain.core.Exceptions
import com.qomolangma.frameworks.security.core.ContextLoader
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import java.io.IOException
import javax.annotation.Resource
import javax.servlet.FilterChain
import javax.servlet.ServletException
import javax.servlet.annotation.WebFilter
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
@WebFilter("/**")
class SecurityFilter(
    @Resource private val contextLoader: ContextLoader
) : OncePerRequestFilter() {
    @Throws(ServletException::class, IOException::class)
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        Exceptions.execute { setToken(request, filterChain, response) }
    }

    private fun setToken(
        request: HttpServletRequest,
        filterChain: FilterChain,
        response: HttpServletResponse
    ) {
        val loader = HttpHeaderContextLoader(contextLoader)
        loader.load(request)
        filterChain.doFilter(request, response)
    }
}
