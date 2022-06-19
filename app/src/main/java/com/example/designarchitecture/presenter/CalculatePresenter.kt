package com.example.designarchitecture.presenter

import com.example.designarchitecture.model.DataBase

class CalculatePresenter(private val calculate:ICalculate) {
    private fun divNumber(): Int {
        val dataBase = DataBase()
        return dataBase.numbers.firstNum / dataBase.numbers.secondNum
    }

    fun getDevResult(){
        calculate.getResult(divNumber())
    }
}