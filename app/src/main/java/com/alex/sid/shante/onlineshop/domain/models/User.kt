package com.alex.sid.shante.onlineshop.domain.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int = 0,
    @ColumnInfo(name = "login")
    val login: String = "",
    @ColumnInfo(name = "firstName")
    val firstName: String = "",
    @ColumnInfo(name = "lastName")
    val lastName: String = "",
    @ColumnInfo(name = "email")
    val email: String = "",
    @ColumnInfo(name = "password")
    val password: String = ""
)
