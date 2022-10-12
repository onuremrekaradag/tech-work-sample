package com.kefelon.themovieapp.ui.main.fragment.favorite_movies

import android.content.Intent
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.donanimhaber.dhandroid.dh_app_mvc.utils.EndlessRecyclerViewScrollListener
import com.kefelon.themovieapp.R
import com.kefelon.themovieapp.base.BaseFragment
import com.kefelon.themovieapp.core.model.Movie
import com.kefelon.themovieapp.core.model.MovieDetail
import com.kefelon.themovieapp.databinding.FragmentFavoriteMoviesBinding
import com.kefelon.themovieapp.databinding.FragmentMoviesBinding
import com.kefelon.themovieapp.ui.detail.MovieDetailActivity
import com.kefelon.themovieapp.ui.main.adapter.MovieAdapter
import com.kefelon.themovieapp.ui.main.adapter.MovieAdapterInterface
import com.kefelon.themovieapp.ui.main.fragment.favorite_movies.adapter.FavoriteMovieAdapterInterface
import com.kefelon.themovieapp.ui.main.fragment.favorite_movies.adapter.FavoriteMoviesAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteMoviesFragment :
    BaseFragment<FragmentFavoriteMoviesBinding, FavoriteMoviesViewModel>(),
    FavoriteMoviesFragmentInterface, FavoriteMovieAdapterInterface {

    override val mViewModel: FavoriteMoviesViewModel by viewModels()

    override fun getLayoutResId(): Int = R.layout.fragment_favorite_movies

    private val favoriteMoviesAdapter by lazy { FavoriteMoviesAdapter(arrayListOf(), this) }


    override fun init() {
        binding.listener = this
        setupRecyclerView()
        setupSwipeRefreshListener()
        observeLiveData()
    }

    private fun setupRecyclerView() {
        binding.recyclerViewFavoriteMovies.adapter = favoriteMoviesAdapter
    }

    private fun setupSwipeRefreshListener() {
        binding.swipeRefreshLayoutFavoriteMovies.setOnRefreshListener {
            onRefresh()
        }
    }

    private fun observeLiveData() {
        mViewModel.favoriteMoviesLiveData.observe(this, Observer { movieList ->
            favoriteMoviesAdapter.notifyItemInsert(movieList)
        })

        mViewModel.processError.observe(this, Observer { message ->
            showSnackBarErrorMessage(message)
        })
    }

    override fun onMovieClicked(movieDetail: MovieDetail) {
        val intent = Intent(context, MovieDetailActivity::class.java)
        intent.putExtra("movieId", movieDetail.id)
        startActivity(intent)
    }

    override fun onRefresh() {
        mViewModel.getFavoriteMovieList()
    }


}