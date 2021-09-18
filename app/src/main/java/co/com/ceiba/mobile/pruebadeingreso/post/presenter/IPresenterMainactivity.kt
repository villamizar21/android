package co.com.ceiba.mobile.pruebadeingreso.post.presenter

import co.com.ceiba.mobile.pruebadeingreso.post.model.Post
import co.com.ceiba.mobile.pruebadeingreso.post.model.User

interface IPresenterMainactivity {

    fun getUsers()

    fun setUsers(listUsers: ArrayList<User>)

    fun getPostUser(userId: Int)

    fun setPostUsers(listPost: ArrayList<Post>)



}