package ru.cybereagleowl.core_impl.di.clean

import dagger.Component
import ru.cybereagleowl.core_api.di.ApplicationScope
import ru.cybereagleowl.core_api.providers.UseCasesProvider
import ru.cybereagleowl.core_api.providers.utils.UtilsProvidersFacade

@ApplicationScope
@Component(
    dependencies = [UtilsProvidersFacade::class],
    modules = [UseCasesBindingModule::class, RepositoriesBindingModule::class]
)
interface CleanComponent : UseCasesProvider