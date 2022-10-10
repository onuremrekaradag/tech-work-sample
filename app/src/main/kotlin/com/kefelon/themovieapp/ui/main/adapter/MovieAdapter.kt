package com.kefelon.themovieapp.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.kefelon.themovieapp.R
import com.kefelon.themovieapp.core.model.Movie
import com.kefelon.themovieapp.databinding.ItemMovieBinding


class MovieAdapter(
    val list: ArrayList<Movie>,
    private val movieAdapterInterface: MovieAdapterInterface
) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    class MovieViewHolder(var binding: ItemMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(
            movie: Movie,
            movieAdapterInterface: MovieAdapterInterface
        ) {

            binding.movieModel = movie
            binding.listener = movieAdapterInterface


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ItemMovieBinding>(
            inflater,
            R.layout.item_movie,
            parent,
            false
        )
        return MovieViewHolder(binding)
    }


    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(list[position], movieAdapterInterface)
    }

    override fun getItemCount(): Int = list.size


    fun notifyItemInsert(movieList: List<Movie>) {
        val lastIndex = itemCount
        list.addAll(movieList)
        notifyItemRangeInserted(lastIndex, movieList.size);
    }

}