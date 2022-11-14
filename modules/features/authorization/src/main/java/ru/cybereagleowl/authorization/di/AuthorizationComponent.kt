package ru.cybereagleowl.authorization.di

import android.app.Activity
import dagger.BindsInstance
import dagger.Component
import ru.cybereagleowl.core_api.di.AuthorizationScope
import ru.cybereagleowl.core_api.providers.facades.ProvidersFacade

@AuthorizationScope
@Component(modules = [AuthorizationModule::class])
interface AuthorizationComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun activity(activity: Activity): Builder

        @BindsInstance
        fun providersFacade(facade: ProvidersFacade): Builder
        fun build(): AuthorizationComponent
    }

    companion object {
        fun create(facade: ProvidersFacade, activity: Activity): AuthorizationComponent =
            DaggerAuthorizationComponent.builder()
                .providersFacade(facade)
                .activity(activity)
                .build()
    }
}