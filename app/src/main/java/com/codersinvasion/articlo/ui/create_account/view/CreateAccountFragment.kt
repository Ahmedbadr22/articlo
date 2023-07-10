package com.codersinvasion.articlo.ui.create_account.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.codersinvasion.articlo.R
import com.codersinvasion.articlo.databinding.FragmentCreateAccountBinding
import kotlinx.coroutines.launch


class CreateAccountFragment : Fragment() {
    private lateinit var binding: FragmentCreateAccountBinding

    private lateinit var createAccountNavController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCreateAccountBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navHostFragment : NavHostFragment = childFragmentManager.findFragmentById(R.id.fcv_create_account) as NavHostFragment
        createAccountNavController = navHostFragment.navController

        binding.apply {
            lifecycleScope.launch {
                createAccountNavController.currentBackStack.collect { backStack ->
                    if (backStack.size == 2) tbCreateAccount.setupWithNavController(findNavController())
                    else tbCreateAccount.setupWithNavController(createAccountNavController)
                }
            }
        }

    }
}