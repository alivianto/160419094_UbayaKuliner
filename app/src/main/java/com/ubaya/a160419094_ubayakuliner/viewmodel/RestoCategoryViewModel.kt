package com.ubaya.a160419094_ubayakuliner.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.ubaya.a160419094_ubayakuliner.model.Category

class RestoCategoryViewModel(application: Application) : AndroidViewModel(application) {
    val restoCategoryLD = MutableLiveData<ArrayList<Category>>()
    val restoCategoryLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()

    fun refresh(){
        restoCategoryLD.value = arrayListOf(
            Category(" All "),
            Category("Fast Food"),
            Category("Western"),
            Category("Chicken & Duck"),
            Category("Coffee")
        )

        loadingLD.value = false
        restoCategoryLoadErrorLD.value = false

    }
}