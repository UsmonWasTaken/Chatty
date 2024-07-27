package app.chatty.core.data.repository

import app.chatty.core.datastore.ThemePreferencesDataStore
import app.chatty.core.domain.model.DarkModePreference
import app.chatty.core.domain.model.ThemePreferences
import app.chatty.core.domain.repository.ThemePreferencesRepository
import kotlinx.coroutines.flow.Flow

internal class DefaultThemePreferencesRepository(
    private val preferencesDataStore: ThemePreferencesDataStore,
) : ThemePreferencesRepository {

    override val themePreferencesFlow: Flow<ThemePreferences> = preferencesDataStore.data

    override suspend fun setDarkMode(darkMode: DarkModePreference) {
        preferencesDataStore.updateData { it.copy(darkMode = darkMode) }
    }

    override suspend fun setDynamicColor(dynamicColor: Boolean) {
        preferencesDataStore.updateData { it.copy(dynamicColor = dynamicColor) }
    }
}