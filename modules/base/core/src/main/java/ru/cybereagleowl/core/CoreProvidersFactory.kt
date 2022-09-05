package ru.cybereagleowl.core

import ru.cybereagleowl.core_api.providers.AppProvider
import ru.cybereagleowl.core_api.providers.UseCasesProvider
import ru.cybereagleowl.core_api.providers.utils.UtilsProvidersFacade
import ru.cybereagleowl.core_impl.di.clean.DaggerCleanComponent
import ru.cybereagleowl.core_impl.di.utils.DaggerUtilsComponent
import ru.cybereagleowl.core_impl.di.utils.UtilsModule

object CoreProvidersFactory {
    fun createUtilsProvider(appProvider: AppProvider): UtilsProvidersFacade = DaggerUtilsComponent.builder()
        .appProvider(appProvider)
        .utilsModule(UtilsModule())
        .build()
    fun createUseCasesProvider(appProvider: AppProvider): UseCasesProvider = DaggerCleanComponent.builder()
        .utilsProvidersFacade(createUtilsProvider(appProvider))
        .build()
}