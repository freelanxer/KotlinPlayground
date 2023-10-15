package com.freelanxer.kotlinplayground.activity

import android.text.TextUtils
import android.view.View.OnClickListener
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

open abstract class BaseActivity: AppCompatActivity(), OnClickListener {

    fun showToast(resId: Int) {
        val message = getString(resId)
        showToast(message)
    }

    fun showToast(message: String) {
        if (TextUtils.isEmpty(message))
            return
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}