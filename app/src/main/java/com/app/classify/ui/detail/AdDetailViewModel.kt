package com.app.classify.ui.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.app.classify.model.Results

class AdDetailViewModel(ad: Results, application: Application) : AndroidViewModel(application) {

    private val _selectedAdDetail = MutableLiveData<Results>()

    // The external LiveData for the SelectedProperty
    val selectedProperty: LiveData<Results>
        get() = _selectedAdDetail

    // Initialize the _selectedProperty MutableLiveData
    init {
        _selectedAdDetail.value = ad
    }
}