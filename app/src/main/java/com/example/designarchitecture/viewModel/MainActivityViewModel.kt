package com.example.designarchitecture.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.designarchitecture.model.DataBase

class MainActivityViewModel:ViewModel(){

    var result=MutableLiveData<Int>()

    private fun divNumber():Int{
        val dataBase = DataBase()
        return  dataBase.numbers.firstNum * dataBase.numbers.secondNum

    }

    fun getResult(){
        result.postValue(divNumber())
    }





}