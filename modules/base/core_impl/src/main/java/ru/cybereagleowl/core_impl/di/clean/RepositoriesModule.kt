package ru.cybereagleowl.core_impl.di.clean

import androidx.activity.ComponentActivity
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.Reusable
import ru.cybereagleowl.core_api.clean.domain.boundaries.repository.inputports.AuthorizationRepositoryInputPort
import ru.cybereagleowl.core_impl.clean.data.repositories.VkAuthorizationRepository
import javax.inject.Provider

@Module(includes = [RepositoriesBindingModule::class])
class RepositoriesModule {

}

@Module
interface RepositoriesBindingModule {
    @Binds
    @Reusable
    fun provideVkAuthorizationRepository(repository: VkAuthorizationRepository): AuthorizationRepositoryInputPort
}