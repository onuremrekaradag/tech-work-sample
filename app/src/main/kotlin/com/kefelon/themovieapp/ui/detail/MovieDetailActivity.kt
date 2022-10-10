package com.kefelon.themovieapp.ui.detail

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.kefelon.themovieapp.R
import com.kefelon.themovieapp.base.BaseActivity
import com.kefelon.themovieapp.databinding.ActivityMainBinding
import com.kefelon.themovieapp.databinding.ActivityMovieDetailBinding
import com.kefelon.themovieapp.ui.main.adapter.MainPagerAdapter
import com.kefelon.themovieapp.ui.main.enum.MainPagerEnum
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class MovieDetailActivity : BaseActivity<ActivityMovieDetailBinding, MovieDetailViewModel>() {

    override val mViewModel: MovieDetailViewModel by viewModels()

    override fun getLayoutRes(): Int = R.layout.activity_movie_detail


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        binding.lifecycleOwner = this

        binding.movieDetailViewModel = mViewModel

        bundleOperations()
        observeLiveData()
        mViewModel.getMovieDetail()
    }

    private fun bundleOperations() {
        intent.apply {
            mViewModel.movieId = getIntExtra("movieId", 0)
        }
    }

    private fun observeLiveData() {
        mViewModel.movieDetailLiveData.observe(this, Observer { movieDetail ->

        })

        mViewModel.processError.observe(this, Observer { message ->
            showSnackBarErrorMessage(message)
        })
    }

}