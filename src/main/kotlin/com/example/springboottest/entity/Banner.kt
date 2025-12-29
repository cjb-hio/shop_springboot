package com.example.springboottest.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import java.time.LocalDateTime


@TableName("banner")
data class Banner(
    @TableId(type = IdType.AUTO) val id: Int,
    val createTime: LocalDateTime,
    val updateTime: LocalDateTime,
    val description: String? = null,
    val path: String? = null,
    var pic: String
)