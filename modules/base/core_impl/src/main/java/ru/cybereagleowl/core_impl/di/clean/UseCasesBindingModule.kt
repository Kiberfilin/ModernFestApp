package ru.cybereagleowl.core_impl.di.clean

import dagger.Binds
import dagger.Module
import dagger.Reusable
import ru.cybereagleowl.core_api.clean.domain.boundaries.presentation.inputports.CheckIsLoggedInInputPort
import ru.cybereagleowl.core_api.clean.domain.boundaries.presentation.inputports.LogInInputPort
import ru.cybereagleowl.core_impl.clean.domain.interactors.CheckIsLoggedInInteractor
import ru.cybereagleowl.core_impl.clean.domain.interactors.LogInInteractor

@Module
interface UseCasesBindingModule {
    @Binds
    @Reusable
    fun provideLogInInputPort(logInInteractor: LogInInteractor): LogInInputPort

    @Binds
    @Reusable
    fun provideCheckIsLoggedInInputPort(checkIsLoggedInInteractor: CheckIsLoggedInInteractor): CheckIsLoggedInInputPort
}