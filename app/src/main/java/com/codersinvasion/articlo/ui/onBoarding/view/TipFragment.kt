package com.codersinvasion.articlo.ui.onBoarding.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.codersinvasion.articlo.R
import com.codersinvasion.articlo.databinding.FragmentTipBinding
import com.codersinvasion.articlo.ui.onBoarding.data.TipUiState

class TipFragment(private val tip: TipUiState) : Fragment() {
    private lateinit var binding: FragmentTipBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTipBinding.inflate(layoutInflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            lifecycleOwner = this@TipFragment
            data = tip
        }
    }

}