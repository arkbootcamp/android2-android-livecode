package com.erdin.arkaandroidtwo.project

import com.google.gson.annotations.SerializedName

data class ProjectResponse(val success: String, val message: String, val data: List<Project>) {
    data class Project(@SerializedName("project_id") val projectId: String,
                       @SerializedName("project_name") val projectName: String,
                       @SerializedName("project_desc") val projectDesc: String,
                       @SerializedName("project_type") val projectType: String,
                       @SerializedName("project_image") val projectImage: String)
}