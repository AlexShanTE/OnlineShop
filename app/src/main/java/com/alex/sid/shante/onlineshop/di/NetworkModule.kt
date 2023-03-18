package com.alex.sid.shante.onlineshop.di

import com.alex.sid.shante.onlineshop.data.OnlineShopApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun provideBaseUrl() = "https://run.mocky.io/v3/"

    @Provides
    @Singleton
    fun provideRetrofitBuilder(baseUrl: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideGitApi(retrofit: Retrofit): OnlineShopApi {
        return retrofit.create(OnlineShopApi::class.java)
    }
}