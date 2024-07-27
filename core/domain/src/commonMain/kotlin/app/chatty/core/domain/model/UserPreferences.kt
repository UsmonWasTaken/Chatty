package app.chatty.core.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class UserPreferences(
    val onboardingCompleted: Boolean,
) {

    companion object {
        fun getDefaultInstance() = UserPreferences(
            onboardingCompleted = false,
        )
    }
}
