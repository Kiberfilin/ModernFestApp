package ru.cybereagleowl.modernfestapp

import android.app.Application
import com.vk.api.sdk.VK
import com.vk.api.sdk.VKTokenExpiredHandler
import ru.cybereagleowl.core_api.providers.facades.AppProvidersFacade
import ru.cybereagleowl.core_api.providers.facades.AppWithFacade
import ru.cybereagleowl.modernfestapp.di.application.AppFacadeComponent

class App : Application(), AppWithFacade {
    override fun onCreate() {
        super.onCreate()
        (getFacade() as AppFacadeComponent).inject(this)
        VK.addTokenExpiredHandler(tokenTracker)//need to move to main menu
    }

    //need to move to main menu
    private val tokenTracker = object : VKTokenExpiredHandler {
        override fun onTokenExpired() {
            //need to move to main menu
            TODO("Need to handle vk.com token expiration in another place")
        }
    }

    override fun getFacade(): AppProvidersFacade =
        appFacadeComponent ?: AppFacadeComponent.init(this).also { appFacadeComponent = it }

    companion object {
        private var appFacadeComponent: AppFacadeComponent? = null
    }
}