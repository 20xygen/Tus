package com.example.sutk.navigation

import android.view.View

interface BubbleNavigationChangeListener {
    fun onNavigationChanged(view: View?, position: Int)
}