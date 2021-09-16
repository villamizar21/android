package co.com.ceiba.mobile.pruebadeingreso.post.model



import android.arch.persistence.room.Entity


@Entity
class User(
    val id: Int,
    val name: String,
    val username: String,
    val email: String,
    val address: Address,
    val phone: String,
    val website: String,
    val company: Company
)
