package ru.cybereagleowl.core_impl.clean.domain.interactors

import ru.cybereagleowl.core_api.clean.domain.boundaries.presentation.inputports.LogInInputPort
import ru.cybereagleowl.core_api.clean.domain.boundaries.repository.inputports.AuthorizationRepositoryInputPort
import javax.inject.Inject

class LogInInteractor @Inject constructor(
    private var dataInputPort: AuthorizationRepositoryInputPort
) : LogInInputPort {
    override fun execute(onSuccess: () -> Unit, onFailure: () -> Unit) {
        dataInputPort.login(onSuccess, onFailure)
    }
}