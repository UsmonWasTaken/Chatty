package app.chatty.core.domain.repository

import app.chatty.core.domain.model.DarkModePreference
import app.chatty.core.domain.model.ThemePreferences
import kotlinx.coroutines.flow.Flow

interface ThemePreferencesRepository {

    val themePreferencesFlow: Flow<ThemePreferences>

    suspend fun setDarkMode(darkMode: DarkModePreference)

    suspend fun setDynamicColor(dynamicColor: Boolean)
}
