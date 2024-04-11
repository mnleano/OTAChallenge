package com.neds.otachallenge.ui.main

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.neds.otachallenge.data.views.LevelView
import com.neds.otachallenge.databinding.RowLevelBinding

class LevelAdapter : RecyclerView.Adapter<LevelViewHolder>() {

    private var levels: MutableList<LevelView> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LevelViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RowLevelBinding.inflate(inflater, parent, false)
        return LevelViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LevelViewHolder, position: Int) {
        holder.bind(levels[position])
    }

    override fun getItemCount(): Int {
        return levels.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setLevels(newLevels: List<LevelView>) {
        levels.clear()
        levels.addAll(newLevels)
        notifyDataSetChanged()
    }
}