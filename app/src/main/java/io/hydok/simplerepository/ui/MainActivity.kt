package io.hydok.simplerepository.ui

import android.os.Bundle
import io.hydok.simplerepository.R
import io.hydok.simplerepository.base.BaseActivity
import io.hydok.simplerepository.databinding.ActivityMainBinding
import io.hydok.simplerepository.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.getViewModel

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    val viewModel :MainViewModel = getViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun initData() {
    }

    override fun setUI() {
    }

    override fun setObserver() {
    }

    override fun setListener() {
    }
}