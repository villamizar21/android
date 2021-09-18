package co.com.ceiba.mobile.pruebadeingreso.post.presenter

import android.content.Context
import co.com.ceiba.mobile.pruebadeingreso.post.iterator.IteratorMain
import co.com.ceiba.mobile.pruebadeingreso.post.iterator.IteratorMainActivity
import co.com.ceiba.mobile.pruebadeingreso.post.model.Post
import co.com.ceiba.mobile.pruebadeingreso.post.model.User
import co.com.ceiba.mobile.pruebadeingreso.post.view.IMainActivity
import co.com.ceiba.mobile.pruebadeingreso.post.view.post_users.IPost

class PresenterMain : IPresenterMainactivity {

    var ctx: Context ?= null
    var iterator: IteratorMainActivity ?= null
    var view: IMainActivity?= null
    var viewPost: IPost?= null

    constructor(ctx: Context?, view: IMainActivity?) {
        this.ctx = ctx
        this.iterator = IteratorMain(ctx,this)
        this.view = view
    }
    constructor(ctx: Context?, view:IPost) {
        this.ctx = ctx
        this.viewPost = view
        this.iterator = IteratorMain(ctx,this)
    }


    override fun getUsers() {
        iterator?.getUsers()
    }

    override fun setUsers(listUsers: ArrayList<User>) {
        view?.setUsers(listUsers)
    }

    override fun getPostUser(userId: Int) {
        iterator?.getPostList(userId)
    }

    override fun setPostUsers(listPost: ArrayList<Post>) {
        viewPost?.listPost(listPost)
    }

}