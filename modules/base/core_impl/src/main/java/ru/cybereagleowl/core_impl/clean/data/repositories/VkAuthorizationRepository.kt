package ru.cybereagleowl.core_impl.clean.data.repositories

import androidx.activity.ComponentActivity
import com.vk.api.sdk.VK
import com.vk.api.sdk.auth.VKAuthenticationResult
import com.vk.api.sdk.auth.VKScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ru.cybereagleowl.core_api.clean.domain.boundaries.repository.inputports.AuthorizationRepositoryInputPort
import javax.inject.Inject
import javax.inject.Provider

class VkAuthorizationRepository @Inject constructor() : AuthorizationRepositoryInputPort {
    @Inject
    lateinit var activity: Provider<ComponentActivity>
    override fun isLoggedIn(): Flow<Boolean> = flow { emit(VK.isLoggedIn()) }
    override fun login(onSuccess: () -> Unit, onFailure: () -> Unit) {
        VK.login(activity.get()) { result: VKAuthenticationResult ->
            when (result) {
                is VKAuthenticationResult.Success -> onSuccess
                is VKAuthenticationResult.Failed -> onFailure
            }
        }.launch(listOf(VKScope.WALL, VKScope.PHOTOS))
    }

}