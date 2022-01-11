package com.example.myviewmodel

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.myviewmodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding
//    private lateinit var viewModel: MainViewModel
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

//        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        displayResult()

        activityMainBinding.apply {
            btnCalculate.setOnClickListener {

                val width = etWidth.text.toString()
                val height = etHeight.text.toString()
                val length = etLength.text.toString()

                when {
                    width.isEmpty() -> {
                        etWidth.error = "Masih kosong"
                    }
                    height.isEmpty() -> {
                        etHeight.error = "Masih kosong"
                    }
                    length.isEmpty() -> {
                        etLength.error = "Masih kosong"
                    }
                    else -> {
                        viewModel.calculate(width, height, length)
                        displayResult()
                    }
                }
            }
        }
    }

    private fun displayResult() {
        activityMainBinding.tvResult.text = viewModel.result.toString()
    }
}