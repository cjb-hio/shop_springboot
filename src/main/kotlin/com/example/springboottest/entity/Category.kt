package com.example.springboottest.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import java.time.LocalDateTime


@TableName("category")
data class Category(
    @TableId(type = IdType.AUTO) val id: Int,
    val createTime: LocalDateTime,
    val updateTime: LocalDateTime,
    val name: String,
    val parentId: Int? = null,
    var pic: String,
    val sortNum: Int,
    val status: Int
)