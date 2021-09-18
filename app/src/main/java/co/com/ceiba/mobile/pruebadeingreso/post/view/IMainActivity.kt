package co.com.ceiba.mobile.pruebadeingreso.post.view

import co.com.ceiba.mobile.pruebadeingreso.post.model.User

interface IMainActivity{
    fun getUser()

    fun setUsers(listUsers: ArrayList<User>)
    
}