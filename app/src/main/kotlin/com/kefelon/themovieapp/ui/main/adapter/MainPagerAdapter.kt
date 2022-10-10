package com.kefelon.themovieapp.ui.main.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.kefelon.themovieapp.ui.main.enum.MainPagerEnum
import com.kefelon.themovieapp.ui.main.fragment.favorite_movies.FavoriteMoviesFragment
import com.kefelon.themovieapp.ui.main.fragment.movies.MoviesFragment

class MainPagerAdapter(private val lifecyle: Lifecycle, fragmentManager: FragmentManager) :
    FragmentStateAdapter(fragmentManager, lifecyle) {

    override fun getItemCount(): Int = 2



    override fun createFragment(position: Int): Fragment {
        return if (position == MainPagerEnum.MOVIES.ordinal) MoviesFragment() else FavoriteMoviesFragment()
    }


}