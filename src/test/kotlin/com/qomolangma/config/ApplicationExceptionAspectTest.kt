package com.qomolangma.config

import com.qomolangma.IntegrationTest
import com.qomolangma.frameworks.bean.core.Application400Exception
import com.qomolangma.frameworks.bean.core.Application401Exception
import com.qomolangma.frameworks.bean.core.Application409Exception
import com.qomolangma.frameworks.bean.core.ApplicationException
import com.qomolangma.frameworks.security.core.ContextLoader
import com.qomolangma.frameworks.test.web.WithGrantedAuthorities
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import javax.annotation.Resource

@WithGrantedAuthorities(["grantedAuthority"])
internal class ApplicationExceptionAspectTest : IntegrationTest() {
    @Resource
    private val authenticationExceptionTest: AuthenticationExceptionTest? = null

    @Resource
    private val contextLoader: ContextLoader? = null

    @BeforeEach
    internal fun setUp() {
        contextLoader!!.load("grantedAuthority")
    }

    @Test
    fun should_be_able_to_translate_illegal_arguments_exceptions() {
        val throwable = Assertions.catchThrowable { authenticationExceptionTest!!.throwIllegalArgumentException() }
        Assertions.assertThat(throwable).isInstanceOf(Application400Exception::class.java)
        Assertions.assertThat(throwable).hasMessage("error")
    }

    @Test
    fun should_convert_409_authentication_exception() {
        val throwable = Assertions.catchThrowable { authenticationExceptionTest!!.throw409Exception() }
        Assertions.assertThat(throwable).isInstanceOf(Application409Exception::class.java)
        Assertions.assertThat(throwable).hasMessage("error")
    }

    @Test
    fun should_convert_authentication_exception() {
        val throwable = Assertions.catchThrowable { authenticationExceptionTest!!.throwOtherException() }
        Assertions.assertThat(throwable).isInstanceOf(ApplicationException::class.java)
        Assertions.assertThat(throwable).hasMessage("error")
    }

    @Test
    fun should_convert_access_denied_exception() {
        val throwable = Assertions.catchThrowable { authenticationExceptionTest!!.throwAccessDeniedException() }
        Assertions.assertThat(throwable).isInstanceOf(Application401Exception::class.java)
        Assertions.assertThat(throwable).hasMessage("error")
    }

    @AfterEach
    internal fun tearDown() {
        contextLoader!!.clear()
    }

    internal class OtherException(message: String?) : RuntimeException(message)
}
