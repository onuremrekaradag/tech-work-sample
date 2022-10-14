package com.kefelon.themovieapp.ui.detail

import android.os.Bundle
import androidx.activity.viewModels
import androidx.annotation.VisibleForTesting
import androidx.lifecycle.Observer
import com.kefelon.themovieapp.R
import com.kefelon.themovieapp.base.BaseActivity
import com.kefelon.themovieapp.core.model.MovieDetail
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
        binding.movieDetailViewModel = mViewModel
        binding.imageViewBack.setOnClickListener { onBackPressed() }

        bundleOperations()
        observeLiveData()
        mViewModel.getMovieDetail()
        setupOnClickListeners()
    }

    private fun bundleOperations() {
        intent.apply {
            mViewModel.movieId = getIntExtra("movieId", 0)
        }
    }

    private fun setupOnClickListeners() {
        binding.imageViewFavorite.setOnClickListener {
            mViewModel.triggerFavoriteMovieRoom()
            mViewModel.isFavorite = !mViewModel.isFavorite
            binding.imageViewFavorite.setImageResource(if (mViewModel.isFavorite) R.drawable.icon_favorite_filled else R.drawable.icon_favorite)
        }
    }


    private fun observeLiveData() {
        mViewModel.movieDetailLiveData.observe(this, Observer { movieDetail ->

        })

        mViewModel.processSuccess.observe(this, Observer { message ->
            showSnackBarSuccessMessage(message)
        })

        mViewModel.processError.observe(this, Observer { message ->
            showSnackBarErrorMessage(message)
        })
    }

}