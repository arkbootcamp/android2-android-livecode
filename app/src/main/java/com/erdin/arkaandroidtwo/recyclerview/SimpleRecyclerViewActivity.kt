package com.erdin.arkaandroidtwo.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.erdin.arkaandroidtwo.R
import com.erdin.arkaandroidtwo.databinding.ActivitySimpleRecyclerViewBinding

class SimpleRecyclerViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySimpleRecyclerViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_simple_recycler_view)

        binding.rvSimple.adapter = SimpleRecylerViewAdapter()
        binding.rvSimple.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
    }
}