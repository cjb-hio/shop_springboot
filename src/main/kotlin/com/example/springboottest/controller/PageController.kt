package com.example.springboottest.controller

import com.example.springboottest.response.CommonResponse
import com.example.springboottest.response.PageHomeResponse
import com.example.springboottest.service.IBannerService
import com.example.springboottest.service.ICategoryService
import com.example.springboottest.service.ICouponService
import com.example.springboottest.service.IGoodsService
import com.example.springboottest.util.RequestDomainUtil
import jakarta.servlet.http.HttpServletRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/page")
class PageController {


    @Autowired
    private lateinit var iCouponService: ICouponService

    @Autowired
    private lateinit var iBannerService: IBannerService


    @Autowired
    private lateinit var iCategoryService: ICategoryService

    @Autowired
    private lateinit var iGoodsService: IGoodsService

    @Autowired
    private lateinit var requestDomainUtil: RequestDomainUtil


    @GetMapping("/home")
    fun getPageHomeResponse(request: HttpServletRequest): CommonResponse<PageHomeResponse> {
        val requestDomainPrefix = requestDomainUtil.getRequestDomainPrefix(request)
        val couponList = iCouponService.list()
        val bannerList = iBannerService.list(requestDomainPrefix)
        val categoryList = iCategoryService.listParentCategory(requestDomainPrefix)
        val listRecommend = iGoodsService.listRecommend(requestDomainPrefix)
        val listSale = iGoodsService.listSale(requestDomainPrefix)

        val response = PageHomeResponse(
            couponList,
            bannerList, categoryList, listRecommend, listSale
        )
        return CommonResponse.success(response)
    }
}