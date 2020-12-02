package com.erdin.arkaandroidtwo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("lifecyle", "onCreate()")
        Toast.makeText(this, "Activity: onCreate()", Toast.LENGTH_SHORT).show()

        val btnActivityOne = findViewById<Button>(R.id.btn_activity_one)
        val btnActivityTwo = findViewById<Button>(R.id.btn_activity_two)
        val btnActivityLinear = findViewById<Button>(R.id.btn_linear_layout)

        btnActivityOne.setOnClickListener {
            val intentA = Intent(this, OneActivity::class.java)
            startActivity(intentA)
        }

        btnActivityTwo.setOnClickListener {
            val intentTwo = Intent(this, TwoActivity::class.java)
            intentTwo.putExtra("domainName", "www.arkademy.com")
            startActivity(intentTwo)
        }

        btnActivityLinear.setOnClickListener(this)
    }

    override fun onStart() {
        super.onStart()

        Log.d("lifecycle", "onStart()")
        Toast.makeText(this, "Activity: onStart()", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()

        Log.d("lifecycle", "onResum()")
        Toast.makeText(this, "Activity: onResume()", Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()

        Log.d("lifecycle", "onPause()")
        Toast.makeText(this, "Activity: onPause()", Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()

        Log.d("lifecycle", "onStop()")
        Toast.makeText(this, "Activity: onStop()", Toast.LENGTH_SHORT).show()
    }

    override fun onRestart() {
        super.onRestart()

        Log.d("lifecycle", "onRestart()")
        Toast.makeText(this, "Activity: onRestart()", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.d("lifecycle", "onDestroy()")
        Toast.makeText(this, "Activity: onDestroy()", Toast.LENGTH_SHORT).show()
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_linear_layout -> {
                val intent = Intent(this, LinearLayoutActivity::class.java)
                startActivity(intent)
            }

        }
    }


}