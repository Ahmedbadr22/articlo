package com.codersinvasion.articlo.ui.create_account.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.codersinvasion.articlo.databinding.FragmentSelectTopicsOfInterestBinding

class SelectTopicsOfInterestFragment : Fragment() {
    private lateinit var binding: FragmentSelectTopicsOfInterestBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSelectTopicsOfInterestBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

}