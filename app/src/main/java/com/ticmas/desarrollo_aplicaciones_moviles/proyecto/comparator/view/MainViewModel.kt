package com.ticmas.desarrollo_aplicaciones_moviles.proyecto.comparator.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ticmas.desarrollo_aplicaciones_moviles.proyecto.comparator.model.Match

class MainViewModel : ViewModel() {

    val match: LiveData<Match> get() = _match

    private var _match = MutableLiveData<Match>(Match(true))

    fun compareInputs(input1: String, input2: String) {
        _match.value = Match(input1 == input2)
    }
}