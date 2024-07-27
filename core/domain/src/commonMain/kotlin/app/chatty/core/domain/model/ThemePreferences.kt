package app.chatty.core.domain.model

import app.chatty.core.domain.model.DarkModePreference.FollowSystem
import kotlinx.serialization.Serializable

@Serializable
data class ThemePreferences(
    val darkMode: DarkModePreference,
    val dynamicColor: Boolean,
) {
    companion object {
        fun getDefaultInstance() = ThemePreferences(
            darkMode = FollowSystem,
            dynamicColor = false,
        )
    }
}
