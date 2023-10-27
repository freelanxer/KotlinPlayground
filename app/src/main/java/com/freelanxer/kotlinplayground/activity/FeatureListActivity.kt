package com.freelanxer.kotlinplayground.activity

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.freelanxer.kotlinplayground.adapter.FeatureAdapter
import com.freelanxer.kotlinplayground.databinding.ActivityFeatureListBinding
import com.freelanxer.kotlinplayground.model.FeatureModel
import com.freelanxer.kotlinplayground.viewmodel.FeatureVM

class FeatureListActivity: BaseActivity(), FeatureAdapter.Listener {
    private lateinit var mBinding: ActivityFeatureListBinding
    private lateinit var mFeatureAdapter: FeatureAdapter
    private val mFeatureVM by viewModels<FeatureVM>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityFeatureListBinding.inflate(layoutInflater)
        setContentView(mBinding.root)


        // Observe
        mFeatureVM.featureListModel.observe(this) { listModel ->
            mBinding.swiperLayout.isRefreshing = false
            mFeatureAdapter.setData(listModel.featureList)
        }

        mFeatureAdapter = FeatureAdapter(this)
        mBinding.featureListRv.setHasFixedSize(true)
        mBinding.featureListRv.layoutManager = LinearLayoutManager(this)
        mBinding.featureListRv.adapter = mFeatureAdapter
        mBinding.swiperLayout.setOnRefreshListener(refreshListener)

        getFeatureList("Daniel")
    }

    private fun getFeatureList(userName: String) {
        mFeatureVM.getFeatureList(userName)
    }

    private val refreshListener = SwipeRefreshLayout.OnRefreshListener {
        getFeatureList("Daniel")
    }

    override fun onItemClicked(feature: FeatureModel?) {
        if (feature == null)
            return
        showToast(feature.featureName)
    }

    override fun onClick(view: View?) {

    }
}