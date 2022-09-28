package io.hydok.simplerepository.ui

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import io.hydok.simplerepository.R
import io.hydok.simplerepository.base.BaseActivity
import io.hydok.simplerepository.databinding.ActivityMainBinding
import io.hydok.simplerepository.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.getViewModel

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    private val viewModel: MainViewModel by lazy { getViewModel() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun initData() {
        viewModel.getCatsData()
    }

    override fun setUI() {
    }

    override fun setObserver() {
        viewModel.catsData.observe(this) {
            it.forEach {
                Log.d("Data", it.url)
            }
        }
        viewModel.fetchState.observe(this) {
                Log.d("Error Fetch", it.name)
        }
    }

    override fun setListener() {
    }
}