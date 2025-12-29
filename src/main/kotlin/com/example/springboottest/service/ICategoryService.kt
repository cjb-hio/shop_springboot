package com.example.springboottest.service

import com.baomidou.mybatisplus.extension.service.IService
import com.example.springboottest.entity.Category

interface ICategoryService : IService<Category> {

    fun listParentCategory(requestDomainPrefix: String = ""): List<Category>
}