package co.com.ceiba.mobile.pruebadeingreso.data

import androidx.room.TypeConverter
import co.com.ceiba.mobile.pruebadeingreso.post.model.Address
import co.com.ceiba.mobile.pruebadeingreso.post.model.Company
import com.google.gson.Gson

class Convetrers {
    @TypeConverter
    fun ToAdrees(modelo: Address): String {
        return Gson().toJson(modelo)
    }

    @TypeConverter
    fun fromAdrees(modelo: String): Address {
        return Gson().fromJson(modelo, Address::class.java)
    }

    @TypeConverter
    fun Tocompany(company: Company): String {
        return Gson().toJson(company)
    }

    @TypeConverter
    fun fromcompany(company: String): Company {
        return Gson().fromJson(company, Company::class.java)
    }
}