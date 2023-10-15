package com.freelanxer.kotlinplayground.activity

import android.os.Bundle
import android.view.View
import com.freelanxer.kotlinplayground.R
import com.freelanxer.kotlinplayground.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {
    private lateinit var mBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mBinding.startBtn.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        if (view == null)
            return
        if (view == mBinding.startBtn)
            showToast(R.string.start)
    }

}