package co.com.ceiba.mobile.pruebadeingreso.rest

import co.com.ceiba.mobile.pruebadeingreso.post.model.Post
import co.com.ceiba.mobile.pruebadeingreso.post.model.User
import co.com.ceiba.mobile.pruebadeingreso.rest.Endpoints.GET_POST_USER
import co.com.ceiba.mobile.pruebadeingreso.rest.Endpoints.GET_USERS
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface IRestUsers {
    @GET(GET_USERS)
    fun getAllUsers(): Call<List<User>>

    @GET(GET_POST_USER)
    fun getPosts(@Query("userId") id: Int): Call<List<Post>>
}