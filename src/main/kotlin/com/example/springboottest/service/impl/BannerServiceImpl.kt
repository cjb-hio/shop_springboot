package com.example.springboottest.service.impl

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import com.example.springboottest.entity.Banner
import com.example.springboottest.mapper.BannerMapper
import com.example.springboottest.service.IBannerService
import org.springframework.stereotype.Service


@Service
class BannerServiceImpl : ServiceImpl<BannerMapper, Banner>(), IBannerService {
    override fun list(prefix: String): List<Banner> {
        val list = this.list()
        list.forEach { banner ->
            banner.pic = prefix + banner.pic
        }
        return list
    }
}