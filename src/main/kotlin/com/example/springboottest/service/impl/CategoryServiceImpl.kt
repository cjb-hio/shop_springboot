package com.example.springboottest.service.impl

import com.baomidou.mybatisplus.extension.kotlin.KtQueryWrapper
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import com.example.springboottest.entity.Category
import com.example.springboottest.mapper.CategoryMapper
import com.example.springboottest.service.ICategoryService
import org.springframework.stereotype.Service


@Service
class CategoryServiceImpl : ServiceImpl<CategoryMapper, Category>(), ICategoryService {


    override fun listParentCategory(requestDomainPrefix: String): List<Category> {

        val ktQueryWrapper = KtQueryWrapper(Category::class.java)
        ktQueryWrapper.isNull(Category::parentId)
        val selectList = list(ktQueryWrapper)
        selectList.forEach {
            it.pic = requestDomainPrefix + it.pic
        }
        return selectList
    }

    override fun listTypeList(prefix: String): List<Category> {
        val selectList = list()
        selectList.forEach {
            it.pic = prefix + it.pic
        }
        return selectList
    }
}