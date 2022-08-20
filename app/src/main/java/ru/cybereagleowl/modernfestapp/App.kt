package ru.cybereagleowl.modernfestapp

import android.app.Application
import com.vk.api.sdk.VK
import com.vk.api.sdk.VKTokenExpiredHandler

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        VK.addTokenExpiredHandler(tokenTracker)//need to move to main menu
    }

    //need to move to main menu
    private val tokenTracker = object : VKTokenExpiredHandler {
        override fun onTokenExpired() {
            //need to move to main menu
            TODO("Need to handle vk.com token expiration in another place")
        }
    }
}