package com.example.springboottest.util

import jakarta.servlet.http.HttpServletRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.web.server.autoconfigure.ServerProperties
import org.springframework.stereotype.Component

@Component
class RequestDomainUtil {

    // 注入ServerProperties（Spring自动绑定server.*配置）
    @Autowired
    private lateinit var serverProperties: ServerProperties

    // 注入URL访问前缀
    @Value("\${file.access-prefix}")
    private lateinit var accessPrefix: String

    fun getRequestDomainPrefix(request: HttpServletRequest): String {
        // 1. 获取协议（http/https）
        val scheme = request.getScheme()
        // 2. 获取服务器域名/IP
        val serverName = request.getServerName()
        // 3. 获取服务器端口
        val serverPort = request.getServerPort()

        // 4. 拼接前缀（省略默认端口：80→HTTP，443→HTTPS）
        return scheme + "://" + serverName + ":" + serverPort + serverProperties.servlet.contextPath + accessPrefix
    }
}