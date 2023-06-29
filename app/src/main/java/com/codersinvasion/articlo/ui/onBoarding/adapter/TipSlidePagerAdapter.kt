package com.codersinvasion.articlo.ui.onBoarding.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.codersinvasion.articlo.ui.onBoarding.data.TipUiState
import com.codersinvasion.articlo.ui.onBoarding.view.TipFragment

class TipSlidePagerAdapter(fragmentActivity: FragmentActivity, private val tips: List<TipUiState>) :
    FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int = tips.size

    override fun createFragment(position: Int): Fragment {
        val tip : TipUiState = tips[position]
        return TipFragment(tip)
    }
}