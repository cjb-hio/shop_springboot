package com.example.springboottest.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import java.time.LocalDateTime

@TableName("goods")
data class Goods(

    @TableId(type = IdType.AUTO)
    val id: Int,
    val createTime: LocalDateTime,
    val updateTime: LocalDateTime,
    val typeId: Int,
    val title: String,
    val subTitle: String,
    var mainPic: String,
    /*val pics: List<String>?,*/
    val price: Int,
    val sold: Int,
    val content: String?,
//    val contentPics: List<String>?,
    val recommend: Boolean,
    val featured: Boolean,
    val status: Int,
    val sortNum: Int,
//    val specs: List<String>?


)