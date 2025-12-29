package com.example.springboottest.service.impl

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import com.example.springboottest.entity.User
import com.example.springboottest.mapper.UserMapper
import com.example.springboottest.service.IUserService
import org.springframework.stereotype.Service


@Service
class UserServiceImpl : ServiceImpl<UserMapper, User>(), IUserService {

}