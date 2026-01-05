package com.example.springboottest.controller

import com.example.springboottest.entity.Category
import com.example.springboottest.entity.Goods
import com.example.springboottest.response.CommonResponse
import com.example.springboottest.response.PageHomeResponse
import com.example.springboottest.service.ICategoryService
import com.example.springboottest.util.RequestDomainUtil
import jakarta.servlet.http.HttpServletRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/goods")
class GoodsController {

    @Autowired
    private lateinit var requestDomainUtil: RequestDomainUtil

    @Autowired
    private lateinit var categoryService: ICategoryService

    @PostMapping("/type/list")
    fun gettypeListResponse(request: HttpServletRequest): CommonResponse<List<Category>> {
        val requestDomainPrefix = requestDomainUtil.getRequestDomainPrefix(request)
        return CommonResponse.success(categoryService.listTypeList(requestDomainPrefix))
    }

}