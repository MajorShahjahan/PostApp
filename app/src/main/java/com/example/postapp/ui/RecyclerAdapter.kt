package com.example.postapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.postapp.R
import com.example.postapp.listeners.ItemClickListener
import com.example.postapp.models.PostList

class RecyclerAdapter(private val mList: PostList, val mListener: ItemClickListener) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_design, parent, false)

        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val ItemsViewModel = mList[position]

        holder.textTile.text = ItemsViewModel.title
        holder.textId.text = ItemsViewModel.id.toString()
        holder.container.setOnClickListener {

            mListener.onItemClicked(ItemsViewModel.id,ItemsViewModel.title,ItemsViewModel.body)
        }

    }


    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {

        val textTile: TextView = itemView.findViewById(R.id.textTilte)
        val textId: TextView = itemView.findViewById(R.id.textId)
        val container : CardView = itemView.findViewById(R.id.container)

    }
}


