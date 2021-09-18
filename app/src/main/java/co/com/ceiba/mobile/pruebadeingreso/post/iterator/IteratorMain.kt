package co.com.ceiba.mobile.pruebadeingreso.post.iterator

import android.content.Context
import android.util.Log
import co.com.ceiba.mobile.pruebadeingreso.data.DataBase
import co.com.ceiba.mobile.pruebadeingreso.post.Post_dao.PostDao
import co.com.ceiba.mobile.pruebadeingreso.post.model.Post
import co.com.ceiba.mobile.pruebadeingreso.post.model.User
import co.com.ceiba.mobile.pruebadeingreso.post.presenter.PresenterMain
import co.com.ceiba.mobile.pruebadeingreso.rest.Endpoints
import co.com.ceiba.mobile.pruebadeingreso.rest.IRestUsers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class IteratorMain : IteratorMainActivity {

    var ctx: Context? = null
    var presenter: PresenterMain? = null
    var postDao: PostDao? = null
    var data: DataBase? = null
    var user: ArrayList<User> = ArrayList()
    var post: ArrayList<Post> = ArrayList()


    constructor(context: Context?, presenter: PresenterMain?) {
        this.ctx = context
        this.presenter = presenter
        this.postDao = data?.getInstance(context)?.postUser()
    }

    constructor()

    fun getRetrofi(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Endpoints.URL_BASE)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    override fun getUsers() {
        val resultService = getRetrofi().create(IRestUsers::class.java)
        val result: Call<List<User>> = resultService.getAllUsers()

        result.enqueue(object : Callback<List<User>> {

            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                user = response.body() as ArrayList<User>
                listaUsers(user)
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                Log.e("", " Fallo en la Respuesta " + t.message)
            }
        })
    }

    override fun listaUsers(listaUser: ArrayList<User>) {
        presenter?.setUsers(listaUser)
    }

    override fun getPostList(userId: Int) {

        val resultService = getRetrofi().create(IRestUsers::class.java)
        val result: Call<List<Post>> = resultService.getPosts(userId)

        result.enqueue(object : Callback<List<Post>> {

            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
               post =response.body() as ArrayList<Post>
                listaPost(post)
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                Log.e("", " Fallo en la Respuesta " + t.message)
            }
        })
    }

    override fun listaPost(listaPost: ArrayList<Post>) {
       presenter?.setPostUsers(listaPost)
    }

}