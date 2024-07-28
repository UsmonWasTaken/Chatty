package app.chatty.android

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.chatty.core.domain.repository.ThemePreferencesRepository
import app.chatty.core.domain.repository.UserPreferencesRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn

internal class MainViewModel(
    themePreferencesRepository: ThemePreferencesRepository,
    userPreferencesRepository: UserPreferencesRepository,
) : ViewModel() {

    val themePreferencesFlow = themePreferencesRepository.themePreferencesFlow
        .stateIn(viewModelScope, SharingStarted.Eagerly, null)

    val userPreferencesFlow = userPreferencesRepository.userPreferencesFlow
        .stateIn(viewModelScope, SharingStarted.Eagerly, null)

    fun shouldKeepSplashScreen(): Boolean {
        return themePreferencesFlow.value == null || userPreferencesFlow.value == null
    }
}