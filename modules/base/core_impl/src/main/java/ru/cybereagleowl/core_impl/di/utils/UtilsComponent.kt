package ru.cybereagleowl.core_impl.di.utils

import dagger.Component
import ru.cybereagleowl.core_api.di.ApplicationScope
import ru.cybereagleowl.core_api.providers.AppProvider
import ru.cybereagleowl.core_api.providers.utils.UtilsProvidersFacade

@ApplicationScope
@Component(
    dependencies = [AppProvider::class],
    modules = [UtilsModule::class]
)
interface UtilsComponent : UtilsProvidersFacade