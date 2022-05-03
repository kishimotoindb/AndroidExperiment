package com.fearlessbear.androidexperiment.view.widget.recycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import android.widget.Adapter
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fearlessbear.androidexperiment.R
import kotlin.math.log

class RecyclerBaseLearnActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_recycler_base_learn)
    findViewById<RecyclerView>(R.id.recycler).apply {
      layoutManager = LinearLayoutManager(this.context)
      adapter = MyAdapter()
      addOnScrollListener(object : RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
          super.onScrolled(recyclerView, dx, dy)
          Log.i("TAG_RcBaseLearn", "scroll dy=$dy, canScrollVertically(-1)=${canScrollVertically
          (-1)}, canScrollVertically(1)=${canScrollVertically(1)}")
        }
      })
    }
  }

  class MyAdapter : RecyclerView.Adapter<MyHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder = MyHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_text, parent, false) as
        ViewGroup)

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
      holder.txt.text = "$position"
    }

    override fun getItemCount(): Int = 50


  }

  class MyHolder(val view: ViewGroup) : RecyclerView.ViewHolder(view) {
    val txt: TextView by lazy {
      view.findViewById<TextView>(R.id.text)
    }
  }
}