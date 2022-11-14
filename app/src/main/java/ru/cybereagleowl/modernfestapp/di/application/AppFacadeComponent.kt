package ru.cybereagleowl.modernfestapp.di.application

import android.app.Application
import dagger.Component
import ru.cybereagleowl.core.CoreProvidersFactory
import ru.cybereagleowl.core_api.di.ApplicationScope
import ru.cybereagleowl.core_api.providers.AppProvider
import ru.cybereagleowl.core_api.providers.facades.AppProvidersFacade
import ru.cybereagleowl.core_api.providers.facades.utils.UtilsProvidersFacade
import ru.cybereagleowl.modernfestapp.App

@ApplicationScope
@Component(dependencies = [AppProvider::class, UtilsProvidersFacade::class])
interface AppFacadeComponent : AppProvidersFacade {
    companion object {
        fun init(application: Application): AppFacadeComponent {
            val appProvider = AppComponent.create(application)
            return DaggerAppFacadeComponent.builder()
                .appProvider(appProvider)
                .utilsProvidersFacade(CoreProvidersFactory.createUtilsProvider(appProvider))
                .build()
        }
    }

    fun inject(app: App)
}