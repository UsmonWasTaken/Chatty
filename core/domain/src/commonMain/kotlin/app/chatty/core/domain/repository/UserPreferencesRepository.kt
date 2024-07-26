package app.chatty.core.domain.repository

import app.chatty.core.domain.model.UserPreferences
import kotlinx.coroutines.flow.Flow

interface UserPreferencesRepository {

    val userPreferencesFlow: Flow<UserPreferences>

    suspend fun setDarkMode(darkMode: Boolean)

    suspend fun setDynamicColor(dynamicColor: Boolean)

    suspend fun setOnboardingCompleted(onboardingCompleted: Boolean)
}