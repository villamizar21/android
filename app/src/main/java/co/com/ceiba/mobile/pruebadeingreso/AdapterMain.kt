package co.com.ceiba.mobile.pruebadeingreso

import android.support.v7.widget.RecyclerView
import android.view.View
import co.com.ceiba.mobile.pruebadeingreso.post.model.User

abstract class AdapterMain<T>(itemView: View) : RecyclerView.ViewHolder(itemView){
    abstract fun bind(item: User, position:Int)
}