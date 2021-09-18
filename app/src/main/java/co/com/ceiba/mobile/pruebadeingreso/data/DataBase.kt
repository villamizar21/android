package co.com.ceiba.mobile.pruebadeingreso.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import co.com.ceiba.mobile.pruebadeingreso.post.Post_dao.PostDao
import co.com.ceiba.mobile.pruebadeingreso.post.model.User

//@Database(entities = [User::class], version = 1)
@TypeConverters(Convetrers::class)
abstract class DataBase : RoomDatabase() {
    abstract fun postUser(): PostDao
    var instance: DataBase? = null
    fun getInstance(context: Context?): DataBase? {
        if (instance == null)
            instance = Room.databaseBuilder(context!!, DataBase::class.java, "PruebaIngreso")
                .build()
        return instance
    }
}