package com.freelanxer.kotlinplayground.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
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

    private fun launchMenuActivity() {
        val intent = Intent(this, FeatureListActivity2::class.java)
        menuLauncher.launch(intent)
    }

    private val menuLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        showToast("Welcome back !")
        when(it.resultCode) {
            RESULT_OK -> {

            }
        }
    }

    override fun onClick(view: View?) {
        if (view == null)
            return
        if (view == mBinding.startBtn) {
            showToast(R.string.start)
            launchMenuActivity()
        }
    }

}