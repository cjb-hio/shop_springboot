package com.example.springboottest.service

import com.baomidou.mybatisplus.extension.service.IService
import com.example.springboottest.entity.Banner
import com.example.springboottest.entity.Category
import com.example.springboottest.entity.Goods

interface IGoodsService : IService<Goods> {
    fun list(prefix: String): List<Goods>

    fun listSale(prefix: String): List<Goods>

    fun listRecommend(prefix: String): List<Goods>



}