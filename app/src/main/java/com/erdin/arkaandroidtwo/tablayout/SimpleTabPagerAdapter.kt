package com.erdin.arkaandroidtwo.tablayout

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.erdin.arkaandroidtwo.fragment.FragmentA
import com.erdin.arkaandroidtwo.fragment.FragmentB

class SimpleTabPagerAdapter(fragment: FragmentManager) : FragmentStatePagerAdapter(fragment, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    val fragment = arrayOf(FragmentA(), FragmentB(null))

    override fun getCount(): Int = fragment.size

    override fun getItem(position: Int): Fragment {
        return fragment[position]
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "Fragment A"
            1 -> "Fragment B"
            else -> ""
        }
    }

}