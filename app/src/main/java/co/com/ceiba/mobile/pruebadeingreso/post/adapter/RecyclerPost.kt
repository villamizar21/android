package co.com.ceiba.mobile.pruebadeingreso.post.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import co.com.ceiba.mobile.pruebadeingreso.R
import co.com.ceiba.mobile.pruebadeingreso.post.model.Post

class RecyclerPost(private val context: Context, private val listaUserPos: List<Post>) : RecyclerView.Adapter<AdapterPost<*>>() {

    var listPost: ArrayList<Post> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterPost<*> {
        return PostViewHolder(
            LayoutInflater.from(context).inflate(R.layout.post_list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: AdapterPost<*>, position: Int) {
        holder.bind(listaUserPos[position],position)
    }

    override fun getItemCount(): Int {
        return listaUserPos.size
    }

    inner class PostViewHolder(itemView: View) : AdapterPost<Post>(itemView) {
        override fun bind(item: Post, position: Int) {
            val title: TextView = itemView.findViewById(R.id.title)
            val body: TextView = itemView.findViewById(R.id.body)

            title.text = item.title
            body.text = item.body
        }
    }

}