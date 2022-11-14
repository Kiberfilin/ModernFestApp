package ru.cybereagleowl.core_api.clean.domain.boundaries.presentation.inputports

interface LogInInputPort {
    fun execute(onSuccess: () -> Unit, onFailure: () -> Unit)
}