package com.example.sutk

import android.graphics.Typeface


interface IBubbleNavigation {
    fun setNavigationChangeListener(navigationChangeListener: BubbleNavigationChangeListener?)
    fun setTypeface(typeface: Typeface?)
    val currentActiveItemPosition: Int

    fun setCurrentActiveItem(position: Int)
    fun setBadgeValue(position: Int, value: String?)
}