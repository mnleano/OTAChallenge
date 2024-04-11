package com.neds.otachallenge.ui.widgets

import android.widget.ImageView
import androidx.databinding.BindingAdapter

object CommonBindingAdapter {

    @BindingAdapter("icon")
    @JvmStatic
    fun setIcon(view: ImageView, icon: Int?) {
        icon?.let { view.setImageResource(icon) }
    }

}