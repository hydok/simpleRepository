package io.hydok.simplerepository.ui

import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import io.hydok.simplerepository.R
import io.hydok.simplerepository.base.BaseActivity
import io.hydok.simplerepository.base.FetchState
import io.hydok.simplerepository.databinding.ActivityMainBinding
import io.hydok.simplerepository.viewmodel.MainViewModel
import io.hydok.simplerepository.viewmodel.RecyclerAdapter
import org.koin.androidx.viewmodel.ext.android.getViewModel

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    private val viewModel: MainViewModel by lazy { getViewModel() }
    private val recyclerAdapter: RecyclerAdapter by lazy { RecyclerAdapter() }

    override fun initData() {
        binding.vm = viewModel
        viewModel.getCatsData()
    }
    //test
    override fun setUI() {
        binding.recyclerview.apply {
            layoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
            adapter = recyclerAdapter
            setHasFixedSize(true)
        }
    }

    override fun setObserver() {
        viewModel.catsData.observe(this) {
            recyclerAdapter.setDatas(it)
        }

        viewModel.fetchState.observe(this)
        {
            //Error!!
            Log.d("Error Fetch", it.name)
        }

        viewModel.fetchState.observe(this){
            
        }
    }

    override fun setListener() {
    }
}