package co.com.ceiba.mobile.pruebadeingreso.rest

import co.com.ceiba.mobile.pruebadeingreso.post.model.User
import co.com.ceiba.mobile.pruebadeingreso.rest.Endpoints.GET_USERS
import retrofit2.Call
import retrofit2.http.GET

interface IRestUsers {
    @GET(GET_USERS)
    fun getAllUsers(): Call<List<User>>
}