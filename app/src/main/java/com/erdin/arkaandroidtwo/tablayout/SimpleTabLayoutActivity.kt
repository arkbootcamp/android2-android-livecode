package com.erdin.arkaandroidtwo.tablayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentManager
import com.erdin.arkaandroidtwo.R
import com.erdin.arkaandroidtwo.databinding.ActivitySimpleTabLayoutBinding

class SimpleTabLayoutActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySimpleTabLayoutBinding
    private lateinit var pagerAdapter: SimpleTabPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_simple_tab_layout)

        pagerAdapter = SimpleTabPagerAdapter(supportFragmentManager)
        binding.viewPager.adapter = pagerAdapter

        binding.tabLayout.setupWithViewPager(binding.viewPager)
    }
}