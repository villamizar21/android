package co.com.ceiba.mobile.pruebadeingreso.post.iterator

import android.content.Context
import android.util.Log
import co.com.ceiba.mobile.pruebadeingreso.post.model.User
import co.com.ceiba.mobile.pruebadeingreso.post.presenter.PresenterMain
import co.com.ceiba.mobile.pruebadeingreso.post.view.MainActivity
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

    constructor(ctx: Context?, presenter: PresenterMain?) {
        this.ctx = ctx
        this.presenter = presenter
    }

    private fun getRetrofi(): Retrofit {
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
                Log.e("", " Respuesta exitosa "+ response.body())
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                Log.e("", " Fallo en la Respuesta " + t.message)
            }

        })

    }



}