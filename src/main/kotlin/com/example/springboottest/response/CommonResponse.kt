package com.example.springboottest.response

data class CommonResponse<T>(val code: Int, val data: T? = null, val message: String? = null) {
    companion object {

        const val SUCCESS = 1000
        const val ERR_CAPTCHA = 1
        fun <T> success(data: T): CommonResponse<T> {
            return CommonResponse(
                code = SUCCESS,
                data = data
            )
        }

        fun <T> error(code: Int, message: String?): CommonResponse<T> {
            return CommonResponse(
                code = code,
                message = message
            )
        }


    }
}