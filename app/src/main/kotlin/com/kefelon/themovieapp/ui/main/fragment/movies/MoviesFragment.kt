package com.kefelon.themovieapp.ui.main.fragment.movies

import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.donanimhaber.dhandroid.dh_app_mvc.utils.EndlessRecyclerViewScrollListener
import com.kefelon.themovieapp.R
import com.kefelon.themovieapp.base.BaseFragment
import com.kefelon.themovieapp.core.model.Movie
import com.kefelon.themovieapp.databinding.FragmentMoviesBinding
import com.kefelon.themovieapp.ui.main.adapter.MovieAdapter
import com.kefelon.themovieapp.ui.main.adapter.MovieAdapterInterface
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoviesFragment :
    BaseFragment<FragmentMoviesBinding, MoviesViewModel>(), MovieAdapterInterface {

    override val mViewModel: MoviesViewModel by viewModels()

    override fun getLayoutResId(): Int = R.layout.fragment_movies

    private val adapter by lazy { MovieAdapter(arrayListOf(), this) }

    private val scrollListener by lazy {
        object :
            EndlessRecyclerViewScrollListener(binding.recyclerViewPopularMovies.layoutManager as LinearLayoutManager) {
            override fun onLoadMore(page: Int, totalItemsCount: Int) {
                if (mViewModel.loadMore) {
                    mViewModel.getMovieList(page)
                }
            }
        }
    }


    override fun init() {
        setupRecyclerView()
        observeLiveData()
    }

    private fun setupRecyclerView() {
        binding.recyclerViewPopularMovies.adapter = adapter
        binding.recyclerViewPopularMovies.addOnScrollListener(scrollListener)

    }

    private fun observeLiveData() {
        mViewModel.popularMoviesLiveData.observe(this, Observer { movieList ->
            adapter.notifyItemInsert(movieList)
        })
    }

    override fun onMovieClicked(movie: Movie) {

    }

}