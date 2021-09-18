package co.com.ceiba.mobile.pruebadeingreso.post.view.post_users

import co.com.ceiba.mobile.pruebadeingreso.post.model.Post
import co.com.ceiba.mobile.pruebadeingreso.post.model.User

interface IPost {
    fun getPostUsers(userId: Int)
    fun listPost(listPost: ArrayList<Post>)

}