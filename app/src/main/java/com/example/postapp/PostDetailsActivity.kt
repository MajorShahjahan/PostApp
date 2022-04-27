package com.example.postapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class PostDetailsActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_details)
        val detailTile: TextView = findViewById(R.id.detailTitle)
        val detailId: TextView = findViewById(R.id.detailId)
        val detailBody : TextView = findViewById(R.id.detailBody)

        detailId.text = intent.getStringExtra("id")
        detailBody.text = intent.getStringExtra("body")
        detailTile.text = intent.getStringExtra("title")
    }
}