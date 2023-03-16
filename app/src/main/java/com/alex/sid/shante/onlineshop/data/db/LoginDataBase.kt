package com.alex.sid.shante.onlineshop.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.alex.sid.shante.onlineshop.domain.models.User

@Database(
    entities = [User::class],
    version = 2
)
abstract class LoginDataBase: RoomDatabase() {

    abstract val loginDao:LoginDao

    companion object {
        const val DATABASE_NAME = "login_db"
    }

}