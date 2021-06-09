package com.app.classify.ui.detail

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.app.classify.databinding.AdDetailFragmentBinding
import com.app.classify.databinding.AdListFragmentBinding
import com.app.classify.ui.list.AdListViewModel

class AdDetail : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = AdDetailFragmentBinding.inflate(inflater)
        val application = requireNotNull(activity).application
        //To allow data binding to observe live data with life cycle of fragment
        binding.lifecycleOwner = this
        binding.fragment = this

        val adData = AdDetailArgs.fromBundle(requireArguments()).selectedAd
        val viewModelFactory = DetailViewModelFactory(adData, application)
        binding.viewModel = ViewModelProvider(
            this, viewModelFactory).get(AdDetailViewModel::class.java)
        return binding.root
    }

    fun onSearch(){
        this.findNavController().navigate(AdDetailDirections.actionAdDetailToAdList())
    }

}