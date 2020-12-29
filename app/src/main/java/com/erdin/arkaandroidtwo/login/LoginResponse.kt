package com.erdin.arkaandroidtwo.login

import com.google.gson.annotations.SerializedName

data class LoginResponse (val success: Boolean, val message: String, val data: Data? ) {
    data class Data(
            @SerializedName("user_id") val userId: String?,
            @SerializedName("user_email") val userEmail: String?,
            @SerializedName("user_level") val userLevel: String?,
            val token: String?
    )
}