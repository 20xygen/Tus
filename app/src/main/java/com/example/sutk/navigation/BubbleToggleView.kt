package com.example.sutk.navigation

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.graphics.drawable.TransitionDrawable
import android.os.Build
import android.util.AttributeSet
import android.util.TypedValue
import android.view.Gravity
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.annotation.Nullable
import androidx.annotation.RequiresApi
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import com.example.sutk.R
import com.example.sutk.dataHolder.ViewUtils


/**
 * BubbleToggleView
 *
 * @author Gaurav Kumar
 */
class BubbleToggleView : RelativeLayout {
    private var bubbleToggleItem: BubbleToggleItem? = null

    /**
     * Get the current state of the view
     *
     * @return the current state
     */
    var isActive = false
        private set
    private var iconView: ImageView? = null
    private var titleView: TextView? = null
    private var badgeView: TextView? = null
    private var animationDuration = 0
    private var showShapeAlways = false
    private var maxTitleWidth = 0f
    private var measuredTitleWidth = 0f

//    companion object {
//        var countItems = 0
//    }
    /**
     * Constructors
     */
    constructor(context: Context) : super(context) {
        init(context, null)
    }

    constructor(context: Context, @Nullable attrs: AttributeSet?) : super(context, attrs) {
        init(context, attrs)
    }

    constructor(
        context: Context,
        @Nullable attrs: AttributeSet?,
        defStyleAttr: Int
    ) : super(context, attrs, defStyleAttr) {
        init(context, attrs)
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    constructor(
        context: Context,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int
    ) : super(context, attrs, defStyleAttr, defStyleRes) {
        init(context, attrs)
    }
    /////////////////////////////////////
    // PRIVATE METHODS
    /////////////////////////////////////
    /**
     * Initialize
     *
     * @param context current context
     * @param attrs   custom attributes
     */
    private fun init(context: Context, @Nullable attrs: AttributeSet?) {
        //initialize default component
        var title = "Title"
        var icon: Drawable? = null
        var shape: Drawable? = null
        var shapeColor = Int.MIN_VALUE
        var colorActive: Int = ViewUtils.getThemeAccentColor(context)
        var colorInactive = ContextCompat.getColor(context, R.color.default_inactive_color)
        var titleSize = context.resources.getDimension(R.dimen.default_nav_item_text_size)
        maxTitleWidth = context.resources.getDimension(R.dimen.default_nav_item_title_max_width)
        var iconWidth = context.resources.getDimension(R.dimen.default_icon_size)
        var iconHeight = context.resources.getDimension(R.dimen.default_icon_size)
        var internalPadding =
            context.resources.getDimension(R.dimen.default_nav_item_padding).toInt()
        var titlePadding =
            context.resources.getDimension(R.dimen.default_nav_item_text_padding).toInt()
        var badgeTextSize =
            context.resources.getDimension(R.dimen.default_nav_item_badge_text_size).toInt()
        var badgeBackgroundColor =
            ContextCompat.getColor(context, R.color.default_badge_background_color)
        var badgeTextColor = ContextCompat.getColor(context, R.color.default_badge_text_color)
        var badgeText: String? = null
        if (attrs != null) {
            val ta = context.obtainStyledAttributes(attrs, R.styleable.BubbleToggleView, 0, 0)
            try {
                icon =
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) ta.getDrawable(R.styleable.BubbleToggleView_bt_icon) else AppCompatResources.getDrawable(
                        getContext(),
                        ta.getResourceId(
                            R.styleable.BubbleToggleView_bt_icon,
                            R.drawable.default_icon
                        )
                    )
                iconWidth = ta.getDimension(R.styleable.BubbleToggleView_bt_iconWidth, iconWidth)
                iconHeight = ta.getDimension(R.styleable.BubbleToggleView_bt_iconHeight, iconHeight)
                shape = ta.getDrawable(R.styleable.BubbleToggleView_bt_shape)
                shapeColor = ta.getColor(R.styleable.BubbleToggleView_bt_shapeColor, shapeColor)
                showShapeAlways =
                    ta.getBoolean(R.styleable.BubbleToggleView_bt_showShapeAlways, false)
                title = "Default"
                titleSize = ta.getDimension(R.styleable.BubbleToggleView_bt_titleSize, titleSize)
                colorActive = ta.getColor(R.styleable.BubbleToggleView_bt_colorActive, colorActive)
                colorInactive =
                    ta.getColor(R.styleable.BubbleToggleView_bt_colorInactive, colorInactive)
                isActive = ta.getBoolean(R.styleable.BubbleToggleView_bt_active, false)
                animationDuration =
                    ta.getInteger(R.styleable.BubbleToggleView_bt_duration, DEFAULT_ANIM_DURATION)
                internalPadding = ta.getDimension(
                    R.styleable.BubbleToggleView_bt_padding,
                    internalPadding.toFloat()
                ).toInt()
                titlePadding = ta.getDimension(
                    R.styleable.BubbleToggleView_bt_titlePadding,
                    titlePadding.toFloat()
                ).toInt()
                badgeTextSize = ta.getDimension(
                    R.styleable.BubbleToggleView_bt_badgeTextSize,
                    badgeTextSize.toFloat()
                ).toInt()
                badgeBackgroundColor = ta.getColor(
                    R.styleable.BubbleToggleView_bt_badgeBackgroundColor,
                    badgeBackgroundColor
                )
                badgeTextColor =
                    ta.getColor(R.styleable.BubbleToggleView_bt_badgeTextColor, badgeTextColor)
                badgeText = ta.getString(R.styleable.BubbleToggleView_bt_badgeText)
            } finally {
                ta.recycle()
            }
        }

        //set the default icon
        if (icon == null) icon = ContextCompat.getDrawable(context, R.drawable.default_icon)
        else {
            when (NavigationController.countItems){
                0 -> title = "Feed"
                1 -> title = "Manager"
                2 -> title = "Post"
                3 -> title = "Alerts"
                4 -> title = "Profile"
            }
            NavigationController.countItems += 1
//            if (icon == ContextCompat.getDrawable(context, R.drawable.ic_home)) title = "Feed"
//            else if (icon == ContextCompat.getDrawable(context, R.drawable.ic_manage)) title = "Manager"
//            else if (icon == ContextCompat.getDrawable(context, R.drawable.ic_post)) title = "Post"
//            else if (icon == ContextCompat.getDrawable(context, R.drawable.ic_notification)) title = "Alerts"
//            else if (icon == ContextCompat.getDrawable(context, R.drawable.ic_profile)) title = "Profile"
        }

        //set the default shape
        if (shape == null) shape =
            ContextCompat.getDrawable(context, R.drawable.transition_background_drawable)

        //create a default bubble item
        bubbleToggleItem = BubbleToggleItem()
        bubbleToggleItem!!.setIcon(icon)
        bubbleToggleItem!!.setShape(shape)
        bubbleToggleItem!!.setTitle(title)
        bubbleToggleItem!!.setTitleSize(titleSize)
        bubbleToggleItem!!.setTitlePadding(titlePadding)
        bubbleToggleItem!!.setShapeColor(shapeColor)
        bubbleToggleItem!!.setColorActive(colorActive)
        bubbleToggleItem!!.setColorInactive(colorInactive)
        bubbleToggleItem!!.setIconWidth(iconWidth)
        bubbleToggleItem!!.setIconHeight(iconHeight)
        bubbleToggleItem!!.setInternalPadding(internalPadding)
        bubbleToggleItem!!.setBadgeText(badgeText)
        bubbleToggleItem!!.setBadgeBackgroundColor(badgeBackgroundColor)
        bubbleToggleItem!!.setBadgeTextColor(badgeTextColor)
        bubbleToggleItem!!.setBadgeTextSize(badgeTextSize.toFloat())

        //set the gravity
        gravity = Gravity.CENTER

        //set the internal padding
        setPadding(
            bubbleToggleItem!!.getInternalPadding(),
            bubbleToggleItem!!.getInternalPadding(),
            bubbleToggleItem!!.getInternalPadding(),
            bubbleToggleItem!!.getInternalPadding()
        )
        post { //make sure the padding is added
            setPadding(
                bubbleToggleItem!!.getInternalPadding(),
                bubbleToggleItem!!.getInternalPadding(),
                bubbleToggleItem!!.getInternalPadding(),
                bubbleToggleItem!!.getInternalPadding()
            )
        }
        createBubbleItemView(context)
        setInitialState(isActive)
    }

    /**
     * Create the components of the bubble item view [.iconView] and [.titleView]
     *
     * @param context current context
     */
    private fun createBubbleItemView(context: Context) {

        //create the nav icon
        iconView = ImageView(context)
        iconView!!.id = ViewCompat.generateViewId()
        val lpIcon = LayoutParams(
            bubbleToggleItem!!.getIconWidth()
                .toInt(), bubbleToggleItem!!.getIconHeight().toInt()
        )
        lpIcon.addRule(CENTER_VERTICAL, TRUE)
        iconView!!.layoutParams = lpIcon
        iconView!!.setImageDrawable(bubbleToggleItem!!.getIcon())

        //create the nav title
        titleView = TextView(context)
        val lpTitle = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
        lpTitle.addRule(CENTER_VERTICAL, TRUE)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) lpTitle.addRule(
            END_OF,
            iconView!!.id
        ) else lpTitle.addRule(
            RIGHT_OF, iconView!!.id
        )
        titleView!!.layoutParams = lpTitle
        titleView!!.isSingleLine = true
        titleView!!.setTextColor(bubbleToggleItem!!.getColorActive())
        titleView!!.text = bubbleToggleItem!!.getTitle()
        titleView!!.setTextSize(TypedValue.COMPLEX_UNIT_PX, bubbleToggleItem!!.getTitleSize())
        //get the current measured title width
        titleView!!.visibility = VISIBLE
        //update the margin of the text view
        titleView!!.setPadding(
            bubbleToggleItem!!.getTitlePadding(),
            0,
            bubbleToggleItem!!.getTitlePadding(),
            0
        )
        //measure the content width
        titleView!!.measure(0, 0) //must call measure!
        measuredTitleWidth = titleView!!.measuredWidth.toFloat() //get width
        //limit measured width, based on the max width
        if (measuredTitleWidth > maxTitleWidth) measuredTitleWidth = maxTitleWidth

        //change the visibility
        titleView!!.visibility = GONE
        addView(iconView)
        addView(titleView)
        updateBadge(context)

        //set the initial state
        setInitialState(isActive)
    }

    /**
     * Adds or removes the badge
     */
    private fun updateBadge(context: Context) {

        //remove the previous badge view
        if (badgeView != null) removeView(badgeView)
        if (bubbleToggleItem!!.getBadgeText() == null) return

        //create badge
        badgeView = TextView(context)
        val lpBadge = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
        lpBadge.addRule(ALIGN_TOP, iconView!!.id)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            lpBadge.addRule(ALIGN_END, iconView!!.id)
        } else lpBadge.addRule(ALIGN_RIGHT, iconView!!.id)
        badgeView!!.layoutParams = lpBadge
        badgeView!!.isSingleLine = true
        badgeView!!.setTextColor(bubbleToggleItem!!.getBadgeTextColor())
        badgeView!!.text = bubbleToggleItem!!.getBadgeText()
        badgeView!!.setTextSize(TypedValue.COMPLEX_UNIT_PX, bubbleToggleItem!!.getBadgeTextSize())
        badgeView!!.gravity = Gravity.CENTER
        val drawable = ContextCompat.getDrawable(context, R.drawable.badge_background_white)
        ViewUtils.updateDrawableColor(drawable, bubbleToggleItem!!.getBadgeBackgroundColor())
        badgeView!!.background = drawable
        val badgePadding =
            context.resources.getDimension(R.dimen.default_nav_item_badge_padding).toInt()
        //update the margin of the text view
        badgeView!!.setPadding(badgePadding, 0, badgePadding, 0)
        //measure the content width
        badgeView!!.measure(0, 0)
        if (badgeView!!.measuredWidth < badgeView!!.measuredHeight) badgeView!!.width =
            badgeView!!.measuredHeight
        addView(badgeView)
    }
    /////////////////////////////////
    // PUBLIC METHODS
    ////////////////////////////////
    /**
     * Updates the Initial State
     *
     * @param isActive current state
     */
    fun setInitialState(isActive: Boolean) {
        //set the background
        background = bubbleToggleItem!!.getShape()
        if (isActive) {
            ViewUtils.updateDrawableColor(iconView!!.drawable, bubbleToggleItem!!.getColorActive())
            this.isActive = true
            titleView!!.visibility = VISIBLE
            if (background is TransitionDrawable) {
                val trans = background as TransitionDrawable
                trans.startTransition(0)
            } else {
                if (!showShapeAlways && bubbleToggleItem!!.getShapeColor() !== Int.MIN_VALUE) ViewUtils.updateDrawableColor(
                    bubbleToggleItem!!.getShape(), bubbleToggleItem!!.getShapeColor()
                )
            }
        } else {
            ViewUtils.updateDrawableColor(
                iconView!!.drawable,
                bubbleToggleItem!!.getColorInactive()
            )
            this.isActive = false
            titleView!!.visibility = GONE
            if (!showShapeAlways) {
                if (background !is TransitionDrawable) {
                    background = null
                } else {
                    val trans = background as TransitionDrawable
                    trans.resetTransition()
                }
            }
        }
    }

    /**
     * Toggles between Active and Inactive state
     */
    fun toggle() {
        if (!isActive) activate() else deactivate()
    }

    /**
     * Set Active state
     */
    fun activate() {
        ViewUtils.updateDrawableColor(iconView!!.drawable, bubbleToggleItem!!.getColorActive())
        isActive = true
        titleView!!.visibility = VISIBLE
        val animator = ValueAnimator.ofFloat(0f, 1f)
        animator.duration = animationDuration.toLong()
        animator.addUpdateListener { animation ->
            val value = animation.animatedValue as Float
            titleView!!.width = (measuredTitleWidth * value).toInt()
            //end of animation
            if (value >= 1.0f) {
                //do something
            }
        }
        animator.start()
        if (background is TransitionDrawable) {
            val trans = background as TransitionDrawable
            trans.startTransition(animationDuration)
        } else {
            //if not showing Shape Always and valid shape color present, use that as tint
            if (!showShapeAlways && bubbleToggleItem!!.getShapeColor() !== Int.MIN_VALUE) ViewUtils.updateDrawableColor(
                bubbleToggleItem!!.getShape(), bubbleToggleItem!!.getShapeColor()
            )
            background = bubbleToggleItem!!.getShape()
        }
    }

    /**
     * Set Inactive State
     */
    fun deactivate() {
        ViewUtils.updateDrawableColor(iconView!!.drawable, bubbleToggleItem!!.getColorInactive())
        isActive = false
        val animator = ValueAnimator.ofFloat(1f, 0f)
        animator.duration = animationDuration.toLong()
        animator.addUpdateListener { animation ->
            val value = animation.animatedValue as Float
            titleView!!.width = (measuredTitleWidth * value).toInt()
            //end of animation
            if (value <= 0.0f) titleView!!.visibility = GONE
        }
        animator.start()
        if (background is TransitionDrawable) {
            val trans = background as TransitionDrawable
            trans.reverseTransition(animationDuration)
        } else {
            if (!showShapeAlways) background = null
        }
    }

    /**
     * Sets the [Typeface] of the [.titleView]
     *
     * @param typeface to be used
     */
    fun setTitleTypeface(typeface: Typeface?) {
        titleView!!.typeface = typeface
    }

    /**
     * Updates the measurements and fits the view
     *
     * @param maxWidth in pixels
     */
    fun updateMeasurements(maxWidth: Int) {
        var marginLeft = 0
        var marginRight = 0
        val titleViewLayoutParams = titleView!!.layoutParams
        if (titleViewLayoutParams is LayoutParams) {
            marginLeft = titleViewLayoutParams.rightMargin
            marginRight = titleViewLayoutParams.leftMargin
        }
        val newTitleWidth = ((maxWidth
                - (paddingRight + paddingLeft)
                - (marginLeft + marginRight)
                - bubbleToggleItem!!.getIconWidth().toInt())
                + titleView!!.paddingRight + titleView!!.paddingLeft)

        //if the new calculate title width is less than current one, update the titleView specs
        if (newTitleWidth > 0 && newTitleWidth < measuredTitleWidth) {
            measuredTitleWidth = titleView!!.measuredWidth.toFloat()
        }
    }

    /**
     * Set value to the Badge's
     *
     * @param value as String, null to hide
     */
    fun setBadgeText(value: String?) {
        bubbleToggleItem!!.setBadgeText(value)
        updateBadge(context)
    }

    companion object {
        private const val TAG = "BNI_View"
        private const val DEFAULT_ANIM_DURATION = 300
    }
}