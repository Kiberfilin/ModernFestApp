package ru.cybereagleowl.core_api.providers

import ru.cybereagleowl.core_api.clean.domain.boundaries.presentation.inputports.CheckIsLoggedInInputPort
import ru.cybereagleowl.core_api.clean.domain.boundaries.presentation.inputports.LogInInputPort

interface UseCasesProvider {
    fun provideLogInInputPort(): LogInInputPort
    fun provideCheckIsLoggedInInputPort(): CheckIsLoggedInInputPort
    //fun provideGetPlacesInputPort(): GetPlacesInputPort
    //fun provideGetNewsInputPort(): GetNewsInputPort
    //fun provideGetCardsInputPort(): GetCardsInputPort
}