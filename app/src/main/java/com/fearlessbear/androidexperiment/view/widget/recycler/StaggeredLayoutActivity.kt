package com.fearlessbear.androidexperiment.view.widget.recycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.fearlessbear.androidexperiment.R

class StaggeredLayoutActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_staggerd_layout)
    findViewById<RecyclerView>(R.id.recycler)?.apply {
      layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
      adapter = MyAdapter()
    }
  }
}


class MyAdapter : RecyclerView.Adapter<MyHolder>() {
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder = MyHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_text, parent, false) as
      ViewGroup)

  override fun onBindViewHolder(holder: MyHolder, position: Int) {
    holder.txt.text = "$position"
    (holder.view.layoutParams as StaggeredGridLayoutManager.LayoutParams).isFullSpan = position % 3 == 0
  }

  override fun getItemCount(): Int = 50


}

class MyHolder(val view: ViewGroup) : RecyclerView.ViewHolder(view) {
  val txt: TextView by lazy {
    view.findViewById<TextView>(R.id.text)
  }
}