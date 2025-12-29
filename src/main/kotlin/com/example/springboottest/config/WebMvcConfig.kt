package com.example.springboottest.config

import com.baomidou.mybatisplus.core.toolkit.support.SFunction
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class WebMvcConfig : WebMvcConfigurer {
    // 注入本地图片存储目录
    @Value("\${file.upload-path}")
    private val uploadPath: String? = null

    // 注入URL访问前缀
    @Value("\${file.access-prefix}")
    private val accessPrefix: String? = null

    /**
     * 配置资源映射：URL路径 → 本地磁盘目录
     */
    override fun addResourceHandlers(registry: ResourceHandlerRegistry) {
        // 关键：addResourceHandler配置URL前缀，addResourceLocations配置本地目录（需加file:前缀）
        registry.addResourceHandler(accessPrefix + "**")
            .addResourceLocations("file:" + uploadPath)
    }
}