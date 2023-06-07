package com.egyyazilim.eventsapp.ui.splash

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.datastore.core.DataStore
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import com.egyyazilim.eventsapp.R
import com.egyyazilim.eventsapp.databinding.FragmentSplashBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Runnable
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.util.prefs.Preferences
import javax.inject.Inject

@AndroidEntryPoint
class SplashFragment : Fragment() {
    private var binding:FragmentSplashBinding?=null
    @Inject lateinit var prefs:DataStore<Preferences>
    private val handler=Handler()
    private val runnable=Runnable{
        lifecycleScope.launch {
            prefs.data.collectLatest {
                if(it[prefencesKey<Boolean>("onBoard")]==true)
                    requireView().findNavController()
                        .navigate(SplashFragmentDirections.actionNavigationSplashToWelcomeFragment())
                else
                    requireView().findNavController()
                        .navigate(SplashFragmentDirections.actionNavigationSplashToOnBoardingFragment())
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentSplashBinding.inflate(layoutInflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN)
    }

    override fun onResume() {
        super.onResume()
        handler.postDelayed(runnable,3000)
    }

    override fun onPause() {
        super.onPause()
        handler.removeCallbacks(runnable)
    }





}