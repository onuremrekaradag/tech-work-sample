package com.kefelon.themovieapp.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import com.kefelon.themovieapp.R
import com.kefelon.themovieapp.base.BaseActivity
import com.kefelon.themovieapp.databinding.ActivityMainBinding
import com.kefelon.themovieapp.ui.main.adapter.MainPagerAdapter
import com.kefelon.themovieapp.ui.main.enum.MainPagerEnum
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    override val mViewModel: MainViewModel by viewModels()

    override fun getLayoutRes(): Int = R.layout.activity_main

    lateinit var mainPagerAdapter: MainPagerAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupMainPager()
        setupBottomNavigationView()

    }

    private fun setupMainPager() {
        mainPagerAdapter = MainPagerAdapter(lifecycle, supportFragmentManager)
        binding.pager.adapter = mainPagerAdapter
        binding.pager.offscreenPageLimit = 2
    }

    private fun setupBottomNavigationView(){
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.movies -> {
                    binding.pager.currentItem = MainPagerEnum.MOVIES.ordinal
                    true
                }
                R.id.favorite_movies -> {
                    binding.pager.currentItem = MainPagerEnum.FAVORITE_MOVIES.ordinal
                    true
                }
                else -> false
            }
        }
    }
}