package ru.cybereagleowl.core_api.clean.domain.boundaries.presentation.inputports

import kotlinx.coroutines.flow.Flow

interface CheckIsLoggedInInputPort {
    fun execute(): Flow<Boolean>
}