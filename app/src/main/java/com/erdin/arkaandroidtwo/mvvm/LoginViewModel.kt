package com.erdin.arkaandroidtwo.mvvm

import android.content.SharedPreferences
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.erdin.arkaandroidtwo.login.AuthApiService
import com.erdin.arkaandroidtwo.login.LoginResponse
import com.erdin.arkaandroidtwo.sharedpref.LearnSharedPrefActivity
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class LoginViewModel: ViewModel(), CoroutineScope {

    val isLoginLiveData = MutableLiveData<Boolean>()

    private lateinit var service: AuthApiService
    private lateinit var sharedPreferences: SharedPreferences

    override val coroutineContext: CoroutineContext
        get() = Job() + Dispatchers.Main

    fun setSharedPreference(sharedPreferences: SharedPreferences) {
        this.sharedPreferences = sharedPreferences
    }

    fun setLoginService(service: AuthApiService) {
        this.service = service
    }

    fun callLoginApi(email: String, password: String) {
        launch {
            val result = withContext(Dispatchers.IO) {
                try {
                    service.loginRequest(email, password)
                } catch (e: Throwable) {
                    e.printStackTrace()

                    withContext(Dispatchers.Main) {
                        isLoginLiveData.value = false
                    }
                }
            }

            if (result is LoginResponse) {
                if (result?.success) {
                    sharedPreferences.edit().putString(LearnSharedPrefActivity.KEY_TOKEN, result.data?.token).apply()
                    isLoginLiveData.value = true
                } else {
                    isLoginLiveData.value = false
                }
            }
        }
    }



}