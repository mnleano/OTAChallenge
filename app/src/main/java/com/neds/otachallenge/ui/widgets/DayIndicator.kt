package com.neds.otachallenge.ui.widgets

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.neds.otachallenge.databinding.DayIndicatorBinding
import com.neds.otachallenge.databinding.GridDayBinding
import java.util.Calendar

class DayIndicator(
    context: Context, attributeSet: AttributeSet
) : ConstraintLayout(context, attributeSet) {

    private val days = mutableListOf<GridDayBinding>()

    init {
        val binding = DayIndicatorBinding.inflate(LayoutInflater.from(context), this, true)

        days.add(binding.dayMon)
        days.add(binding.dayTue)
        days.add(binding.dayWed)
        days.add(binding.dayThu)
        days.add(binding.dayFri)
        days.add(binding.daySat)
        days.add(binding.daySun)

        days.forEachIndexed { i, day -> day.root.setOnClickListener { setSelectedDay(i) } }

        val dayOfWeek = Calendar.getInstance().get(Calendar.DAY_OF_WEEK)
        setSelectedDay(if (dayOfWeek == Calendar.SUNDAY) 6 else dayOfWeek - 2)
    }

    private fun setSelectedDay(dayOfWeek: Int) {
        days.forEachIndexed { i, _ -> days[i].isSelected = i == dayOfWeek }
    }

}