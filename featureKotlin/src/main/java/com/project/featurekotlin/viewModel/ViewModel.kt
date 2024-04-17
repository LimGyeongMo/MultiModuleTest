package com.project.featurekotlin.viewModel

import androidx.lifecycle.ViewModel
import com.project.featurekotlin.model.Count

class ViewModel : ViewModel() {
    var data = Count()

    fun plus() {
       val currentNum = data.num.value ?: 0
        data.num.value = currentNum + 1
    }

    fun minus() {
        val currentNum = data.num.value ?: 0
        data.num.value = currentNum - 1
    }
}

