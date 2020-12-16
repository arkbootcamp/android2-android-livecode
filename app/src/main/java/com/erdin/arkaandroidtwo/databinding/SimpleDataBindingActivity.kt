package com.erdin.arkaandroidtwo.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.erdin.arkaandroidtwo.R
import com.erdin.arkaandroidtwo.toolbar.ArkademyModel


class SimpleDataBindingActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySimpleDataBindingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_simple_data_binding)

        binding.model = ArkademyModel("Rosyid", "rosyid@gmail.com", "Yogyakarta")
        binding.btnChange.setOnClickListener {
            binding.model = ArkademyModel("Ikirima", "ikirima@gmail.com", "Malang")
        }

    }


}