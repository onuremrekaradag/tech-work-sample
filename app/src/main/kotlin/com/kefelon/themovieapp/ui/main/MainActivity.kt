package com.kefelon.themovieapp.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.get
import androidx.core.view.size
import androidx.viewpager2.widget.ViewPager2
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
        setupMainPager()
        setupBottomNavigationView()

    }

    private fun setupMainPager() {
        mainPagerAdapter = MainPagerAdapter(this)
        binding.pager.adapter = mainPagerAdapter
        binding.pager.offscreenPageLimit = 2
        binding.pager.registerOnPageChangeCallback(viewPagerPageChangeListener)
    }

    private val viewPagerPageChangeListener = object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)
            if (position <= binding.bottomNavigation.menu.size) {
                binding.bottomNavigation.menu[position].isChecked = true
            }
        }
    }

    private fun setupBottomNavigationView() {
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

    override fun onDestroy() {
        super.onDestroy()
        binding.pager.unregisterOnPageChangeCallback(viewPagerPageChangeListener)
    }
}