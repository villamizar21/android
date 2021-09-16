package co.com.ceiba.mobile.pruebadeingreso.post.view

import android.app.Activity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.EditText
import android.widget.LinearLayout
import co.com.ceiba.mobile.pruebadeingreso.R
import co.com.ceiba.mobile.pruebadeingreso.RecyclerAdapter
import co.com.ceiba.mobile.pruebadeingreso.post.model.User
import co.com.ceiba.mobile.pruebadeingreso.post.presenter.PresenterMain

class MainActivity : Activity(), IMainActivity {

    private lateinit var recycler: RecyclerView
    private lateinit var editext: EditText
    private var presenter = PresenterMain(this, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycler = findViewById(R.id.recyclerViewSearchResults)
        editext = findViewById(R.id.editTextSearch)
        getUser()

        recycler.layoutManager = LinearLayoutManager(this)
        //recycler.adapter = RecyclerAdapter(this,)


    }

    override fun onStart() {
        super.onStart()
    }

    override fun getUser() {
        Log.e("", "paso")
        presenter.getUsers()
    }

}