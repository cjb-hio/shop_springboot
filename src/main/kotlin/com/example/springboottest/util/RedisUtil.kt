package com.example.springboottest.util

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Component
import java.util.concurrent.TimeUnit

@Component
class RedisUtil<T> {
    @Autowired
    private lateinit var redisTemplate: RedisTemplate<String, T>


    /**
     * 指定缓存失效时间
     *
     * @param key  键
     * @param time 时间（秒）
     */
    fun expire(key: String, time: Long) {
        if (time > 0) {
            redisTemplate.expire(key, time, TimeUnit.SECONDS)
        }
    }

    fun getExpire(key: String): Long {
        return redisTemplate.getExpire(key)
    }

    /**
     * 普通缓存获取
     *
     * @param key 键
     * @return 值
     */
    fun get(key: String): T? {
        return redisTemplate.opsForValue().get(key)
    }


    /**
     * 缓存放入
     *
     * @param key   键
     * @param value 值
     */
    fun set(key: String, value: T) {
        value?.let { redisTemplate.opsForValue().set(key, it) }
    }

    /**
     * 缓存放入
     *
     * @param key   键
     * @param value 值
     * @param time  时间（秒）
     */
    fun set(key: String, value: T, time: Long = 0) {
        if (time > 0) {
            value?.let { redisTemplate.opsForValue().set(key, it, time, TimeUnit.SECONDS) }
        } else {
            set(key, value)
        }
    }
}