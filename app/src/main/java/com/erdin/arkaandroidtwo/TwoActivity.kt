package com.erdin.arkaandroidtwo

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class TwoActivity : AppCompatActivity() {

    companion object {
        val LAUNCH_INTENT = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two)

        val tvTittle = findViewById<TextView>(R.id.tv_title)
        val btnActivityThree = findViewById<Button>(R.id.btn_activity_three)

        val domainName = intent.getStringExtra("domainName")

        tvTittle.text = domainName

        btnActivityThree.setOnClickListener {
            val intentThree = Intent(this, ThreeActivity::class.java)
            startActivityForResult(intentThree, LAUNCH_INTENT)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == LAUNCH_INTENT) {
            if (resultCode == Activity.RESULT_OK) {
                val result = data?.getStringExtra("tittleName")
                val tvTittle = findViewById<TextView>(R.id.tv_title)
                tvTittle.text = result
            }
        }
    }
}