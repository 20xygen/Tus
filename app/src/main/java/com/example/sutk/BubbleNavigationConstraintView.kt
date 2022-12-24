package com.example.sutk

import android.content.Context
import android.graphics.Typeface
import android.os.Bundle
import android.os.Parcelable
import android.util.AttributeSet
import android.util.Log
import android.util.SparseArray
import android.view.View
import androidx.annotation.Nullable
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.navigation.NavController
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController


/**
 * BubbleNavigationConstraintView
 *
 * @author Gaurav Kumar
 */
class BubbleNavigationConstraintView : ConstraintLayout, View.OnClickListener,
    IBubbleNavigation {
    internal enum class DisplayMode {
        SPREAD, INSIDE, PACKED
    }

    private var bubbleNavItems: ArrayList<BubbleToggleView>? = null
    private var navigationChangeListener: BubbleNavigationChangeListener? = null

    /**
     * Gets the current active position
     *
     * @return active item position
     */
    override var currentActiveItemPosition = 0
        private set
    private var loadPreviousState = false

    //default display mode
    private var displayMode = DisplayMode.SPREAD
    private var currentTypeface: Typeface? = null
    private var pendingBadgeUpdate: SparseArray<String?>? = null

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

    override fun onSaveInstanceState(): Parcelable? {
        val bundle = Bundle()
        bundle.putParcelable("superState", super.onSaveInstanceState())
        bundle.putInt("current_item", currentActiveItemPosition)
        bundle.putBoolean("load_prev_state", true)
        return bundle
    }

    override fun onRestoreInstanceState(state: Parcelable) {
        var state: Parcelable? = state
        if (state is Bundle) {
            val bundle = state
            currentActiveItemPosition = bundle.getInt("current_item")
            loadPreviousState = bundle.getBoolean("load_prev_state")
            state = bundle.getParcelable("superState")
        }
        super.onRestoreInstanceState(state)
    }
    /////////////////////////////////////////
    // PRIVATE METHODS
    /////////////////////////////////////////
    /**
     * Initialize
     *
     * @param context current context
     * @param attrs   custom attributes
     */
    private fun init(context: Context, attrs: AttributeSet?) {
        var mode = 0
        if (attrs != null) {
            val ta = context.obtainStyledAttributes(
                attrs,
                R.styleable.BubbleNavigationConstraintView,
                0,
                0
            )
            mode = try {
                ta.getInteger(R.styleable.BubbleNavigationConstraintView_bnc_mode, mode)
            } finally {
                ta.recycle()
            }
        }

        //sets appropriate display node
        if (mode >= 0 && mode < DisplayMode.values().size) displayMode =
            DisplayMode.values()[mode]
        post { updateChildNavItems() }
    }

    /**
     * Get the chain type from the display mode
     *
     * @param mode display mode
     * @return the constraint chain mode
     */
    private fun getChainTypeFromMode(mode: DisplayMode): Int {
        return when (mode) {
            DisplayMode.SPREAD -> ConstraintSet.CHAIN_SPREAD
            DisplayMode.INSIDE -> ConstraintSet.CHAIN_SPREAD_INSIDE
            DisplayMode.PACKED -> ConstraintSet.CHAIN_PACKED
        }
        return ConstraintSet.CHAIN_SPREAD
    }

    /**
     * Finds Child Elements of type [BubbleToggleView] and adds them to [.bubbleNavItems]
     */
    private fun updateChildNavItems() {
        bubbleNavItems = ArrayList()
        for (index in 0 until childCount) {
            val view = getChildAt(index)
            if (view is BubbleToggleView) bubbleNavItems!!.add(view) else {
                Log.w(TAG, "Cannot have child bubbleNavItems other than BubbleToggleView")
                return
            }
        }
        if (bubbleNavItems!!.size < MIN_ITEMS) {
            Log.w(
                TAG,
                "The bubbleNavItems list should have at least 2 bubbleNavItems of BubbleToggleView"
            )
        } else if (bubbleNavItems!!.size > MAX_ITEMS) {
            Log.w(
                TAG,
                "The bubbleNavItems list should not have more than 5 bubbleNavItems of BubbleToggleView"
            )
        }
        setClickListenerForItems()
        setInitialActiveState()
        updateMeasurementForItems()
        createChains()
        if (currentTypeface != null) setTypeface(currentTypeface)

        //update the badge count
        if (pendingBadgeUpdate != null && bubbleNavItems != null) {
            for (i in 0 until pendingBadgeUpdate!!.size()) setBadgeValue(
                pendingBadgeUpdate!!.keyAt(
                    i
                ), pendingBadgeUpdate!!.valueAt(i)
            )
            pendingBadgeUpdate!!.clear()
        }
    }

    /**
     * Creates the chains to spread the [.bubbleNavItems] based on the [.displayMode]
     */
    private fun createChains() {
        val constraintSet = ConstraintSet()
        constraintSet.clone(this)
        val chainIdsList = IntArray(bubbleNavItems!!.size)
        val chainWeightList = FloatArray(bubbleNavItems!!.size)
        for (i in bubbleNavItems!!.indices) {
            val id = bubbleNavItems!![i].id
            chainIdsList[i] = id
            chainWeightList[i] = 0.0f
            //set the top and bottom constraint for each items
            constraintSet.connect(
                id,
                ConstraintSet.TOP,
                ConstraintSet.PARENT_ID,
                ConstraintSet.TOP,
                0
            )
            constraintSet.connect(
                id,
                ConstraintSet.BOTTOM,
                ConstraintSet.PARENT_ID,
                ConstraintSet.BOTTOM,
                0
            )
        }

        //create an horizontal chain
        constraintSet.createHorizontalChain(
            id, ConstraintSet.LEFT,
            id, ConstraintSet.RIGHT,
            chainIdsList, chainWeightList,
            getChainTypeFromMode(displayMode)
        )

        //apply the constraint
        constraintSet.applyTo(this)
    }

    /**
     * Makes sure that ONLY ONE child [.bubbleNavItems] is active
     */
    private fun setInitialActiveState() {
        if (bubbleNavItems == null) return
        var foundActiveElement = false

        // find the initial state
        if (!loadPreviousState) {
            for (i in bubbleNavItems!!.indices) {
                if (bubbleNavItems!![i].isActive && !foundActiveElement) {
                    foundActiveElement = true
                    currentActiveItemPosition = i
                } else {
                    bubbleNavItems!![i].setInitialState(false)
                }
            }
        } else {
            for (i in bubbleNavItems!!.indices) {
                bubbleNavItems!![i].setInitialState(false)
            }
        }
        //set the active element
        if (!foundActiveElement) bubbleNavItems!![currentActiveItemPosition].setInitialState(true)
    }

    /**
     * Update the measurements of the child components [.bubbleNavItems]
     */
    private fun updateMeasurementForItems() {
        val numChildElements = bubbleNavItems!!.size
        if (numChildElements > 0) {
            val calculatedEachItemWidth =
                (measuredWidth - (paddingRight + paddingLeft)) / numChildElements
            for (btv in bubbleNavItems!!) btv.updateMeasurements(calculatedEachItemWidth)
        }
    }

    /**
     * Sets [OnClickListener] for the child views
     */
    private fun setClickListenerForItems() {
        for (btv in bubbleNavItems!!) btv.setOnClickListener(this)
        Log.w(TAG, "Set click listener")
    }

    /**
     * Gets the Position of the Child from [.bubbleNavItems] from its id
     *
     * @param id of view to be searched
     * @return position of the Item
     */
    private fun getItemPositionById(id: Int): Int {
        for (i in bubbleNavItems!!.indices) if (id == bubbleNavItems!![i].id) return i
        return -1
    }
    ///////////////////////////////////////////
    // PUBLIC METHODS
    ///////////////////////////////////////////
    /**
     * Set the navigation change listener [BubbleNavigationChangeListener]
     *
     * @param navigationChangeListener sets the passed parameters as listener
     */
    override fun setNavigationChangeListener(navigationChangeListener: BubbleNavigationChangeListener?) {
        this.navigationChangeListener = navigationChangeListener
    }

    /**
     * Set the [Typeface] for the Text Elements of the View
     *
     * @param typeface to be used
     */
    override fun setTypeface(typeface: Typeface?) {
        if (bubbleNavItems != null) {
            for (btv in bubbleNavItems!!) btv.setTitleTypeface(typeface)
        } else {
            currentTypeface = typeface
        }
    }

    /**
     * Sets the current active item
     *
     * @param position current position change
     */
    override fun setCurrentActiveItem(position: Int) {
        if (bubbleNavItems == null) {
            currentActiveItemPosition = position
            return
        }
        if (currentActiveItemPosition == position) return
        if (position < 0 || position >= bubbleNavItems!!.size) return
        val btv = bubbleNavItems!![position]
        btv.performClick()
    }

    /**
     * Sets the badge value
     *
     * @param position current position change
     * @param value    value to be set in the badge
     */
    override fun setBadgeValue(position: Int, value: String?) {
        if (bubbleNavItems != null) {
            val btv = bubbleNavItems!![position]
            if (btv != null) btv.setBadgeText(value)
        } else {
            if (pendingBadgeUpdate == null) pendingBadgeUpdate = SparseArray()
            pendingBadgeUpdate!!.put(position, value)
        }
    }

    public var navController: NavigationController? = NavigationController()

    public var controller: NavController? = null

    override fun onClick(v: View) {
        val changedPosition = getItemPositionById(v.id)
        if (changedPosition >= 0) {
            if (changedPosition == currentActiveItemPosition) {
                navController?.changeScreen(currentActiveItemPosition + 1, changedPosition + 1)
                return
            }
//            controller = navController?.getController()
            Log.w(TAG, changedPosition.toString() + " <- " + currentActiveItemPosition.toString())
            navController?.changeScreen(currentActiveItemPosition + 1, changedPosition + 1)
            //controller?.navigate(R.id.action_Pages_1_to_2)
            val currentActiveToggleView = bubbleNavItems!![currentActiveItemPosition]
            val newActiveToggleView = bubbleNavItems!![changedPosition]
            if (currentActiveToggleView != null) currentActiveToggleView.toggle()
            if (newActiveToggleView != null) newActiveToggleView.toggle()

            //changed the current active position
            currentActiveItemPosition = changedPosition
            if (navigationChangeListener != null) navigationChangeListener!!.onNavigationChanged(
                v,
                currentActiveItemPosition
            )
        } else {
            Log.w(TAG, "Selected id not found! Cannot toggle")
        }
    }

    companion object {
        //constants
        private const val TAG = "BNLView"
        private const val MIN_ITEMS = 2
        private const val MAX_ITEMS = 5
    }
}
