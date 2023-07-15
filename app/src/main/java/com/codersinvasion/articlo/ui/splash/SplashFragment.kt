package com.codersinvasion.articlo.ui.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.codersinvasion.articlo.databinding.FragmentSplashBinding
import com.codersinvasion.articlo.ui.create_account.viewModel.CreateAccountViewModel
import com.codersinvasion.constants.APP
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.activityViewModel


class SplashFragment : Fragment() {
    private lateinit var binding: FragmentSplashBinding

    private val createAccountViewModel: CreateAccountViewModel by activityViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSplashBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listAllData()
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


    private fun listAllData() {
        CoroutineScope(Dispatchers.Unconfined).launch {
            createAccountViewModel.listCountries()
        }
    }
}