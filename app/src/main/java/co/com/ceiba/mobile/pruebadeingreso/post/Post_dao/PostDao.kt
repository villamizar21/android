package co.com.ceiba.mobile.pruebadeingreso.post.Post_dao

import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import androidx.room.Dao
import androidx.room.Update
import co.com.ceiba.mobile.pruebadeingreso.post.model.User

@Dao
interface PostDao {
    @Query("SELECT * FROM User")
    fun getAll(): ArrayList<User>

    @Query("SELECT * FROM User WHERE id = :userId")
    fun getId(userId: Int): User

    @Insert
    fun insetPost(user: User)

}