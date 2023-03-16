package com.alex.sid.shante.onlineshop.di

import com.alex.sid.shante.onlineshop.data.LoginRepositoryImpl
import com.alex.sid.shante.onlineshop.data.OnlineShopApi
import com.alex.sid.shante.onlineshop.data.ShopRepositoryImpl
import com.alex.sid.shante.onlineshop.data.db.LoginDataBase
import com.alex.sid.shante.onlineshop.domain.repositories.LoginRepository
import com.alex.sid.shante.onlineshop.domain.repositories.ShopRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Provides
    @Singleton
    fun provideLoginRepository(
        dataBase: LoginDataBase
    ): LoginRepository {
        return LoginRepositoryImpl(dataBase.loginDao)
    }

    @Provides
    @Singleton
    fun provideShopRepository(
        api: OnlineShopApi
    ): ShopRepository {
        return ShopRepositoryImpl(api)
    }
}