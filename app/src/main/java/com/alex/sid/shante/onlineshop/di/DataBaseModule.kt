package com.alex.sid.shante.onlineshop.di

import android.content.Context
import androidx.room.Room
import com.alex.sid.shante.onlineshop.data.db.LoginDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataBaseModule {

    @Provides
    @Singleton
    fun provideLoginDataBase(@ApplicationContext appContext: Context): LoginDataBase {
        return Room.databaseBuilder(
            appContext,
            LoginDataBase::class.java,
            LoginDataBase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideLoginDao(dataBase: LoginDataBase) = dataBase.loginDao

}