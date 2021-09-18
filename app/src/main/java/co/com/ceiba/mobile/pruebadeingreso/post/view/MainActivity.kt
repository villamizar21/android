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
import android.widget.SearchView
import co.com.ceiba.mobile.pruebadeingreso.R
import co.com.ceiba.mobile.pruebadeingreso.post.adapter.RecyclerAdapter
import co.com.ceiba.mobile.pruebadeingreso.post.model.User
import co.com.ceiba.mobile.pruebadeingreso.post.presenter.PresenterMain
import co.com.ceiba.mobile.pruebadeingreso.post.view.post_users.PostActivity

class MainActivity : Activity(), IMainActivity, RecyclerAdapter.OnUserClickListener {

    private lateinit var recycler: RecyclerView
    private lateinit var editext: EditText
    private var presenter = PresenterMain(this, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycler = findViewById(R.id.recyclerViewSearchResults)
        editext = findViewById(R.id.editTextSearch)

    }

    override fun onStart() {
        super.onStart()
        presenter.getUsers()
    }

    override fun getUser() {
        presenter.getUsers()
    }

    override fun setUsers(listUsers: ArrayList<User>) {
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = RecyclerAdapter(this, listUsers, this)

        editext.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                (recycler.adapter as RecyclerAdapter).getFilter()?.filter(p0)
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })
    }

    override fun onPostClick(name: String, phone: String, email: String, id: Int, position: Int) {
        val intent = Intent(this, PostActivity::class.java)
        intent.putExtra("id", id)
        intent.putExtra("name", name)
        intent.putExtra("phone", phone)
        intent.putExtra("email", email)
        startActivity(intent)
        editext.setText("")
    }

}
