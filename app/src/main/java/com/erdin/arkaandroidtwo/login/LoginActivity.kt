package com.erdin.arkaandroidtwo.login

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.erdin.arkaandroidtwo.R
import com.erdin.arkaandroidtwo.databinding.ActivityLoginBinding
import com.erdin.arkaandroidtwo.remote.ApiClient
import com.erdin.arkaandroidtwo.sharedpref.LearnSharedPrefActivity
import kotlinx.coroutines.*
import retrofit2.create

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var defaultSharedPref: SharedPreferences
    private lateinit var coroutineScope: CoroutineScope
    private lateinit var service: AuthApiService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        defaultSharedPref = androidx.preference.PreferenceManager.getDefaultSharedPreferences(applicationContext)
        coroutineScope = CoroutineScope( Job() + Dispatchers.Main )
        service = ApiClient.getApiClient()!!.create(AuthApiService::class.java)

        binding.btnLogin.setOnClickListener {
            callLoginApi(binding.etEmail.text.toString(), binding.etPassword.text.toString())
        }

    }

    private fun callLoginApi(email: String, password: String) {
        coroutineScope.launch {

            val result = withContext(Dispatchers.IO) {
                try {
                    service.loginRequest(email, password)
                } catch (e: Throwable) {
                    e.printStackTrace()

                }
            }

            if (result is LoginResponse) {
                if (result?.success) {
                    defaultSharedPref.edit().putString(LearnSharedPrefActivity.KEY_TOKEN, result.data?.token).apply()
                    Toast.makeText(this@LoginActivity, "Login Success", Toast.LENGTH_LONG).show()
                }
            }

        }
    }

}