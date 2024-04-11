package com.neds.otachallenge.ui.main

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.neds.otachallenge.data.views.LevelView
import com.neds.otachallenge.databinding.RowLevelBinding

class LevelViewHolder(private val binding: RowLevelBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(level: LevelView) {
        binding.level = level
        binding.executePendingBindings()

        val adapter = ActivityAdapter()
        val layoutManager = GridLayoutManager(binding.root.context, 2)
        layoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                val isLastItem = position == adapter.itemCount - 1
                val isItemCountOdd = adapter.itemCount % 2 != 0
                return if (isLastItem && isItemCountOdd) 2 else 1
            }
        }
        binding.rvActivities.layoutManager = layoutManager
        binding.rvActivities.adapter = adapter
        adapter.setActivities(level.activities)
    }
}