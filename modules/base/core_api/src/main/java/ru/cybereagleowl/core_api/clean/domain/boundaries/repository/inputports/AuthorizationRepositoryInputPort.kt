package ru.cybereagleowl.core_api.clean.domain.boundaries.repository.inputports

import kotlinx.coroutines.flow.Flow

interface AuthorizationRepositoryInputPort {
    fun isLoggedIn(): Flow<Boolean>
    fun login(onSuccess: () -> Unit, onFailure: () -> Unit)
}