package com.example.springboottest.response

import com.example.springboottest.entity.Banner
import com.example.springboottest.entity.Category
import com.example.springboottest.entity.Coupon
import com.example.springboottest.entity.Goods

data class PageHomeResponse(
    val coupon: List<Coupon>,
    val banner: List<Banner>,
    val category: List<Category>,
    val recommend: List<Goods>,
    val flashSale: List<Goods>
)