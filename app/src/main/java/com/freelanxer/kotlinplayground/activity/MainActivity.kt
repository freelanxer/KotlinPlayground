package com.freelanxer.kotlinplayground.activity

import android.os.Bundle
import android.view.View
import com.freelanxer.kotlinplayground.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {
    private lateinit var mBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
    }

    override fun onClick(p0: View?) {

    }

}