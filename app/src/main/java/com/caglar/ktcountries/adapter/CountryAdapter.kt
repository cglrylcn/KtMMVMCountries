package com.caglar.ktcountries.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.caglar.ktcountries.R
import com.caglar.ktcountries.databinding.ItemCountryBinding

import com.caglar.ktcountries.model.Country
import com.caglar.ktcountries.util.downloadFromUrl
import com.caglar.ktcountries.util.placeholderProgressBar
import com.caglar.ktcountries.view.FeedFragmentDirections

class CountryAdapter(private val countryList: ArrayList<Country>) : RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {
    class CountryViewHolder(private val binding: ItemCountryBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(country: Country) {
            binding.countryName.text = country.countryName
            binding.countryRegion.text = country.countryRegion
            binding.imageView.downloadFromUrl(country.imageUrl, placeholderProgressBar(binding.imageView.context))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val view = ItemCountryBinding.inflate(LayoutInflater.from(parent.context))
        return CountryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val country: Country = countryList[position]
        holder.bind(country)
        holder.itemView.setOnClickListener {
            val action = FeedFragmentDirections.actionFeedFragmentToCountryFragment()
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return countryList.size
    }

    fun updateCountryList(newCountryList: List<Country>) {
        countryList.clear()
        countryList.addAll(newCountryList)
        notifyDataSetChanged()
    }

}