package com.alex.sid.shante.onlineshop.data

import com.alex.sid.shante.onlineshop.data.db.LoginDao
import com.alex.sid.shante.onlineshop.domain.models.User
import com.alex.sid.shante.onlineshop.domain.repositories.LoginRepository

class LoginRepositoryImpl(
    private val dao: LoginDao
) : LoginRepository {

    override suspend fun insertUser(user: User) {
        dao.insertUser(user)
    }

    override suspend fun getUser(login: String): User? {
        return dao.findUser(login)
    }
}