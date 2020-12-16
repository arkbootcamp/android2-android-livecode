package com.erdin.arkaandroidtwo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.erdin.arkaandroidtwo.R
import com.erdin.arkaandroidtwo.databinding.FragmentABinding

class FragmentA: Fragment() {

//    private lateinit var rootView:View
    private lateinit var binding: FragmentABinding

    companion object {
        const val EXTRA_INFO = "EXTRA_INFO"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        rootView = inflater.inflate(R.layout.fragment_a, container, false)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_a, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val infoA = arguments?.getString(EXTRA_INFO, "Fragment A")
        binding.tvTitleA.text = infoA
    }


}