package co.com.ceiba.mobile.pruebadeingreso.post.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import co.com.ceiba.mobile.pruebadeingreso.post.model.Post

abstract class AdapterPost <T>(itemView: View) : RecyclerView.ViewHolder(itemView){
    abstract fun bind(item: Post, position:Int)
}