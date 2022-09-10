package ru.cybereagleowl.core_api.navigation

interface ModernFestAppDestination {
    val route: String
}

object Login : ModernFestAppDestination {
    override val route: String
        get() = "login"
}

object HomeScreen : ModernFestAppDestination {
    override val route: String
        get() = "home"
}

object News : ModernFestAppDestination {
    override val route: String
        get() = "news"
}

object Events : ModernFestAppDestination {
    override val route: String
        get() = "events"
}