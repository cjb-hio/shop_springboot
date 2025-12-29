package com.example.springboottest.service.impl

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import com.example.springboottest.entity.Coupon
import com.example.springboottest.mapper.CouponMapper
import com.example.springboottest.service.ICouponService
import org.springframework.stereotype.Service


@Service
class CouponServiceImpl : ServiceImpl<CouponMapper, Coupon>(), ICouponService {

}