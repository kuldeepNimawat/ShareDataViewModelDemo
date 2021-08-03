package com.kuldeep.sharedataviewmodeldemo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel(){
 val userName= MutableLiveData<String>()

    fun setUserName(name: String){
        userName.value =name
    }
}