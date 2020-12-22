package com.erdin.arkaandroidtwo.remote

import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response = chain.run {
        val tokenAuth = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkIjoxLCJ1c2VyX2VtYWlsIjoiZXJkaW5AZ21haWwuY29tIiwidXNlcl9sZXZlbCI6MSwiaWF0IjoxNjA4NjE2NTIxLCJleHAiOjE2MDg2MjAxMjF9.kn-0vY7LEPjsjEMzOssXyZluVgyH0xNhjparqD21qMY"
        proceed(
            request().newBuilder()
                .addHeader("Authorization", "Bearer $tokenAuth")
                .build()
        )
    }

}