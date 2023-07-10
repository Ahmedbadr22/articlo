package com.codersinvasion.articlo.ui.login.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.codersinvasion.articlo.databinding.FragmentLoginBinding
import androidx.navigation.fragment.findNavController
import com.codersinvasion.articlo.ui.login.listener.LoginScreenClickListener
import com.codersinvasion.articlo.ui.login.viewModel.LoginViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class LoginFragment : Fragment(), LoginScreenClickListener {
    private lateinit var binding: FragmentLoginBinding

    private val loginViewModel: LoginViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            lifecycleOwner = this@LoginFragment
            clickListener = this@LoginFragment
            viewModel = loginViewModel
        }

        observeLoadingState()
    }

    private fun observeLoadingState() {
        loginViewModel.isLoadingObserver.observe(viewLifecycleOwner) { isLoading ->
            if (isLoading) showLoadingDialog()
            else dismissLoadingDialog()
        }
    }
    private fun showLoadingDialog() {
        val navAction = LoginFragmentDirections.actionLoginFragmentToLoadingDialog()
        findNavController().navigate(navAction)
    }

    private fun dismissLoadingDialog() {
        findNavController().popBackStack()
    }

    override fun navigateToRegistrationScreen() {
        val navAction = LoginFragmentDirections.actionLoginFragmentToCreateAccountFragment()
        findNavController().navigate(navAction)
    }

}