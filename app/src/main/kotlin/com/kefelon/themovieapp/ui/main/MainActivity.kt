package com.kefelon.themovieapp.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import com.kefelon.themovieapp.R
import com.kefelon.themovieapp.base.BaseActivity
import com.kefelon.themovieapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    override val mViewModel: MainViewModel by viewModels()

    override fun getLayoutRes(): Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}