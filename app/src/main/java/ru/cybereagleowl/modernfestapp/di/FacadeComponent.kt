package ru.cybereagleowl.modernfestapp.di

import androidx.activity.ComponentActivity
import dagger.Component
import ru.cybereagleowl.core.CoreProvidersFactory
import ru.cybereagleowl.core_api.di.ActivityScope
import ru.cybereagleowl.core_api.providers.ActivityProvider
import ru.cybereagleowl.core_api.providers.UseCasesProvider
import ru.cybereagleowl.core_api.providers.facades.AppProvidersFacade
import ru.cybereagleowl.core_api.providers.facades.ProvidersFacade
import ru.cybereagleowl.modernfestapp.App
import ru.cybereagleowl.modernfestapp.di.main_activity.MainActivityComponent

@ActivityScope
@Component(
    dependencies = [AppProvidersFacade::class, ActivityProvider::class, UseCasesProvider::class]
)
interface FacadeComponent : ProvidersFacade {
    companion object {
        fun init(activity: ComponentActivity): FacadeComponent =
            DaggerFacadeComponent.builder()
                .appProvidersFacade((activity.application as App).getFacade())
                .activityProvider(MainActivityComponent.create(activity))
                .useCasesProvider(
                    CoreProvidersFactory.createUseCasesProvider(
                        (activity.application as App).getFacade(),
                        MainActivityComponent.create(activity)
                    )
                ).build()
    }
}