package com.kefelon.themovieapp.ui.main.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.kefelon.themovieapp.ui.main.enum.MainPagerEnum
import com.kefelon.themovieapp.ui.main.fragment.favorite_movies.FavoriteMoviesFragment
import com.kefelon.themovieapp.ui.main.fragment.movies.MoviesFragment

class MainPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int = 2



    override fun createFragment(position: Int): Fragment {
        return if (position == MainPagerEnum.MOVIES.ordinal) MoviesFragment() else FavoriteMoviesFragment()
    }


}