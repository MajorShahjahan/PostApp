package com.example.postapp.api

import com.example.postapp.models.PostList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PostService {

    @GET("/posts")
    suspend fun getPost() : Response<PostList>

    @GET("/posts")
    suspend fun getPostById(@Query("id") id : Int) : Response<PostList>
}