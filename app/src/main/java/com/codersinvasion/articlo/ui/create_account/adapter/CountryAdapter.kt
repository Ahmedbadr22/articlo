package com.codersinvasion.articlo.ui.create_account.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.codersinvasion.articlo.databinding.CountryCardBinding
import com.codersinvasion.country.domain.model.Country
import com.codersinvasion.country.domain.model.CountryUiState
import com.codersinvasion.utils.callback.AdapterClickListener
import com.codersinvasion.utils.callback.DiffCallback

class CountryAdapter(
    private val brandClickListener: AdapterClickListener<Country>,
) : ListAdapter<CountryUiState, CountryAdapter.BrandViewHolder>(DiffCallback<CountryUiState>()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BrandViewHolder {
        return BrandViewHolder.form(parent)
    }

    override fun onBindViewHolder(holder: BrandViewHolder, position: Int) {
        val category = getItem(position)
        holder.bind(brandClickListener, category)
    }

    class BrandViewHolder(private val binding: CountryCardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(
            listener: AdapterClickListener<Country>,
            countryItem: CountryUiState,
        ) {
            binding.apply {
                countryUiState = countryItem
                clickListener = listener
                executePendingBindings()
            }
        }

        companion object {
            fun form(parent: ViewGroup): BrandViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = CountryCardBinding.inflate(layoutInflater, parent, false)
                return BrandViewHolder(binding)
            }
        }
    }
}