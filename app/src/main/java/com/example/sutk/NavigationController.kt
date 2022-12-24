package com.example.sutk

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.Log
import android.widget.Toast
import androidx.navigation.NavController

class NavigationController {

    companion object {
        var controller: NavController? = null
        var context: Context? = null
    }


    public fun getController(): NavController? {
        return controller
    }


    public fun setController(newController: NavController) {
        controller = newController
    }

    public fun getContext(): Context? {
        return context
    }


    public fun setContext(newContext: Context) {
        context = newContext
    }

    fun Context.toast(message: CharSequence) =
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

    //                    1 -> Log.w("NavigationController", "Cannot change screen to itself.")
    public fun changeScreen(fromItem: Int, toItem: Int) {
        when(fromItem){
            1 -> {
                when(toItem){
                    1 -> context?.toast("Explore projects")
                    2 -> controller?.navigate(R.id.action_Pages_1_to_2)
                    3 -> controller?.navigate(R.id.action_Pages_1_to_3)
                    4 -> controller?.navigate(R.id.action_Pages_1_to_4)
                    5 -> controller?.navigate(R.id.action_Pages_1_to_5)
                }
            }
            2 -> {
                when(toItem){
                    1 -> controller?.navigate(R.id.action_Pages_2_to_1)
                    2 -> context?.toast("Your teams' settings")
                    3 -> controller?.navigate(R.id.action_Pages_2_to_3)
                    4 -> controller?.navigate(R.id.action_Pages_2_to_4)
                    5 -> controller?.navigate(R.id.action_Pages_2_to_5)
                }
            }
            3 -> {
                when(toItem){
                    1 -> controller?.navigate(R.id.action_Pages_3_to_1)
                    2 -> controller?.navigate(R.id.action_Pages_3_to_2)
                    3 -> context?.toast("Create new post")
                    4 -> controller?.navigate(R.id.action_Pages_3_to_4)
                    5 -> controller?.navigate(R.id.action_Pages_3_to_5)
                }
            }
            4 -> {
                when(toItem){
                    1 -> controller?.navigate(R.id.action_Pages_4_to_1)
                    2 -> controller?.navigate(R.id.action_Pages_4_to_2)
                    3 -> controller?.navigate(R.id.action_Pages_4_to_3)
                    4 -> context?.toast("Find out notifications")
                    5 -> controller?.navigate(R.id.action_Pages_4_to_5)
                }
            }
            5 -> {
                when(toItem){
                    1 -> controller?.navigate(R.id.action_Pages_5_to_1)
                    2 -> controller?.navigate(R.id.action_Pages_5_to_2)
                    3 -> controller?.navigate(R.id.action_Pages_5_to_3)
                    4 -> controller?.navigate(R.id.action_Pages_5_to_4)
                    5 -> context?.toast("This is your pofile")
                }
            }
        }
    }
}