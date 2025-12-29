package com.example.springboottest.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import com.baomidou.mybatisplus.extension.handlers.FastjsonTypeHandler
import lombok.Data
import java.time.LocalDateTime


@TableName(value = "coupon", autoResultMap = true)
data class Coupon(
    @TableId(type = IdType.AUTO)
    val id: Int = 0,
    val title: String? = null,
    val description: String? = null,
    val amount: Int = 0,
    val num: Int = 0,
    val startTime: LocalDateTime? = null,
    val endTime: LocalDateTime? = null,

    @TableField(typeHandler = FastjsonTypeHandler::class)
    val couponCondition: CouponCondition? = null
)


data class CouponCondition(
    val fullAmount: Int = 0
)
