package com.kefelon.themovieapp.ui.main.fragment.favorite_movies.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.kefelon.themovieapp.R
import com.kefelon.themovieapp.core.model.MovieDetail
import com.kefelon.themovieapp.databinding.ItemFavoriteMovieBinding


class FavoriteMoviesAdapter(
    val list: ArrayList<MovieDetail>,
    private val favoriteMovieAdapterInterface: FavoriteMovieAdapterInterface
) : RecyclerView.Adapter<FavoriteMoviesAdapter.MovieViewHolder>(), FavoriteMovieAdapterInterface {


    class MovieViewHolder(var binding: ItemFavoriteMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(
            movieDetail: MovieDetail,
            favoriteMovieAdapterInterface: FavoriteMovieAdapterInterface
        ) {

            binding.movieModel = movieDetail
            binding.listener = favoriteMovieAdapterInterface


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ItemFavoriteMovieBinding>(
            inflater,
            R.layout.item_favorite_movie,
            parent,
            false
        )
        return MovieViewHolder(binding)
    }


    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(list[position], favoriteMovieAdapterInterface)
    }

    override fun getItemCount(): Int = list.size


    fun notifyItemInsert(movieDetailList: List<MovieDetail>) {
        val lastIndex = itemCount
        list.addAll(movieDetailList)
        notifyItemRangeInserted(lastIndex, movieDetailList.size);
    }

    override fun onMovieClicked(movieDetail: MovieDetail) {

    }

}