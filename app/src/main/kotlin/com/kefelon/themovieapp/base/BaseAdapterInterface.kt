package com.kefelon.themovieapp.base

import android.view.View

interface BaseAdapterInterface<T:Any> {
    fun bindData(item: T,view: View)
}