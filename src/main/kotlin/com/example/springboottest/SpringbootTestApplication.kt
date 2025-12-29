package com.example.springboottest

import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@MapperScan("com.example.springboottest.mapper")
@SpringBootApplication
class SpringbootTestApplication

fun main(args: Array<String>) {
    runApplication<SpringbootTestApplication>(*args)
}
