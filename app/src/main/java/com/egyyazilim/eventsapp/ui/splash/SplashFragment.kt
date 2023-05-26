package com.egyyazilim.eventsapp.ui.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.egyyazilim.eventsapp.R


class SplashFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view=inflater.inflate(R.layout.fragment_splash,container,false)
        Handler(Looper.myLooper()!!).postDelayed({
            findNavController().navigate(R.id.navigation_home)
        },5000)
        return view
    }


}