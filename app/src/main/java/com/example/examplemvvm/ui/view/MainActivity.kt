package com.example.examplemvvm.ui.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.example.examplemvvm.databinding.ActivityMainBinding
import com.example.examplemvvm.ui.viewmodel.QuoteViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding

    private val quoteViewModel: QuoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        quoteViewModel.onCreate()

        quoteViewModel.quoteModel.observe(this, Observer { currentQuote ->
            mBinding.tvQuote.text = currentQuote.quote
            mBinding.tvAuthor.text = currentQuote.author
        })

        quoteViewModel.isLoading.observe(this, Observer {
            mBinding.progress.isVisible = it
        })

        mBinding.viewContainer.setOnClickListener {
            quoteViewModel.randomQuote()
        }
    }
}