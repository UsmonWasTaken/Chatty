package app.chatty.core.data.repository

import app.chatty.core.datastore.UserPreferencesDataStore
import app.chatty.core.domain.model.DarkModePreference
import app.chatty.core.domain.model.UserPreferences
import app.chatty.core.domain.repository.UserPreferencesRepository
import kotlinx.coroutines.flow.Flow

internal class DefaultUserPreferencesRepository(
    private val userPreferencesDataStore: UserPreferencesDataStore,
) : UserPreferencesRepository {

    override val userPreferencesFlow: Flow<UserPreferences> = userPreferencesDataStore.data

    override suspend fun setDarkMode(darkMode: DarkModePreference) {
        userPreferencesDataStore.updateData { it.copy(darkMode = darkMode) }
    }

    override suspend fun setDynamicColor(dynamicColor: Boolean) {
        userPreferencesDataStore.updateData { it.copy(dynamicColor = dynamicColor) }
    }

    override suspend fun setOnboardingCompleted(onboardingCompleted: Boolean) {
        userPreferencesDataStore.updateData { it.copy(onboardingCompleted = onboardingCompleted) }
    }
}