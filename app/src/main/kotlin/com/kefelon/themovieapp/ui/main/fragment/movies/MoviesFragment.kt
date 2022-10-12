package com.kefelon.themovieapp.ui.main.fragment.movies

import android.content.Intent
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.donanimhaber.dhandroid.dh_app_mvc.utils.EndlessRecyclerViewScrollListener
import com.kefelon.themovieapp.R
import com.kefelon.themovieapp.base.BaseFragment
import com.kefelon.themovieapp.core.model.Movie
import com.kefelon.themovieapp.databinding.FragmentMoviesBinding
import com.kefelon.themovieapp.ui.detail.MovieDetailActivity
import com.kefelon.themovieapp.ui.main.adapter.MovieAdapter
import com.kefelon.themovieapp.ui.main.adapter.MovieAdapterInterface
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoviesFragment :
    BaseFragment<FragmentMoviesBinding, MoviesViewModel>(), MovieAdapterInterface {

    override val mViewModel: MoviesViewModel by viewModels()

    override fun getLayoutResId(): Int = R.layout.fragment_movies

    private val popularMoviesAdapter by lazy { MovieAdapter(arrayListOf(), this) }
    private val nowPlayingMoviesAdapter by lazy { MovieAdapter(arrayListOf(), this) }
    private val topRatedMoviesAdapter by lazy { MovieAdapter(arrayListOf(), this) }
    private val upcomingMoviesAdapter by lazy { MovieAdapter(arrayListOf(), this) }


    override fun init() {
        setupRecyclerView()
        observeLiveData()
    }

    private fun setupRecyclerView() {
        binding.recyclerViewPopularMovies.adapter = popularMoviesAdapter
        binding.recyclerViewPopularMovies.addOnScrollListener(popularMoviesScrollListener)

        binding.recyclerViewNowPlayingMovies.adapter = nowPlayingMoviesAdapter
        binding.recyclerViewNowPlayingMovies.addOnScrollListener(nowPlayingMoviesScrollListener)

        binding.recyclerViewTopRatedMovies.adapter = topRatedMoviesAdapter
        binding.recyclerViewTopRatedMovies.addOnScrollListener(topRatedMoviesScrollListener)

        binding.recyclerViewUpcomingMovies.adapter = upcomingMoviesAdapter
        binding.recyclerViewUpcomingMovies.addOnScrollListener(upcomingMoviesScrollListener)

    }

    private fun observeLiveData() {
        mViewModel.popularMoviesLiveData.observe(this, Observer { movieList ->
            popularMoviesAdapter.notifyItemInsert(movieList)
        })

        mViewModel.nowPlayingMoviesLiveData.observe(this, Observer { movieList ->
            nowPlayingMoviesAdapter.notifyItemInsert(movieList)
        })

        mViewModel.topRatedMoviesLiveData.observe(this, Observer { movieList ->
            topRatedMoviesAdapter.notifyItemInsert(movieList)
        })

        mViewModel.upcomingMoviesLiveData.observe(this, Observer { movieList ->
            upcomingMoviesAdapter.notifyItemInsert(movieList)
        })

        mViewModel.processError.observe(this, Observer { message ->
            showSnackBarErrorMessage(message)
        })
    }

    override fun onMovieClicked(movie: Movie) {
        val intent = Intent(context, MovieDetailActivity::class.java)
        intent.putExtra("movieId", movie.id)
        startActivity(intent)
    }

    private val popularMoviesScrollListener by lazy {
        object :
            EndlessRecyclerViewScrollListener(binding.recyclerViewPopularMovies.layoutManager as LinearLayoutManager) {
            override fun onLoadMore(page: Int, totalItemsCount: Int) {
                if (mViewModel.popularMoviesLoadMore) {
                    mViewModel.getPopularMovieList(page)
                }
            }
        }
    }

    private val nowPlayingMoviesScrollListener by lazy {
        object :
            EndlessRecyclerViewScrollListener(binding.recyclerViewNowPlayingMovies.layoutManager as LinearLayoutManager) {
            override fun onLoadMore(page: Int, totalItemsCount: Int) {
                if (mViewModel.nowPlayingMoviesLoadMore) {
                    mViewModel.getNowPlayingList(page)
                }
            }
        }
    }

    private val topRatedMoviesScrollListener by lazy {
        object :
            EndlessRecyclerViewScrollListener(binding.recyclerViewTopRatedMovies.layoutManager as LinearLayoutManager) {
            override fun onLoadMore(page: Int, totalItemsCount: Int) {
                if (mViewModel.topRatedMoviesLoadMore) {
                    mViewModel.getTopRatedMovies(page)
                }
            }
        }
    }

    private val upcomingMoviesScrollListener by lazy {
        object :
            EndlessRecyclerViewScrollListener(binding.recyclerViewUpcomingMovies.layoutManager as LinearLayoutManager) {
            override fun onLoadMore(page: Int, totalItemsCount: Int) {
                if (mViewModel.upcomingMoviesLoadMore) {
                    mViewModel.getUpcomingMovies(page)
                }
            }
        }
    }


}