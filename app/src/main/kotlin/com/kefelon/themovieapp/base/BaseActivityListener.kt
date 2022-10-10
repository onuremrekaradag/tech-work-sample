package com.kefelon.themovieapp.base

interface BaseActivityListener {


    //region SnackBar
    fun showSnackBarSuccessMessage(message: String?)

    fun showSnackBarWarningMessage(message: String?)

    fun showSnackBarErrorMessage(message: String?)

    //endregion


}