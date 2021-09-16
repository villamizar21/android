package co.com.ceiba.mobile.pruebadeingreso.post.presenter

import android.content.Context
import co.com.ceiba.mobile.pruebadeingreso.post.iterator.IteratorMain
import co.com.ceiba.mobile.pruebadeingreso.post.iterator.IteratorMainActivity
import co.com.ceiba.mobile.pruebadeingreso.post.view.IMainActivity

class PresenterMain : IPresenterMainactivity {

    var ctx: Context ?= null
    var iterator: IteratorMainActivity ?= null
    var view: IMainActivity?= null

    constructor(ctx: Context?, view: IMainActivity?) {
        this.ctx = ctx
        this.iterator = IteratorMain(ctx,this)
        this.view = view
    }


    override fun getUsers() {
        iterator?.getUsers()
    }
}