package ru.cybereagleowl.core_api.providers

import androidx.activity.ComponentActivity

interface ActivityProvider {
    fun provideActivity(): ComponentActivity
}