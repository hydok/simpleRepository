package io.hydok.simplerepository.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

/**
* Base
* @author hydok
* @version 1.0.0
* @since 2022/09/28 11:18 오전
**/
abstract class BaseActivity<VB: ViewDataBinding>(private val layoutRes: Int): AppCompatActivity() {

    lateinit var binding : VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutRes)

        initData()
        setUI()
        setObserver()
        setListener()
    }


    protected abstract fun initData()
    protected abstract fun setUI()
    protected abstract fun setObserver()
    protected abstract fun setListener()
}