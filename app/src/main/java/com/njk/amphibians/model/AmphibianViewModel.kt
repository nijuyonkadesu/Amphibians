package com.njk.amphibians.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.njk.amphibians.network.Amphibian
import com.njk.amphibians.network.AmphibianApi
import kotlinx.coroutines.launch

enum class AmphibianApiStatus { LOADING, ERROR, DONE }

class AmphibianViewModel: ViewModel() {
    private var _status = MutableLiveData<AmphibianApiStatus>()
    val status: LiveData<AmphibianApiStatus> get() = _status

    private var _amphibians = MutableLiveData<List<Amphibian>>()
    val amphibians: LiveData<List<Amphibian>> get() = _amphibians

    private var _amphibian = MutableLiveData<Amphibian>()
    val amphibian: LiveData<Amphibian> get() = _amphibian

    fun getAmphibianList(){
        viewModelScope.launch {
            _status.value = AmphibianApiStatus.LOADING
            try {
                _amphibians.value = AmphibianApi.retrofitService.getAmphibian()
                _status.value = AmphibianApiStatus.DONE
            } catch (e: Exception) {
                _status.value = AmphibianApiStatus.ERROR
                _amphibians.value = listOf()
            }
        }
    }
    fun onAmphibianClicked(amphibian: Amphibian) {
        _amphibian.value = amphibian
    }
}