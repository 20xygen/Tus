package com.example.sutk.navigation

import android.graphics.Typeface
import com.example.sutk.navigation.BubbleNavigationChangeListener


interface IBubbleNavigation {
    fun setNavigationChangeListener(navigationChangeListener: BubbleNavigationChangeListener?)
    fun setTypeface(typeface: Typeface?)
    val currentActiveItemPosition: Int

    fun setCurrentActiveItem(position: Int)
    fun setBadgeValue(position: Int, value: String?)
}