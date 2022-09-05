package ru.cybereagleowl.core_api.providers

import android.app.Application

interface AppProvider {
    fun provideApplication(): Application
}