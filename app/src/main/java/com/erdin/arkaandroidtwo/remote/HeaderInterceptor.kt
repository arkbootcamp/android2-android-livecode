package com.erdin.arkaandroidtwo.remote

import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response = chain.run {
        val tokenAuth = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkIjoxLCJ1c2VyX2VtYWlsIjoiZXJkaW5AZ21haWwuY29tIiwidXNlcl9sZXZlbCI6MSwiaWF0IjoxNjA5OTA1MjM1LCJleHAiOjE2MDk5MDg4MzV9.FwHWiqYkrFjAtnfIEa_ZRdlixWgCh4UubZ7ap8iRhus"
        proceed(
            request().newBuilder()
                .addHeader("Authorization", "Bearer $tokenAuth")
                .build()
        )
    }

}