package ru.cybereagleowl.core_impl.clean.domain.interactors

import kotlinx.coroutines.flow.Flow
import ru.cybereagleowl.core_api.clean.domain.boundaries.presentation.inputports.CheckIsLoggedInInputPort
import ru.cybereagleowl.core_api.clean.domain.boundaries.repository.inputports.AuthorizationRepositoryInputPort
import javax.inject.Inject

class CheckIsLoggedInInteractor @Inject constructor(
    private var dataInputPort: AuthorizationRepositoryInputPort
) : CheckIsLoggedInInputPort {
    override fun execute(): Flow<Boolean> = dataInputPort.isLoggedIn()
}