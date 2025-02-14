package com.kefelon.themovieapp.base

import android.widget.EditText
import com.kefelon.themovieapp.R
import com.kefelon.themovieapp.databinding.ActivityBaseBinding
import com.kefelon.themovieapp.extensions.showSnackBar


import android.content.Context

import android.os.Bundle

import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.FrameLayout
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity


import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<DB : ViewDataBinding, VM : BaseViewModel> : AppCompatActivity(),
    BaseActivityListener {

    lateinit var imm: InputMethodManager
    lateinit var binding: DB

    @LayoutRes
    abstract fun getLayoutRes(): Int

    //Inject view model in activities with "by viewModels()"
    protected abstract val mViewModel: VM


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, getLayoutRes())
        binding.lifecycleOwner = this

        imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    }

    override fun onResume() {
        super.onResume()

    }

    override fun onStop() {
        super.onStop()

    }


    //region SnackBar
    override fun showSnackBarSuccessMessage(message: String?) {
        binding.root.showSnackBar(message, R.color.success_snackbar_background)
    }

    override fun showSnackBarWarningMessage(message: String?) {
        binding.root.showSnackBar(message, R.color.warning_snackbar_background)
    }

    override fun showSnackBarErrorMessage(message: String?) {
        binding.root.showSnackBar(message, R.color.error_snackbar_background)
    }
    //endregion


    //region Keyboard operations

    /**
     * closes keyboard for requested View
     */
    open fun closeSoftKeyboard(view: View) {
        imm = this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

    /**
     * shows keyboard for requested EditText
     */
    open fun showSoftKeyboard(editText: EditText) {
        if (!imm.isAcceptingText) {
            imm.showSoftInput(editText, 0)
        }
    }

    //endregion


}