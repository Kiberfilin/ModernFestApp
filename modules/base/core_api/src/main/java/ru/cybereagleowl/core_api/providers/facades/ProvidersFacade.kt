package ru.cybereagleowl.core_api.providers.facades

import ru.cybereagleowl.core_api.providers.ActivityProvider
import ru.cybereagleowl.core_api.providers.UseCasesProvider

interface ProvidersFacade: AppProvidersFacade, UseCasesProvider, ActivityProvider