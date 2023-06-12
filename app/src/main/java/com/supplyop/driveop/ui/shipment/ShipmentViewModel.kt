package com.supplyop.driveop.ui.shipment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShipmentViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Shipments Screen"
    }
    val text: LiveData<String> = _text
}