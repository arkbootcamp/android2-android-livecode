package com.erdin.arkaandroidtwo.remote

import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response = chain.run {
        val tokenAuth = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkIjoxLCJ1c2VyX2VtYWlsIjoiZXJkaW5AZ21haWwuY29tIiwidXNlcl9sZXZlbCI6MSwiaWF0IjoxNjEwMDkyNDcyLCJleHAiOjE2MTAwOTYwNzJ9.6kbujp0a9ZprMprXH5yjcNil-F6-190_wrjnC2Zz6DE"
        proceed(
            request().newBuilder()
                .addHeader("Authorization", "Bearer $tokenAuth")
                .build()
        )
    }

}