package app.chatty.core.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class UserPreferences(
    val darkMode: DarkModePreference,
    val dynamicColor: Boolean,
    val onboardingCompleted: Boolean,
) {

    companion object {
        fun getDefaultInstance() = UserPreferences(
            darkMode = DarkModePreference.FollowSystem,
            dynamicColor = false,
            onboardingCompleted = false,
        )
    }
}
