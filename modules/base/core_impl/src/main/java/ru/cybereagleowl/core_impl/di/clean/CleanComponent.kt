package ru.cybereagleowl.core_impl.di.clean

import dagger.Component
import ru.cybereagleowl.core_api.di.ActivityScope
import ru.cybereagleowl.core_api.providers.ActivityProvider
import ru.cybereagleowl.core_api.providers.UseCasesProvider
import ru.cybereagleowl.core_api.providers.facades.utils.UtilsProvidersFacade

@ActivityScope
@Component(
    dependencies = [UtilsProvidersFacade::class, ActivityProvider::class],
    modules = [UseCasesBindingModule::class, RepositoriesModule::class]
)
interface CleanComponent : UseCasesProvider {
    companion object {
        fun init(
            utilsProvidersFacade: UtilsProvidersFacade,
            activityProvider: ActivityProvider
        ): UseCasesProvider = DaggerCleanComponent.builder()
            .utilsProvidersFacade(utilsProvidersFacade)
            .activityProvider(activityProvider)
            .build()
    }
}