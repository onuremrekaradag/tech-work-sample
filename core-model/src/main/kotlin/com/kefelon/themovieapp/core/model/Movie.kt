package com.kefelon.themovieapp.core.model

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("poster_path")
    var posterPath: String?,
    @SerializedName("adult")
    var adult: Boolean,
    @SerializedName("overview")
    var overview: String,
    @SerializedName("release_date")
    var releaseDate: String,
    @SerializedName("genre_ids")
    var genreIds: ArrayList<Int>,
    @SerializedName("id")
    var id: Int,
    @SerializedName("original_title")
    var originalTitle: String,
    @SerializedName("original_language")
    var originalLanguage: String,
    @SerializedName("title")
    var title: String,
    @SerializedName("backdrop_path")
    var backdropPath: String?,
    @SerializedName("popularity")
    var popularity: Float,
    @SerializedName("vote_count")
    var voteCount: Int,
    @SerializedName("video")
    var video: Boolean,
    @SerializedName("vote_average")
    var voteAverage: Float
)