package ru.cybereagleowl.core

import ru.cybereagleowl.core_api.providers.ActivityProvider
import ru.cybereagleowl.core_api.providers.AppProvider
import ru.cybereagleowl.core_api.providers.UseCasesProvider
import ru.cybereagleowl.core_api.providers.facades.utils.UtilsProvidersFacade
import ru.cybereagleowl.core_impl.di.clean.CleanComponent
import ru.cybereagleowl.core_impl.di.clean.DaggerCleanComponent
import ru.cybereagleowl.core_impl.di.utils.DaggerUtilsComponent

object CoreProvidersFactory {
    fun createUtilsProvider(appProvider: AppProvider): UtilsProvidersFacade =
        DaggerUtilsComponent.builder()
            .appProvider(appProvider)
            .build()

    fun createUseCasesProvider(
        utilsProvidersFacade: UtilsProvidersFacade,
        activityProvider: ActivityProvider
    ): UseCasesProvider = CleanComponent.init(utilsProvidersFacade, activityProvider)
}