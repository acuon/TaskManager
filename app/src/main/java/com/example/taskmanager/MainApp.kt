package com.example.taskmanager

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

private var appContext: MainApp? = null
@HiltAndroidApp
class MainApp : Application() {
    override fun onCreate() {
        super.onCreate()
        appContext = this
    }

    companion object {
        fun getAppContext(): MainApp {
            return appContext!!
        }
    }
}