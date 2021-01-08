package com.erdin.arkaandroidtwo.project

import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface ProjectsApiService {

    @GET("project")
    suspend fun getAllProject(): ProjectResponse

    @Multipart
    @POST("project")
    suspend fun postProject(
        @Part("projectName") projectName: RequestBody,
        @Part("projectDesc") projectDesc: RequestBody,
        @Part("projectType") projectType: RequestBody,
        @Part projectImage: MultipartBody.Part
    ): ProjectAddResponse

}