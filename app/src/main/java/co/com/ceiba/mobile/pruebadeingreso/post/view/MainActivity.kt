package co.com.ceiba.mobile.pruebadeingreso.post.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.EditText
import co.com.ceiba.mobile.pruebadeingreso.R
import co.com.ceiba.mobile.pruebadeingreso.post.adapter.RecyclerAdapter
import co.com.ceiba.mobile.pruebadeingreso.post.iterator.IteratorMain
import co.com.ceiba.mobile.pruebadeingreso.post.model.Post
import co.com.ceiba.mobile.pruebadeingreso.post.model.User
import co.com.ceiba.mobile.pruebadeingreso.post.presenter.PresenterMain
import co.com.ceiba.mobile.pruebadeingreso.post.view.post_users.PostActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : Activity(),IMainActivity,RecyclerAdapter.OnUserClickListener{

    private lateinit var recycler: RecyclerView
    private lateinit var editext: EditText
    private var presenter = PresenterMain(this, this)
    var adapter: RecyclerAdapter?= null
    val result = IteratorMain()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycler = findViewById(R.id.recyclerViewSearchResults)
        editext = findViewById(R.id.editTextSearch)
        CoroutineScope(Dispatchers.IO).launch {
            presenter.getUsers()
        }
    }

    override fun onStart() {
        super.onStart()
    }

    override fun getUser() {
        presenter.getUsers()
    }

    override fun setUsers(listUsers: ArrayList<User>) {
       recycler.layoutManager = LinearLayoutManager(this)
       recycler.adapter = RecyclerAdapter(this,listUsers,this)
    }

    override fun onPostClick(name: String, phone: String, email: String,id:Int, position: Int) {
        val intent = Intent(this,PostActivity::class.java)
        intent.putExtra("id",id)
        intent.putExtra("name",name)
        intent.putExtra("phone",phone)
        intent.putExtra("email",email)
        Log.e("", "datos que van a pasar $id$name")
        startActivity(intent)
    }
}
