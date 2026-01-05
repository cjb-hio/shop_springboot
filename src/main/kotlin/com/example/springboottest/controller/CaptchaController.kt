package com.example.springboottest.controller

import com.example.springboottest.response.CaptchaResponse
import com.example.springboottest.response.CommonResponse
import com.example.springboottest.util.RedisUtil
import com.wf.captcha.SpecCaptcha
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import java.util.Locale
import java.util.UUID
import kotlin.String

@RestController
@Controller
class CaptchaController {
    @Autowired
    private lateinit var redisUtil: RedisUtil<String>

    @GetMapping("/user/login/captcha")
    fun captcha(): CommonResponse<CaptchaResponse> {
        val specCaptcha = SpecCaptcha(150, 50, 4)
        val verCode = specCaptcha.text().lowercase()
        val key = UUID.randomUUID().toString()
        // 存入redis并设置过期时间为30分钟
        redisUtil.set(key, verCode, 30 * 60)
        // 将key和base64返回给前端
        return CommonResponse.success(CaptchaResponse(specCaptcha.toBase64(), key))
    }

    @PostMapping("/user/login/smsCode")
    fun login(
        @RequestParam phone: String,
        @RequestParam captchaId: String,
        @RequestParam code: String?
    ): CommonResponse<String> {
        // 获取redis中的验证码
        val redisCode = redisUtil.get(captchaId)
        // 判断验证码
        if (code == null || redisCode != code.trim { it <= ' ' }.lowercase(Locale.getDefault())) {
            return CommonResponse.error(CommonResponse.ERR_CAPTCHA, "验证码不正确")
        }
        return CommonResponse.success("2280")
    }
}