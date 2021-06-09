package com.app.classify.ui.list.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.app.classify.databinding.AdListFragmentBinding
import com.app.classify.ui.list.AdListViewModel
import com.app.classify.ui.list.adapter.AdListAdapter

class AdList : Fragment() {

    //Here I have lazy initialized AdList ViewModel to reduce startup impact on fragment
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

        binding.adList.adapter = AdListAdapter(AdListAdapter.OnClickListener {
            viewModel.displayAdDetail(it)
        })


        viewModel.navigateToAdDetail.observe(viewLifecycleOwner, {
            if (null != it) {
                // Must find the NavController from the Fragment
                this.findNavController().navigate(AdListDirections.actionShowDetail(it))
                // Tell the ViewModel we've made the navigate call to prevent multiple navigation
                viewModel.displayAdDetailComplete()
            }
        })



        return binding.root
    }


}

