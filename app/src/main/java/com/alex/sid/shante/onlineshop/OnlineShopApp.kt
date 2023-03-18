package com.alex.sid.shante.onlineshop

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp
import java.lang.ref.WeakReference

@HiltAndroidApp
class OnlineShopApp:Application() {
    companion object {
        lateinit var appContext: WeakReference<Context>
    }
    override fun onCreate() {
        super.onCreate()
        appContext = WeakReference(applicationContext)
    }
}