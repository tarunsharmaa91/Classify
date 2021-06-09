package com.app.classify.ui.detail

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.app.classify.model.Results

class DetailViewModelFactory(
        private val ad: Results,
        private val application: Application
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AdDetailViewModel::class.java)) {
            return AdDetailViewModel(ad, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}