package com.kefelon.themovieapp.core.model

import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("page")
    var page: Int,
    @SerializedName("results")
    var results: ArrayList<Movie>,
    @SerializedName("total_pages")
    var totalPages: Int,
    @SerializedName("total_results")
    var totalResults: Int
)