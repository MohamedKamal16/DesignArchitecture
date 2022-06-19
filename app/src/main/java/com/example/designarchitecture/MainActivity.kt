package com.example.designarchitecture

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.designarchitecture.databinding.ActivityMainBinding
import com.example.designarchitecture.model.DataBase
import com.example.designarchitecture.presenter.CalculatePresenter
import com.example.designarchitecture.presenter.ICalculate
import com.example.designarchitecture.viewModel.MainActivityViewModel

class MainActivity : AppCompatActivity() , ICalculate{
    private lateinit var binding:ActivityMainBinding

    private lateinit var data:DataBase

    private lateinit var presenter:CalculatePresenter

    private lateinit var viewModel:MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        //MVC
         data=DataBase()
        addTwoNumbers()

        //MVP
        presenter=CalculatePresenter(this)
        divTwoNumbers()

        //MVVM
        viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]
        multTwoNumbers()
        viewModel.result.observe(this, Observer {
            binding.tvMult.text=it.toString()
        })

    }

  //MVC
    private fun addTwoNumbers() {
        binding.plusButton.setOnClickListener {
        val result=data.numbers.firstNum +data.numbers.secondNum
            binding.tvPlus.text=result.toString()
        }
    }

    //MVP
    override fun getResult(result: Int) {
        binding.tvDiv.text=result.toString()
    }
    private fun divTwoNumbers() {
        binding.divButton.setOnClickListener {
           presenter.getDevResult()
        }
    }
    //MVVM
    private fun multTwoNumbers() {
        binding.mulButton.setOnClickListener {
           viewModel.getResult()
        }
    }

}