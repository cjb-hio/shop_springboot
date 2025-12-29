package com.example.springboottest.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName


@TableName("user")
data class User(@TableId(type = IdType.AUTO) val id: Int, val user_name: String, val password: String)