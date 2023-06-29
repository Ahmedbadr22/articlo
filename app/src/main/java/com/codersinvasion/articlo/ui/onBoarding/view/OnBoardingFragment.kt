package com.codersinvasion.articlo.ui.onBoarding.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.codersinvasion.articlo.R
import com.codersinvasion.articlo.databinding.FragmentOnBoardingBinding
import com.codersinvasion.articlo.ui.onBoarding.adapter.TipSlidePagerAdapter
import com.codersinvasion.articlo.ui.onBoarding.data.TipUiState
import kotlin.properties.Delegates

class OnBoardingFragment : Fragment() {
    private lateinit var binding: FragmentOnBoardingBinding


    private lateinit var tips: List<TipUiState>

    var pagePosition: Int by Delegates.observable(0) { _, _, newPosition ->
        selectDot(newPosition)
        if (newPosition == 2) setNextButtonName(R.string.start)
        else setNextButtonName(R.string.next)
        binding.vpTipsFragment.currentItem = newPosition
    }

    private val onPageScrollChangeCallback = object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)
            pagePosition = position
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnBoardingBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        selectDot(pagePosition)


        tips = listOf(
            TipUiState(
                R.drawable.read,
                getString(R.string.on_boarding_0_title),
                getString(R.string.on_boarding_0_subtitle)
            ),
            TipUiState(
                R.drawable.create,
                getString(R.string.on_boarding_1_title),
                getString(R.string.on_boarding_1_subtitle)
            ),
            TipUiState(
                R.drawable.connect,
                getString(R.string.on_boarding_2_title),
                getString(R.string.on_boarding_2_subtitle)
            ),
        )

        binding.apply {
            lifecycleOwner = this@OnBoardingFragment
            vpTipsFragment.adapter = TipSlidePagerAdapter(requireActivity(), tips)

            btnNext.setOnClickListener {
                if (pagePosition < 2) pagePosition += 1
                else navigateToLoginScreen()
            }
        }
    }

    private fun navigateToLoginScreen() {
        val navAction = OnBoardingFragmentDirections.actionOnBoardingFragmentToLoginFragment()
        findNavController().navigate(navAction)
    }

    private fun setNextButtonName(@StringRes stringRes: Int) {
        binding.btnNext.text = getString(stringRes)
    }

    override fun onResume() {
        super.onResume()
        binding.vpTipsFragment.registerOnPageChangeCallback(onPageScrollChangeCallback)
    }

    override fun onPause() {
        super.onPause()
        binding.vpTipsFragment.unregisterOnPageChangeCallback(onPageScrollChangeCallback)
    }

    private fun selectDot(index: Int) {
        val selectedDotColor: Int = ContextCompat.getColor(requireContext(), R.color.brown)
        val unselectedDotColor: Int = ContextCompat.getColor(requireContext(), R.color.gray)

        binding.apply {
            dotView0View.setBackgroundColor(if (index == 0) selectedDotColor else unselectedDotColor)
            dotView1View.setBackgroundColor(if (index == 1) selectedDotColor else unselectedDotColor)
            dotView2View.setBackgroundColor(if (index == 2) selectedDotColor else unselectedDotColor)
        }
    }
}