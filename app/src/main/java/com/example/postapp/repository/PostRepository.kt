package com.example.postapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.postapp.api.PostService
import com.example.postapp.models.PostList

class PostRepository(private val postService: PostService) {

    private val postLiveData = MutableLiveData<PostList>()
    val posts : LiveData<PostList>
    get() = postLiveData

    suspend fun getPost(){
        val result = postService.getPost()
        if (result?.body() != null){

            postLiveData.postValue(result.body())
        }
    }
}