package com.freelanxer.kotlinplayground.fragment

import android.content.Context
import androidx.fragment.app.Fragment
import com.freelanxer.kotlinplayground.activity.BaseActivity

open abstract class BaseFragment: Fragment() {
    private lateinit var mBaseActivity: BaseActivity

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mBaseActivity = context as BaseActivity
    }

    fun showToast(resId: Int) {
        mBaseActivity.showToast(resId)
    }

    fun showToast(message: String) {
        mBaseActivity.showToast(message)
    }
}