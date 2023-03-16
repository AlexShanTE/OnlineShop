package com.alex.sid.shante.onlineshop.domain.repositories

import com.alex.sid.shante.onlineshop.domain.models.User

interface LoginRepository {
    suspend fun insertUser(user: User)
    suspend fun getUser(login: String) : User?
}