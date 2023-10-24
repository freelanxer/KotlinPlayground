package com.freelanxer.kotlinplayground.activity

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.freelanxer.kotlinplayground.adapter.FeatureAdapter
import com.freelanxer.kotlinplayground.databinding.ActivityFeatureListBinding
import com.freelanxer.kotlinplayground.model.FeatureModel

class FeatureListActivity: BaseActivity(), FeatureAdapter.Listener {
    private lateinit var mBinding: ActivityFeatureListBinding
    private val featureList = listOf(
        "List View",
        "Retrofit",
    )
    private lateinit var featureAdapter: FeatureAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityFeatureListBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        featureAdapter = FeatureAdapter(createFeatureList(featureList), this)
        mBinding.featureListRv.setHasFixedSize(true)
        mBinding.featureListRv.layoutManager = LinearLayoutManager(this)
        mBinding.featureListRv.adapter = featureAdapter
    }

    private fun createFeatureList(featureArr: List<String>): List<FeatureModel> {
        val featureList = mutableListOf<FeatureModel>()
        for (name in featureArr) {
            featureList.add(FeatureModel(name))
        }
        return featureList
    }

    override fun onItemClicked(feature: FeatureModel) {
        showToast(feature.featureName)
    }

    override fun onClick(view: View?) {

    }
}