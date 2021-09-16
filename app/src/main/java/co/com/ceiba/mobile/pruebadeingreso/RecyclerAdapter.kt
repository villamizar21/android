package co.com.ceiba.mobile.pruebadeingreso

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import co.com.ceiba.mobile.pruebadeingreso.post.model.User


class RecyclerAdapter(private val context: Context, val listaUser: List<User>) :
    RecyclerView.Adapter<AdapterMain<*>>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterMain<*> {
        return userViewHolder(
            LayoutInflater.from(context).inflate(R.layout.user_list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: AdapterMain<*>, position: Int) {
        holder.bind(listaUser[position], position)
    }

    override fun getItemCount(): Int {
        return listaUser.size
    }

    inner class userViewHolder(itemView: View) : AdapterMain<User>(itemView) {
        override fun bind(item: User, position: Int) {
            val name: TextView = itemView.findViewById(R.id.name)
            val phone: TextView = itemView.findViewById(R.id.phone)
            val email: TextView = itemView.findViewById(R.id.email)

            name.text = item.name
            phone.text = item.phone
            email.text = item.email
        }

    }
}