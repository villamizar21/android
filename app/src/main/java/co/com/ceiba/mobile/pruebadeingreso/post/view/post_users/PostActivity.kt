package co.com.ceiba.mobile.pruebadeingreso.post.view.post_users

import android.app.Activity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.TextView
import co.com.ceiba.mobile.pruebadeingreso.R
import co.com.ceiba.mobile.pruebadeingreso.post.adapter.RecyclerAdapter
import co.com.ceiba.mobile.pruebadeingreso.post.adapter.RecyclerPost
import co.com.ceiba.mobile.pruebadeingreso.post.model.Post
import co.com.ceiba.mobile.pruebadeingreso.post.presenter.PresenterMain

class PostActivity : Activity(),IPost {
    private lateinit var recycler: RecyclerView
    private lateinit var name: TextView
    private lateinit var email: TextView
    private lateinit var phone: TextView

    private var presenter = PresenterMain(this,this)
    var adapter: RecyclerPost?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post)
        recycler = findViewById(R.id.recyclerViewPostsResults)
        name =  findViewById(R.id.name)
        email =  findViewById(R.id.email)
        phone =  findViewById(R.id.phone)

        if(intent.extras != null){
           getPostUsers(intent.getIntExtra("id",0))
            name.text = intent.getStringExtra("name")
            email.text = intent.getStringExtra("email")
            phone.text = intent.getStringExtra("phone")
        }
    }

    override fun onStart() {
        super.onStart()
    }

    override fun getPostUsers(userId: Int) {
        presenter.getPostUser(userId)
    }

    override fun listPost(listPost: ArrayList<Post>) {
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = RecyclerPost(this,listPost)
    }
}