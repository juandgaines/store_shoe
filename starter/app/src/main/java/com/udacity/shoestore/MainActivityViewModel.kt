package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class MainActivityViewModel : ViewModel() {

    private val _shoesList = MutableLiveData<ArrayList<Shoe>>()
    val shoesList: LiveData<ArrayList<Shoe>> get() = _shoesList

    private val _isOnBoardingCompleted = MutableLiveData<Boolean>()
    val isOnBoardingCompleted: LiveData<Boolean> get() = _isOnBoardingCompleted

    init {
        _shoesList.value = ArrayList()
        _isOnBoardingCompleted.value = false
    }

    fun addShoes(shoe: Shoe) {
        _shoesList.value?.add(shoe)
        _shoesList.value = _shoesList.value
    }

    fun setOnBoardingCompleted() {
        _isOnBoardingCompleted.value = true
    }

}