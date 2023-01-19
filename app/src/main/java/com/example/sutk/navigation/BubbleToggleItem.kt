package com.example.sutk.navigation

import android.graphics.Color
import android.graphics.drawable.Drawable


internal class BubbleToggleItem {
    private var icon: Drawable? = null
    private var shape: Drawable? = null
    private var title = ""
    private var colorActive = Color.BLUE
    private var colorInactive = Color.BLACK
    private var shapeColor = Int.MIN_VALUE
    private var badgeText: String? = null
    private var badgeTextColor = Color.WHITE
    private var badgeBackgroundColor = Color.BLACK
    private var titleSize = 0f
    private var badgeTextSize = 0f
    private var iconWidth = 0f
    private var iconHeight = 0f
    private var titlePadding = 0
    private var internalPadding = 0

    @JvmName("getIcon1")
    fun getIcon(): Drawable? {
        return icon
    }

    @JvmName("setIcon1")
    fun setIcon(icon: Drawable?) {
        this.icon = icon
    }

    @JvmName("getShape1")
    fun getShape(): Drawable? {
        return shape
    }

    @JvmName("setShape1")
    fun setShape(shape: Drawable?) {
        this.shape = shape
    }

    @JvmName("getShapeColor1")
    fun getShapeColor(): Int {
        return shapeColor
    }

    @JvmName("setShapeColor1")
    fun setShapeColor(shapeColor: Int) {
        this.shapeColor = shapeColor
    }

    @JvmName("getTitle1")
    fun getTitle(): String? {
        return title
    }

    @JvmName("setTitle1")
    fun setTitle(title: String?) {
        this.title = title!!
    }

    @JvmName("getColorActive1")
    fun getColorActive(): Int {
        return colorActive
    }

    @JvmName("setColorActive1")
    fun setColorActive(colorActive: Int) {
        this.colorActive = colorActive
    }

    @JvmName("getColorInactive1")
    fun getColorInactive(): Int {
        return colorInactive
    }

    @JvmName("setColorInactive1")
    fun setColorInactive(colorInactive: Int) {
        this.colorInactive = colorInactive
    }

    @JvmName("getTitleSize1")
    fun getTitleSize(): Float {
        return titleSize
    }

    @JvmName("setTitleSize1")
    fun setTitleSize(titleSize: Float) {
        this.titleSize = titleSize
    }

    @JvmName("getIconWidth1")
    fun getIconWidth(): Float {
        return iconWidth
    }

    @JvmName("setIconWidth1")
    fun setIconWidth(iconWidth: Float) {
        this.iconWidth = iconWidth
    }

    @JvmName("getIconHeight1")
    fun getIconHeight(): Float {
        return iconHeight
    }

    @JvmName("setIconHeight1")
    fun setIconHeight(iconHeight: Float) {
        this.iconHeight = iconHeight
    }

    @JvmName("getTitlePadding1")
    fun getTitlePadding(): Int {
        return titlePadding
    }

    @JvmName("setTitlePadding1")
    fun setTitlePadding(titlePadding: Int) {
        this.titlePadding = titlePadding
    }

    @JvmName("getInternalPadding1")
    fun getInternalPadding(): Int {
        return internalPadding
    }

    @JvmName("setInternalPadding1")
    fun setInternalPadding(internalPadding: Int) {
        this.internalPadding = internalPadding
    }

    @JvmName("getBadgeTextColor1")
    fun getBadgeTextColor(): Int {
        return badgeTextColor
    }

    @JvmName("setBadgeTextColor1")
    fun setBadgeTextColor(badgeTextColor: Int) {
        this.badgeTextColor = badgeTextColor
    }

    @JvmName("getBadgeBackgroundColor1")
    fun getBadgeBackgroundColor(): Int {
        return badgeBackgroundColor
    }

    @JvmName("setBadgeBackgroundColor1")
    fun setBadgeBackgroundColor(badgeBackgroundColor: Int) {
        this.badgeBackgroundColor = badgeBackgroundColor
    }

    @JvmName("getBadgeTextSize1")
    fun getBadgeTextSize(): Float {
        return badgeTextSize
    }

    @JvmName("setBadgeTextSize1")
    fun setBadgeTextSize(badgeTextSize: Float) {
        this.badgeTextSize = badgeTextSize
    }

    @JvmName("getBadgeText1")
    fun getBadgeText(): String? {
        return badgeText
    }

    @JvmName("setBadgeText1")
    fun setBadgeText(badgeText: String?) {
        this.badgeText = badgeText
    }
}