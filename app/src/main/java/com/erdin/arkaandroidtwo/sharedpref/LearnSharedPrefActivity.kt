package com.erdin.arkaandroidtwo.sharedpref

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SharedMemory
import android.preference.PreferenceManager
import androidx.databinding.DataBindingUtil
import com.erdin.arkaandroidtwo.R
import com.erdin.arkaandroidtwo.databinding.ActivityLearnSharedPrefBinding

class LearnSharedPrefActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLearnSharedPrefBinding

    companion object {
        const val SHARED_PREF_NAME = "LEARNANDROID2"
        const val KEY_EMAIL = "EMAIL_ANDROID2"
        const val KEY_TOKEN = "TOKEN_ARKA2"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_learn_shared_pref)

//        var sharedPref = applicationContext.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
        var sharedPref = androidx.preference.PreferenceManager.getDefaultSharedPreferences(applicationContext)

        binding.btnUpdateEmail.setOnClickListener {
            sharedPref.edit().putString(KEY_EMAIL, "farham@gmail.com").apply()
        }

        binding.tvEmail.text = sharedPref.getString(KEY_EMAIL, "....")
    }
}