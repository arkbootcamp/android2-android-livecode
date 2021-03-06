package com.erdin.arkaandroidtwo.mvvm

import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.erdin.arkaandroidtwo.R
import com.erdin.arkaandroidtwo.databinding.ActivityLoginBinding
import com.erdin.arkaandroidtwo.login.AuthApiService
import com.erdin.arkaandroidtwo.remote.ApiClient

class LoginMvvmActivity: AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var defaultSharedPref: SharedPreferences
    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        defaultSharedPref = androidx.preference.PreferenceManager.getDefaultSharedPreferences(applicationContext)
        val service = ApiClient.getApiClient()?.create(AuthApiService::class.java)

        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        viewModel.setSharedPreference(defaultSharedPref)

        if (service != null) {
            viewModel.setLoginService(service)
        }

        binding.btnLogin.setOnClickListener {
            viewModel.callLoginApi(binding.etEmail.text.toString(), binding.etPassword.text.toString())
        }

        subscribeLiveData()
    }

    private fun subscribeLiveData() {
        viewModel.isLoginLiveData.observe(this, {
            Log.d("subscribeLiveData", "$it")

            if (it) {
                Toast.makeText(this, "Login Success", Toast.LENGTH_LONG).show()

                finish()
            } else {
                Toast.makeText(this, "Login Failed!", Toast.LENGTH_LONG).show()
            }
        })
    }
    
}