package com.erdin.arkaandroidtwo

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


class ThreeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_three)

        val btnBack = findViewById<Button>(R.id.btn_back)
        val etTitle = findViewById<EditText>(R.id.et_title)

        btnBack.setOnClickListener {
            val tittle = etTitle.text.toString()
            val returnIntent = Intent()
            returnIntent.putExtra("tittleName", tittle)
            setResult(Activity.RESULT_OK, returnIntent)
            finish()
        }
    }
}