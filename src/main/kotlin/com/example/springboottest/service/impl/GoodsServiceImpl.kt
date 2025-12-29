package com.example.springboottest.service.impl

import com.baomidou.mybatisplus.extension.kotlin.KtQueryWrapper
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import com.example.springboottest.entity.Banner
import com.example.springboottest.entity.Goods
import com.example.springboottest.mapper.BannerMapper
import com.example.springboottest.mapper.GoodsMapper
import com.example.springboottest.service.IBannerService
import com.example.springboottest.service.IGoodsService
import org.springframework.stereotype.Service


@Service
class GoodsServiceImpl : ServiceImpl<GoodsMapper, Goods>(), IGoodsService {
    override fun list(prefix: String): List<Goods> {
        val list = this.list()
        list.forEach { good ->
            good.mainPic = prefix + good.mainPic
        }
        return list
    }

    override fun listSale(prefix: String): List<Goods> {
        val ktQueryWrapper = KtQueryWrapper(Goods::class.java)
        ktQueryWrapper.eq(Goods::featured, true)
        val list = this.list(ktQueryWrapper)
        list.forEach { good ->
            good.mainPic = prefix + good.mainPic
        }
        return list
    }

    override fun listRecommend(prefix: String): List<Goods> {
        val ktQueryWrapper = KtQueryWrapper(Goods::class.java)
        ktQueryWrapper.eq(Goods::recommend, true)
        val list = this.list(ktQueryWrapper)
        list.forEach { good ->
            good.mainPic = prefix + good.mainPic
        }
        return list
    }
}