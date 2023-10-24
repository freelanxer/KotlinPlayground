package com.freelanxer.kotlinplayground.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.freelanxer.kotlinplayground.databinding.ListItemFeatureBinding
import com.freelanxer.kotlinplayground.model.FeatureModel

class FeatureAdapter(
    private val data: List<FeatureModel>,
    private val mListener: Listener?
):
    RecyclerView.Adapter<FeatureAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListItemFeatureBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val feature = data[position]
        holder.bind(feature)
        holder.itemView.setOnClickListener {
            mListener?.onItemClicked(feature)
        }
    }

    inner class ViewHolder(private val binding: ListItemFeatureBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(feature: FeatureModel) {
            binding.featureNameTv.text = feature.featureName;
        }
    }

    interface Listener {
        fun onItemClicked(feature: FeatureModel)
    }

}