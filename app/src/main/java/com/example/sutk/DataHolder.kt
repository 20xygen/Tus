package com.example.sutk

import android.app.Activity
import android.content.Context
import com.example.sutk.Global.FeedFragment
import com.example.sutk.Global.ManageFragment
import com.example.sutk.Global.ProfileFragment
import com.example.sutk.dto.Post.Post
import com.example.sutk.dto.Tag.Tag
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

//        val stack = ArrayDeque(listOf(1, 2, 3)) // stack: [1, 2, 3]
//        stack.addLast(0)                        // stack: [1, 2, 3, 0]         (push)
//        val value = stack.removeLast()

        var postToScreen: Map<String, ArrayDeque<Post>> = mapOf("feed" to ArrayDeque<Post>(listOf()), "manage" to ArrayDeque<Post>(listOf()), "notifications" to ArrayDeque<Post>(listOf()), "profile" to ArrayDeque<Post>(listOf()))
        var postToScreenLast = "feed"
        var listOfAllTags: List<Tag>? = listOf(Tag("Тригонометрия", "Математика"), Tag("Тригонометрия", "Математика"), Tag("Тригонометрия", "Математика"))

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

        fun tagRefactor(s: String): String{
            var n: String = ""
            for (i in 1..s.length){
                if (s[i-1] != '(') {
                    n += s[i-1]
                }
                else{
                    break
                }
            }
            return n
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