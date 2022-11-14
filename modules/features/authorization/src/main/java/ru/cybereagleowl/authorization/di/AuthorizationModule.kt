package ru.cybereagleowl.authorization.di

import dagger.Module
import dagger.Provides

@Module
class AuthorizationModule {
    @Provides
    fun provideString() = "String 1 for example" //TODO test
}