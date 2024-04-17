package com.project.featurekotlin.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.project.featurekotlin.R
import com.project.featurekotlin.databinding.KotlinActivityMainBinding
import com.project.featurekotlin.viewModel.ViewModel

class KotlinMainActivity : AppCompatActivity() {

    private var mBinding: KotlinActivityMainBinding? = null
    private val binding get() = mBinding!!
    private val viewModel: ViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = KotlinActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bindAction()
        bindState()
    }

    private fun bindState() {
        viewModel.data.num.observe(this) { newValue ->
            binding.textView4.text = newValue.toString()
        }
    }

    private fun bindAction() {
        binding.titleView.iconLeft1.setOnClickListener { finish() }
        binding.titleView.title.text = "코틀린 MVVM"
        binding.buttonMinus.setOnClickListener {
            viewModel.minus()
        }

        binding.buttonPlus.setOnClickListener {
            viewModel.plus()
        }
    }
}