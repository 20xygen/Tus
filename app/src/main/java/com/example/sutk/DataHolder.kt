package com.example.sutk

import android.app.Activity
import android.content.Context
import com.example.sutk.Global.FeedFragment
import com.example.sutk.Global.ManageFragment
import com.example.sutk.Global.ProfileFragment
import java.math.BigInteger
import java.security.MessageDigest

class DataHolder {
    companion object {
        val ndt = 8 // numOfDefaultTags
        var adapter: PostAdapter? = null
        var context: Context? = null
        var activity: Activity? = null
        var manageFragment: ManageFragment? = null
        var feedFragment: FeedFragment? = null
        var profileFragment: ProfileFragment? = null
        var projectPlaceType: Int? = null

        var mathTags = BooleanArray(6 + ndt)
        var physicsTags = BooleanArray(8 + ndt)
        var infoTags = BooleanArray(14 + ndt)
        var isTags = BooleanArray(10 + ndt)
        var langTags = BooleanArray(10 + ndt)
        var medicineTags = BooleanArray(8 + ndt)
        var economyTags = BooleanArray(4 + ndt)
        var otherTags = BooleanArray(8 + ndt)

        var registered = false

        var name: String? = null

        var nickname: String? = null

        var telegram: String? = null

        var passwordHash: String? = null

        var iconNumber: Int? = 0

        var postIconNumber: Int? = 0

        var loggedIn = false

        var userId: Int? = null

        var bio: String? = null

        fun md5(input:String): String {
            val md = MessageDigest.getInstance("MD5")
            return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
        }

        fun setPassword(value: String){
            passwordHash = md5(value)
        }

        fun checkPassword(value: String): Boolean{
            return passwordHash == md5(value)
        }

        fun checkHashPassword(value: String): Boolean{
            return passwordHash == value
        }

        fun getTags(): List<BooleanArray> {
            return listOf(mathTags, physicsTags, infoTags, isTags, langTags, medicineTags, economyTags, otherTags)
        }

        fun getStringTags(): String {
            var total = mathTags + physicsTags + infoTags + isTags + langTags + medicineTags + economyTags + otherTags
            var value = ""
            for(i in 0..(total.size - 1)){
                if (total[i]) value += "1"
                else value += "0"
            }
            return value
        }
    }


}