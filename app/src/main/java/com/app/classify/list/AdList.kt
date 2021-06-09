package com.app.classify.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.app.classify.R
import com.app.classify.databinding.AdListFragmentBinding

class AdList : Fragment() {

    //Here I have lazy initialized AdList ViewModel
    private val viewModel: AdListViewModel by lazy {
        ViewModelProvider(this).get(AdListViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = AdListFragmentBinding.inflate(inflater)

        //To allow data binding to observe live data with life cycle of fragment
        binding.lifecycleOwner = this

        //Now I have to give binding access to AdListViewModel
        binding.viewModel = viewModel

        return binding.root
    }


}