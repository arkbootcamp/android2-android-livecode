package com.erdin.arkaandroidtwo.project

import retrofit2.http.GET
import retrofit2.http.POST

interface ProjectsApiService {

    @GET("project")
    suspend fun getAllProject(): ProjectResponse

}