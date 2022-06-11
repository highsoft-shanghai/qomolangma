package com.example.scaffold.frameworks.test.web

import com.example.scaffold.frameworks.test.web.ConstrainedParameters.parameterWithConstraints
import lombok.AccessLevel
import lombok.NoArgsConstructor
import org.apache.commons.lang3.ArrayUtils
import org.springframework.restdocs.payload.FieldDescriptor
import org.springframework.restdocs.payload.PayloadDocumentation
import org.springframework.restdocs.payload.ResponseFieldsSnippet
import org.springframework.restdocs.request.ParameterDescriptor
import org.springframework.restdocs.request.RequestDocumentation
import org.springframework.restdocs.request.RequestParametersSnippet

@NoArgsConstructor(access = AccessLevel.PRIVATE)
object ApiDocUtils {
    @JvmStatic
    fun apiHeader(authorizationRequired: Boolean): ApiHeaderSnippet {
        return ApiHeaderSnippet(authorizationRequired)
    }

    @JvmStatic
    fun pagedRequestParameters(vararg descriptors: ParameterDescriptor): RequestParametersSnippet {
        val paginationParameters = arrayOf(
            parameterWithConstraints("size", "Number", "必须大于等于1且小于等于999999").description("分页大小"),
            parameterWithConstraints("page", "Number", "必须大于等于0且小于等于99999999").description("以0为首页的页码")
        )
        return RequestDocumentation.requestParameters(*ArrayUtils.addAll(descriptors, *paginationParameters))
    }

    @JvmStatic
    fun pagedResponseFields(vararg descriptors: FieldDescriptor): ResponseFieldsSnippet {
        val paginationFields = arrayOf(
            PayloadDocumentation.fieldWithPath("first").description("是否首页。true表示当前页为首页，false则为非首页"),
            PayloadDocumentation.fieldWithPath("last").description("是否末页。true表示当前页为末页，false则为非末页"),
            PayloadDocumentation.fieldWithPath("numberOfTotalPages").description("总页数"),
            PayloadDocumentation.fieldWithPath("numberOfTotalElements").description("总记录数"),
            PayloadDocumentation.fieldWithPath("numberOfElements").description("当前页内记录数"),
            PayloadDocumentation.fieldWithPath("size").description("分页大小"),
            PayloadDocumentation.fieldWithPath("number").description("页码"),
            PayloadDocumentation.fieldWithPath("sort").optional().description("排序信息"),
            PayloadDocumentation.fieldWithPath("sort[].property").type("String").description("排序字段"),
            PayloadDocumentation.fieldWithPath("sort[].direction").type("String").description("排序方向。ASC为升序，DESC为降序")
        )
        return PayloadDocumentation.responseFields(*ArrayUtils.addAll(descriptors, *paginationFields))
    }
}
