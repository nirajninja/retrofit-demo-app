package com.example.retrofit4.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NameViewModel:ViewModel()
{

    val username: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    val institution:MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }


    val rank:MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val city:MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

}