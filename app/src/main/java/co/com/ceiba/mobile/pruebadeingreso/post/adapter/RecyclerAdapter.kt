package co.com.ceiba.mobile.pruebadeingreso.post.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import co.com.ceiba.mobile.pruebadeingreso.R
import co.com.ceiba.mobile.pruebadeingreso.post.model.User


class RecyclerAdapter(
    private val context: Context,
    val listUser: ArrayList<User>,
    private val itemClick: OnUserClickListener
) :
    RecyclerView.Adapter<AdapterMain<*>>() {

    var listFilter = listUser
    var newList = listUser

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterMain<*> {
        return userViewHolder(
            LayoutInflater.from(context).inflate(R.layout.user_list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: AdapterMain<*>, position: Int) {
        holder.bind(listUser[position], position)
    }

    fun filter(): Filter = object : Filter() {
        override fun performFiltering(charSequence: CharSequence): FilterResults {
            val filterList = ArrayList<User>()
            if (charSequence.toString().isEmpty()) {
                filterList.addAll(newList)
            } else {
                for (user in newList) {
                    if (user.name.toLowerCase().startsWith(charSequence.toString().toLowerCase())) {
                        filterList.add(user)
                    }
                }
            }
            val filterResults = FilterResults()
            filterResults.values = filterList
            return filterResults
        }

        override fun publishResults(charSequence: CharSequence, filterResults: FilterResults) {
            listFilter.clear()
            listFilter.addAll(filterResults.values as Collection<User>)//filterResults.values as Collection<User?>
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return listUser.size
    }

    inner class userViewHolder(itemView: View) : AdapterMain<User>(itemView) {
        override fun bind(item: User, position: Int) {
            val name: TextView = itemView.findViewById(R.id.name)
            val phone: TextView = itemView.findViewById(R.id.phone)
            val email: TextView = itemView.findViewById(R.id.email)
            val btn: Button = itemView.findViewById(R.id.btn_view_post)

            btn.setOnClickListener { itemClick.onPostClick(item.name,item.phone,item.email,item.id,position) }
            name.text = item.name
            phone.text = item.phone
            email.text = item.email
        }

    }
    fun getFilter(): Filter? {
        return filter()
    }

    interface OnUserClickListener {
        fun onPostClick(name: String, phone: String, email: String,id:Int, position: Int)
    }
}