package com.erdin.arkaandroidtwo.project

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import okhttp3.MultipartBody
import okhttp3.RequestBody
import kotlin.coroutines.CoroutineContext

class ProjectAddViewModel: ViewModel(), CoroutineScope {

    private lateinit var service: ProjectsApiService

    override val coroutineContext: CoroutineContext
        get() = Job() + Dispatchers.Main

    fun setService(service: ProjectsApiService) {
        this.service = service
    }

    fun postProjectApi(name: RequestBody, desc: RequestBody, type: RequestBody, image: MultipartBody.Part) {
        launch {
            val response = withContext(Dispatchers.IO) {
                try {
                    service?.postProject(name, desc, type, image)
                } catch (e: Throwable) {
                    e.printStackTrace()
                }
            }

            if (response is ProjectAddResponse) {
                // Action success
                Log.d("responseAddProject", response.toString())
            }
        }
    }
}