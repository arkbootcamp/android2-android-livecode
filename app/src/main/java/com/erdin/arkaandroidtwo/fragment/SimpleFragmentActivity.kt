package com.erdin.arkaandroidtwo.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.erdin.arkaandroidtwo.R

class SimpleFragmentActivity : AppCompatActivity() {

    private lateinit var textInfo: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_fragment)

        val btnSwitchA = findViewById<Button>(R.id.btn_switch_a)
        val btnSwitchB = findViewById<Button>(R.id.btn_switch_b)
        textInfo = findViewById(R.id.tv_info_fragment)

        // Activity to Fragment
        btnSwitchA.setOnClickListener {
            val aFragment = FragmentA()
            val bundle = Bundle()
            bundle.putString(FragmentA.EXTRA_INFO, "ARGUMENT A")
            aFragment.arguments = bundle
            supportFragmentManager.beginTransaction().replace(R.id.fl_container, aFragment).commit()
        }

        // Passing data fragment to activity
        btnSwitchB.setOnClickListener {
            val bFragment = FragmentB(object : FragmentB.BListener {
                override fun onChangeBClick(info: String) {
                    textInfo.text = info
                }
            })
            supportFragmentManager.beginTransaction().replace(R.id.fl_container, bFragment).commit()
        }
    }
}