package co.com.ceiba.mobile.pruebadeingreso.post.iterator

import co.com.ceiba.mobile.pruebadeingreso.post.model.Post
import co.com.ceiba.mobile.pruebadeingreso.post.model.User

interface IteratorMainActivity {
    fun getUsers()
    fun listaUsers(listaUser: ArrayList<User>)

    fun getPostList(userId: Int)
    fun listaPost(listaPost: ArrayList<Post>)
}