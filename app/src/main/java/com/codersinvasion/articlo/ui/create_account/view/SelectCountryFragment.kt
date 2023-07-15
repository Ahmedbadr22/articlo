package com.codersinvasion.articlo.ui.create_account.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.codersinvasion.articlo.databinding.FragmentSelectCountryBinding
import com.codersinvasion.articlo.ui.create_account.adapter.CountryAdapter
import com.codersinvasion.articlo.ui.create_account.viewModel.CreateAccountViewModel
import com.codersinvasion.country.domain.model.Country
import com.codersinvasion.utils.callback.AdapterClickListener
import org.koin.androidx.viewmodel.ext.android.viewModel

class SelectCountryFragment : Fragment() {
    private lateinit var binding: FragmentSelectCountryBinding

    private val createAccountViewModel: CreateAccountViewModel by viewModel()

    private val onCountrySelectedClickListener: AdapterClickListener<Country> = AdapterClickListener { selectedCountry ->
        createAccountViewModel.onCountrySelected(selectedCountry.id)
    }

    private lateinit var countryAdapter: CountryAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSelectCountryBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initVariables()
        setupCountriesRecyclerView()

        createAccountViewModel.countriesLiveData.observe(viewLifecycleOwner) { countries ->
            countryAdapter.submitList(countries)
        }
    }

    private fun initVariables() {
        countryAdapter = CountryAdapter(onCountrySelectedClickListener)
    }

    private fun setupCountriesRecyclerView() {
        binding.rcvCountries.apply {
            adapter = countryAdapter
            layoutManager = LinearLayoutManager(requireContext())
            hasFixedSize()
        }
    }

}