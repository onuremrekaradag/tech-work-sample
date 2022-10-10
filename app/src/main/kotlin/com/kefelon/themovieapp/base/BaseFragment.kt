package com.kefelon.themovieapp.base

import android.widget.EditText
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.kefelon.themovieapp.R
import com.kefelon.themovieapp.extensions.showSnackBar
import dagger.hilt.android.internal.managers.ViewComponentManager

abstract class BaseFragment<DB : ViewDataBinding, VM : BaseViewModel> : Fragment() {

    protected lateinit var binding: DB
    var mContext: Context? = null

    protected abstract val mViewModel: VM

    lateinit var imm: InputMethodManager

    @LayoutRes
    abstract fun getLayoutResId(): Int


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, getLayoutResId(), container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imm = context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        doBinding()
    }

    abstract fun init()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = if (context is ViewComponentManager.FragmentContextWrapper)
            requireActivity()
        else
            context
    }

    private fun doBinding() {
        binding.lifecycleOwner = viewLifecycleOwner
        init()
    }

    private var visibility = false //Defines fragment is visible to user for viewpager

    /**
     * Detect user visible hint
     */
    open fun getVisibleToUser(isVisible: Boolean) {}


    override fun setMenuVisibility(menuVisible: Boolean) {
        super.setMenuVisibility(menuVisible)
        visibility = menuVisible
    }

    override fun onResume() {
        super.onResume()
        getVisibleToUser(isAdded && visibility)
    }

    //region SnackBar
    fun showSnackBarSuccessMessage(message: String?) {
        binding.root.showSnackBar(message, R.color.success_snackbar_background)
    }

    fun showSnackBarWarningMessage(message: String?) {
        binding.root.showSnackBar(message, R.color.warning_snackbar_background)
    }

    fun showSnackBarErrorMessage(message: String?) {
        binding.root.showSnackBar(message, R.color.error_snackbar_background)
    }
    //endregion


    /**
     * closes keyboard for requested View
     */
    open fun closeSoftKeyboard(view: View) {
        imm = context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
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

}