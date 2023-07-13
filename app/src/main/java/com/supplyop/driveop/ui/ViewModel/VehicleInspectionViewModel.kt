package com.supplyop.driveop.ui.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class VehicleInspectionViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Vehicle Inspection Screen"
    }
    val text: LiveData<String> = _text
}