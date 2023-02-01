package com.example.sutk.Client

import com.example.sutk.dto.Mark.Mark
import com.example.sutk.dto.Post.*
import com.example.sutk.dto.Response.Response
import com.example.sutk.dto.User.*
import com.google.gson.GsonBuilder
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.json.*
import io.ktor.client.request.*
import io.ktor.client.response.*
import io.ktor.http.*
import io.ktor.util.*
import kotlinx.coroutines.*


class Client {
    companion object {
        private val baseURL = "http://192.168.43.231:8080"
        private val user = "$baseURL/user"
        private val post = "$baseURL/post"
        private val team = "$baseURL/team"
        private val recommendation = "$baseURL/recommend"

        val client = HttpClient(Android) {
            install(JsonFeature){
                serializer = GsonSerializer()
            }
        }
        var res: User = User()

        suspend fun getUserById(id: Int): User =
            client.get<User>("http://192.168.43.231:8080/user/profile/0")

        suspend fun getUserAchievementById(id: Int): UserAchievement =
            client.get<UserAchievement>("$user/achievement/$id")

        suspend fun getUserTagById(id: Int): UserTag =
            client.get<UserTag>("$user/tag/$id")

        suspend fun getUserTeamById(id: Int): UserTeam =
            client.get<UserTeam>("$user/team/$id")

        suspend fun getUserMarkById(id: Int): UserMark =
            client.get<UserMark>("$user/mark/$id")

        suspend fun getUserPostById(id: Int): UserPost =
            client.get<UserPost>("$user/post/$id")

        suspend fun getAchievementTypes():List<String> =
            client.get<List<String>>("$baseURL/achievement/types")


        suspend fun getUserJobById(id: Int): UserJob =
            client.get<UserJob>("$user/job/$id")

        suspend fun getUserCityById(id: Int): UserCity =
            client.get<UserCity>("$user/city/$id")

        suspend fun setJobToUser(job: UserJob): Any? =
            client.put("$user/update/job") {
                contentType(ContentType.Application.Json)
                body = job
            }

        suspend fun setCityToUser(city: UserCity):Any? =
            client.put("$user/update/city"){
                contentType(ContentType.Application.Json)
                body = city
            }

        suspend fun updateUser(id: Int, user:User):Any? =
            client.put("${Companion.user}/update/$id") {
                contentType(ContentType.Application.Json)
                body = user
            }

        suspend fun updateUserAchievements(userAchievement: UserAchievement): Any? =
            client.put("${Companion.user}/update/achievement"){
                contentType(ContentType.Application.Json)
                body = userAchievement
            }

        suspend fun updateUserTags (userTag: UserTag):Any? =
            client.put("${Companion.user}/update/tag") {
                contentType(ContentType.Application.Json)
                body = userTag
            }

        suspend fun authorisation(userLoginParams: UserLoginParams): Response =
            client.post("${Companion.user}/auth/log") {
                contentType(ContentType.Application.Json)
                body = userLoginParams
            }

        suspend fun registration(userLoginParams: UserLoginParams): Response =
            client.post("${Companion.user}/auth/reg"){
                contentType(ContentType.Application.Json)
                body = userLoginParams
            }

        suspend fun getPostById(id: Int): Post {
            val response = client.call("$post/$id").response.readText(charset("UTF-8"))
            val builder = GsonBuilder()
            val gson = builder.create()
            val res: Post = gson.fromJson(response, Post::class.java)
            return res
        }


        suspend fun getPostTeamById(id: Int): PostTeam =
            client.get("$post/team/$id")

        suspend fun getPostMarkById(id: Int): PostMark =
            client.get("$post/mark/$id")

        suspend fun getPostTagById(id: Int): PostTag =
            client.get("$post/tag/$id")

        suspend fun getRelatedPostById(id: Int): RelatedPost =
            client.get("$post/related/$id")

        suspend fun updatePostMark(mark: Mark): Any? =
            client.put("$post/update/mark") {
                contentType(ContentType.Application.Json)
                body = mark
            }

        suspend fun updatePost(newPost: Post) : Any? =
            client.put("$post/update") {
                contentType(ContentType.Application.Json)
                body = newPost
            }

        suspend fun createPost(newPost: Post): Any? =
            client.post("$post/new") {
                contentType(ContentType.Application.Json)
                body = newPost
            }

        suspend fun updatePostTag(newPost:PostTag): Any? =
            client.put("$post/update/mark") {
                contentType(ContentType.Application.Json)
                body = newPost
            }

        suspend fun updateRelatedPost(newPost: RelatedPost): Any? =
            client.put("$post/update/related") {
                contentType(ContentType.Application.Json)
                body = newPost
            }

        suspend fun deletePostBuId(id: Int):Any? =
            client.delete("$post/delete/$id")

        suspend fun addUserToTeam(postId:Int, userId:Int): Any? =
            client.post("$team/$postId/add/$userId")

        suspend fun removeUserFromTeam(postId: Int, userId: Int): Any? =
            client.put("$team/$postId/remove/$userId")

        suspend fun recommendByPostId(postId: Int): List<Int> =
            client.get("$recommendation/post/$postId")

        suspend fun recommendByUserId(userId: Int): List<Int> =
            client.get("$recommendation/user/$userId")
    }
}