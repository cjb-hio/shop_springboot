package com.example.springboottest.controller

import com.example.springboottest.entity.User
import com.example.springboottest.service.IUserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserController {




    @Autowired
    private lateinit var IUserService: IUserService


    @GetMapping("/list")
    fun listUser(): List<User> {
        return IUserService.list()
    }
}