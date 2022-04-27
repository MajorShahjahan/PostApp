package com.example.postapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.postapp.models.PostList
import com.example.postapp.repository.PostRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Dispatcher

class MainViewModel(private val repository: PostRepository) : ViewModel() {

    init {

        viewModelScope.launch(Dispatchers.IO) {
            repository.getPost()
        }
    }

    val posts : LiveData<PostList>
    get() = repository.posts
}