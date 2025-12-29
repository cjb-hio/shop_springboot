package com.example.springboottest.service

import com.baomidou.mybatisplus.extension.service.IService
import com.example.springboottest.entity.Banner

interface IBannerService : IService<Banner> {
    fun list(prefix: String): List<Banner>
}