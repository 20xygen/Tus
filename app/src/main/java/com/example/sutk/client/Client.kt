package com.example.sutk.client

import com.example.sutk.dto.Mark.Mark
import com.example.sutk.dto.Post.*
import com.example.sutk.dto.Response.Response
import com.example.sutk.dto.Tag.AllTag
import com.example.sutk.dto.Tag.Tag
import com.example.sutk.dto.User.*
import com.google.gson.GsonBuilder
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.json.*
import io.ktor.client.request.*
import io.ktor.client.response.*
import io.ktor.http.*


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

        suspend fun getUserById(id: Int): User {
            println("Request sent: getUserById { " + id.toString() + " }")
            val response = client.call("$user/profile/$id").response.readText(charset("UTF-8"))
            val builder = GsonBuilder()
            val gson = builder.create()
            val res: User = gson.fromJson(response, User::class.java)
            return res
        }

        suspend fun getUserAchievementById(id: Int): UserAchievement {
            println("Request sent: getUserAchievementById { " + id.toString() + " }")
            val response = client.call("$user/achievement/$id").response.readText(charset("UTF-8"))
            val builder = GsonBuilder()
            val gson = builder.create()
            val res: UserAchievement = gson.fromJson(response, UserAchievement::class.java)
            return res
        }

        suspend fun getUserTagById(id: Int): UserTag {
            println("Request sent: getUserTagById { " + id.toString() + " }")
            val response = client.call("$user/tag/$id").response.readText(charset("UTF-8"))
            val builder = GsonBuilder()
            val gson = builder.create()
            val res: UserTag = gson.fromJson(response, UserTag::class.java)
            return res
        }

        suspend fun getUserTeamById(id: Int): UserTeam {
            println("Request sent: getUserTeamById { " + id.toString()+ " }")
            val response = client.call("$user/team/$id").response.readText(charset("UTF-8"))
            val builder = GsonBuilder()
            val gson = builder.create()
            val res: UserTeam = gson.fromJson(response, UserTeam::class.java)
            return res
        }

        suspend fun getUserMarkById(id: Int): UserMark {
            println("Request sent: getUserMarkById { " + id.toString() + " }")
            val response = client.call("$user/mark/$id").response.readText(charset("UTF-8"))
            val builder = GsonBuilder()
            val gson = builder.create()
            val res: UserMark = gson.fromJson(response, UserMark::class.java)
            return res
        }

        suspend fun getUserPostById(id: Int): UserPost {
            println("Request sent: getUserPostById { " + id.toString() + " }")
            val response = client.call("$user/post/$id").response.readText(charset("UTF-8"))
            val builder = GsonBuilder()
            val gson = builder.create()
            val res: UserPost = gson.fromJson(response, UserPost::class.java)
            return res
        }

        suspend fun getUserLastId(): UserId{
            println("Request sent: getUserLastId { }")
            val response = client.call("$user/last").response.readText(charset("UTF-8"))
            println(response)
            val builder = GsonBuilder()
            val gson = builder.create()
            val res: UserId = gson.fromJson(response, UserId::class.java)
            return res
        }

        suspend fun getAchievementTypes():List<String> =
            client.get<List<String>>("$baseURL/achievement/types")


        suspend fun getUserJobById(id: Int): UserJob {
            println("Request sent: getUserJobById { " + id.toString() + " }")
            return client.get<UserJob>("$user/job/$id")
        }


        suspend fun getUserCityById(id: Int): UserCity {
            println("Request sent: getUserCityById { " + id.toString() + " }")
            return client.get<UserCity>("$user/city/$id")
        }


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

        suspend fun updateUser(id: Int, user:User) {
            println("Request sent: updateUser { " + id.toString() + " " + user.toString() + " }")
            client.call("${Companion.user}/update/$id") {
                println("${Companion.user}/update/$id")
                method = HttpMethod.Put
                contentType(ContentType.Application.Json)
                body = user
                println(user)
            }
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

        suspend fun authorisation(userLoginParams: UserLoginParams): Response {
            println("Request sent: authorisation { " + userLoginParams.toString() + " }")
            val response = client.call("$baseURL/auth/log") {
                method = HttpMethod.Post
                contentType(ContentType.Application.Json)
                body = userLoginParams
            }.response.readText(charset("UTF-8"))
            val builder = GsonBuilder()
            val gson = builder.create()
            val res: Response = gson.fromJson(response, Response::class.java)
            return res
        }

        suspend fun getIdByUserLogin(userLoginParams: UserLoginParams):Int{
            println("Request sent: getIdByUserLogin { " + userLoginParams.toString() + " }")
            val response = client.call("$user/id") {
                method = HttpMethod.Post
                contentType(ContentType.Application.Json)
                body = userLoginParams
            }.response.readText(charset("UTF-8"))
            val builder = GsonBuilder()
            val gson = builder.create()
            val res: UserId = gson.fromJson(response, UserId::class.java)
            return res.id
        }

        suspend fun registration(userLoginParams: UserLoginParams): Response{
            println("Request sent: registration { " + userLoginParams.toString() + " }")
            val response = client.call("$baseURL/auth/reg") {
                contentType(ContentType.Application.Json)
                body = userLoginParams
            }.response.readText(charset("UTF-8"))
            val builder = GsonBuilder()
            val gson = builder.create()
            val res: Response = gson.fromJson(response, Response::class.java)
            return res
        }

        suspend fun getPostById(id: Int): Post {
            println("Request sent: getPostById { " + id.toString() + " }")
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

        suspend fun createPost(newPost: Post){
            println("Request sent: createPost { " + newPost.toString() + " }")
            client.call("$post/new") {
                contentType(ContentType.Application.Json)
                body = newPost
            }
        }

        suspend fun getAllPosts(): List<Post>{
            println("Request sent: getAllPosts {  }")
            val response = client.call("$post/all").response.readText(charset("UTF-8"))
            val builder = GsonBuilder()
            val gson = builder.create()
            val res: AllPost = gson.fromJson(response, AllPost::class.java)
            return res.allPost
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

        suspend fun getAllTag():List<Tag>{
            println("Request sent: getAllTag {  }")
            val response = client.call("$baseURL/tag").response.readText(charset("UTF-8"))
            val gsonBuilder = GsonBuilder()
            val gson = gsonBuilder.create()
            val res: AllTag = gson.fromJson(response, AllTag::class.java)
            return res.allTag
        }
    }
}