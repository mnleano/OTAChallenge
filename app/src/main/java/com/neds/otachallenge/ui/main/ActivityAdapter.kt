package com.neds.otachallenge.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.neds.otachallenge.data.views.ActivityView
import com.neds.otachallenge.databinding.GridActivityBinding

class ActivityAdapter : RecyclerView.Adapter<ActivityAdapter.ActivityViewHolder>() {

    private var activities: MutableList<ActivityView> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActivityViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = GridActivityBinding.inflate(inflater, parent, false)
        return ActivityViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ActivityViewHolder, position: Int) {
        holder.bind(activities[position])
    }

    override fun getItemCount(): Int {
        return activities.size
    }

    fun setActivities(newActivities: List<ActivityView>) {
        activities.clear()
        activities.addAll(newActivities)
        notifyDataSetChanged()
    }

    inner class ActivityViewHolder(private val binding: GridActivityBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(activity: ActivityView) {
            binding.data = activity
        }
    }
}