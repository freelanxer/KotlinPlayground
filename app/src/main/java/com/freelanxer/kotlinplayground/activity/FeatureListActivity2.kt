package com.freelanxer.kotlinplayground.activity

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.freelanxer.kotlinplayground.adapter.FeatureAdapter
import com.freelanxer.kotlinplayground.databinding.ActivityFeatureListBinding
import com.freelanxer.kotlinplayground.model.FeatureModel
import com.freelanxer.kotlinplayground.network.coroutines.ApiHelper
import com.freelanxer.kotlinplayground.network.coroutines.RetrofitBuilder
import com.freelanxer.kotlinplayground.network.coroutines.Status
import com.freelanxer.kotlinplayground.viewmodel.FeatureListVM
import com.freelanxer.kotlinplayground.viewmodel.FeatureVM
import com.freelanxer.kotlinplayground.viewmodel.ViewModelFactory

class FeatureListActivity2: BaseActivity(), FeatureAdapter.Listener {
    private lateinit var mBinding: ActivityFeatureListBinding
    private lateinit var mFeatureAdapter: FeatureAdapter
    private lateinit var mViewModel: FeatureListVM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityFeatureListBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mViewModel = ViewModelProvider(
            this,
            ViewModelFactory(ApiHelper(RetrofitBuilder.apiService)))[FeatureListVM::class.java]



        mFeatureAdapter = FeatureAdapter(this)
        mBinding.featureListRv.setHasFixedSize(true)
        mBinding.featureListRv.layoutManager = LinearLayoutManager(this)
        mBinding.featureListRv.adapter = mFeatureAdapter
        mBinding.swiperLayout.setOnRefreshListener(refreshListener)

        getFeatureList("Daniel")
    }

    private fun getFeatureList(userName: String) {
        // Observe
        mViewModel.getFeatureList(userName).observe(this, Observer {
            it?.let { resource ->
                when(resource.status) {
                    Status.SUCCESS -> {
                        mBinding.swiperLayout.isRefreshing = false
                        mFeatureAdapter.setData(resource.data?.value?.featureList)
                    }
                    Status.LOADING -> {

                    }
                    Status.ERROR -> {

                    }
                }

            }
        })
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