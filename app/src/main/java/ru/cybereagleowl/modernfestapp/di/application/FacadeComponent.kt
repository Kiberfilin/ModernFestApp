package ru.cybereagleowl.modernfestapp.di.application

import android.app.Application
import dagger.Component
import ru.cybereagleowl.core.CoreProvidersFactory
import ru.cybereagleowl.core_api.di.ApplicationScope
import ru.cybereagleowl.core_api.providers.AppProvider
import ru.cybereagleowl.core_api.providers.ProvidersFacade
import ru.cybereagleowl.core_api.providers.UseCasesProvider
import ru.cybereagleowl.core_api.providers.utils.UtilsProvidersFacade
import ru.cybereagleowl.modernfestapp.App

@ApplicationScope
@Component(
    dependencies = [AppProvider::class, UtilsProvidersFacade::class, UseCasesProvider::class],
    modules = []
)
interface FacadeComponent : ProvidersFacade {
    companion object {
        fun init(application: Application): FacadeComponent {
            val appProvider = AppComponent.create(application)
            return DaggerFacadeComponent.builder()
                .appProvider(appProvider)
                .utilsProvidersFacade(CoreProvidersFactory.createUtilsProvider(appProvider))
                .useCasesProvider(CoreProvidersFactory.createUseCasesProvider(appProvider))
                .build()
        }
    }

    fun inject(app: App)
}