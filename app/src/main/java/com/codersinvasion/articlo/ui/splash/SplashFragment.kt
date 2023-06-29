package com.codersinvasion.articlo.ui.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.codersinvasion.articlo.app.constants.APP
import com.codersinvasion.articlo.databinding.FragmentSplashBinding


class SplashFragment : Fragment() {
    private lateinit var binding: FragmentSplashBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSplashBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        handleSplashDelayTime()
    }

    private fun handleSplashDelayTime() {
        Handler(Looper.myLooper()!!).postDelayed({
            navigateToOnBoardingScreen()
        }, APP.SPLASH_TIME)
    }


    private fun navigateToOnBoardingScreen() {
        val navAction = SplashFragmentDirections.actionSplashFragmentToOnBoardingFragment()
        findNavController().navigate(navAction)
    }
}