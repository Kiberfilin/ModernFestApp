package ru.cybereagleowl.modernfestapp.di.application

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import ru.cybereagleowl.core_api.di.ApplicationScope
import ru.cybereagleowl.core_api.providers.AppProvider

@ApplicationScope
@Component
interface AppComponent : AppProvider {
    companion object {
        private var appComponent: AppProvider? = null
        fun create(application: Application): AppProvider {
            return appComponent ?: DaggerAppComponent.builder()
                .application(application)
                .build().also { appComponent = it }
        }
    }

    @Component.Builder
    interface Builder{
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }
}