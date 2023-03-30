package com.cse3200.midterm_timers.ui.mins

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MinsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment"
    }

    var minsTimeStart = MutableLiveData<Long>().apply {
        value = 0
    }

    var minsTimeStop = MutableLiveData<Long>().apply {
        value = 0
    }

    val text: LiveData<String> = _text
}