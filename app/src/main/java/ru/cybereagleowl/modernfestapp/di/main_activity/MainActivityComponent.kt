package ru.cybereagleowl.modernfestapp.di.main_activity

import androidx.activity.ComponentActivity
import dagger.BindsInstance
import dagger.Component
import ru.cybereagleowl.core_api.di.ActivityScope
import ru.cybereagleowl.core_api.providers.ActivityProvider
import ru.cybereagleowl.core_api.providers.facades.AppProvidersFacade
import ru.cybereagleowl.core_api.providers.facades.ProvidersFacade
import ru.cybereagleowl.core_api.providers.UseCasesProvider
import ru.cybereagleowl.modernfestapp.MainActivity

@ActivityScope
@Component
interface MainActivityComponent : ActivityProvider {
    companion object {
        private var mainActivityComponent: ActivityProvider? = null
        fun create(activity: ComponentActivity): ActivityProvider{
            return mainActivityComponent ?: DaggerMainActivityComponent.builder()
                .activity(activity)
                .build().also { mainActivityComponent = it}
        }
    }

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun activity(activity: ComponentActivity): Builder
        fun build(): MainActivityComponent
    }
}