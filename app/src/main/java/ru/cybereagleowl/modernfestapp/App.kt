package ru.cybereagleowl.modernfestapp

import android.app.Application
import com.vk.api.sdk.VK
import com.vk.api.sdk.VKTokenExpiredHandler
import ru.cybereagleowl.core_api.providers.AppWithFacade
import ru.cybereagleowl.core_api.providers.ProvidersFacade
import ru.cybereagleowl.modernfestapp.di.application.FacadeComponent

class App : Application(), AppWithFacade {
    override fun onCreate() {
        super.onCreate()
        (getFacade() as FacadeComponent).inject(this)
        VK.addTokenExpiredHandler(tokenTracker)//need to move to main menu
    }

    //need to move to main menu
    private val tokenTracker = object : VKTokenExpiredHandler {
        override fun onTokenExpired() {
            //need to move to main menu
            TODO("Need to handle vk.com token expiration in another place")
        }
    }

    override fun getFacade(): ProvidersFacade =
        facadeComponent ?: FacadeComponent.init(this).also { facadeComponent = it }

    companion object {
        private var facadeComponent: FacadeComponent? = null
    }
}