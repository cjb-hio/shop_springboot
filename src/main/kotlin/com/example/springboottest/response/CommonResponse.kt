package com.example.springboottest.response

data class CommonResponse<T>(val code: Int, val data: T?) {
    companion object {

        fun <T> success(data: T): CommonResponse<T> {
            return CommonResponse(
                code = 1000,
                data = data
            )
        }
    }
}