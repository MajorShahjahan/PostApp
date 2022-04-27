package com.example.postapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.postapp.api.PostService
import com.example.postapp.api.RetrofitHelper
import com.example.postapp.repository.PostRepository
import com.example.postapp.viewmodels.MainViewModel
import com.example.postapp.viewmodels.MainViewModelFactory

class MainActivity : AppCompatActivity(),ItemClickListener {

    lateinit var mainViewModel: MainViewModel
    lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerview)
        val postService = RetrofitHelper.getInstance().create(PostService::class.java)
        val repository = PostRepository(postService)
        recyclerView.layoutManager = LinearLayoutManager(this)


        mainViewModel = ViewModelProvider(this,MainViewModelFactory(repository)).get(MainViewModel::class.java)

        mainViewModel.posts.observe(this, Observer {

            val adapter = RecyclerAdapter(it,this)
            recyclerView.adapter = adapter
        })
    }

    override fun onItemClicked(id: Int, title: String, body : String) {
        val intent = Intent(this, PostDetailsActivity::class.java)
        intent.putExtra("id", id.toString())
        intent.putExtra("title", title)
        intent.putExtra("body", body)
        startActivity(intent)
    }
}