package com.erdin.arkaandroidtwo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.erdin.arkaandroidtwo.dialog.DialogActivity
import com.erdin.arkaandroidtwo.login.LoginActivity
import com.erdin.arkaandroidtwo.project.ProjectListActivity
import com.erdin.arkaandroidtwo.recyclerview.SimpleRecyclerViewActivity
import com.erdin.arkaandroidtwo.room.WordListActivity
import com.erdin.arkaandroidtwo.sharedpref.LearnSharedPrefActivity
import com.erdin.arkaandroidtwo.tablayout.SimpleTabLayoutActivity
import com.erdin.arkaandroidtwo.toolbar.SimpleToolbarActivity
import com.erdin.arkaandroidtwo.webview.WebViewActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("lifecyle", "onCreate()")
        Toast.makeText(this, "Activity: onCreate()", Toast.LENGTH_SHORT).show()

        val btnActivityOne = findViewById<Button>(R.id.btn_activity_one)
        val btnActivityTwo = findViewById<Button>(R.id.btn_activity_two)
        val btnActivityLinear = findViewById<Button>(R.id.btn_linear_layout)
        val btnActivityToolbar = findViewById<Button>(R.id.btn_toolbar)
        val btnActivityDialog = findViewById<Button>(R.id.btn_dialog)
        val btnActivityTablayout = findViewById<Button>(R.id.btn_tablayout)
        val btnActivityWebView = findViewById<Button>(R.id.btn_webview)
        val btnActivityRyclerView = findViewById<Button>(R.id.btn_recycler_view)
        val btnActivitySharedPref = findViewById<Button>(R.id.btn_shared_pref)
        val btnActivityRoom = findViewById<Button>(R.id.btn_word_activity)
        val btnActivityRetrofit = findViewById<Button>(R.id.btn_activity_retrofit)
        val btnActivityLogin = findViewById<Button>(R.id.btn_activity_login)

        btnActivityOne.setOnClickListener {
            val intentA = Intent(this, OneActivity::class.java)
            startActivity(intentA)
        }

        btnActivityTwo.setOnClickListener {
            val intentTwo = Intent(this, TwoActivity::class.java)
            intentTwo.putExtra("domainName", "www.arkademy.com")
            startActivity(intentTwo)
        }

        btnActivityDialog.setOnClickListener {
            val intentA = Intent(this, DialogActivity::class.java)
            startActivity(intentA)
        }

        btnActivityTablayout.setOnClickListener {
            val intentA = Intent(this, SimpleTabLayoutActivity::class.java)
            startActivity(intentA)
        }

        btnActivityWebView.setOnClickListener {
            val intentA = Intent(this, WebViewActivity::class.java)
            startActivity(intentA)
        }

        btnActivityRyclerView.setOnClickListener {
            val intentA = Intent(this, SimpleRecyclerViewActivity::class.java)
            startActivity(intentA)
        }

        btnActivitySharedPref.setOnClickListener {
            val intentA = Intent(this, LearnSharedPrefActivity::class.java)
            startActivity(intentA)
        }

        btnActivityRoom.setOnClickListener {
            val intentA = Intent(this, WordListActivity::class.java)
            startActivity(intentA)
        }

        btnActivityRetrofit.setOnClickListener {
            val intentA = Intent(this, ProjectListActivity::class.java)
            startActivity(intentA)
        }

        btnActivityLogin.setOnClickListener {
            val intentA = Intent(this, LoginActivity::class.java)
            startActivity(intentA)
        }

        btnActivityLinear.setOnClickListener(this)
        btnActivityToolbar.setOnClickListener(this)
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
            R.id.btn_toolbar -> {
                val intent = Intent(this, SimpleToolbarActivity::class.java)
                startActivity(intent)
            }
        }
    }


}