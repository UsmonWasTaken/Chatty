package app.chatty.core.data.repository

import app.chatty.core.datastore.UserPreferencesDataStore
import app.chatty.core.domain.model.UserPreferences
import app.chatty.core.domain.repository.UserPreferencesRepository
import kotlinx.coroutines.flow.Flow

internal class DefaultUserPreferencesRepository(
    private val preferencesDataStore: UserPreferencesDataStore,
) : UserPreferencesRepository {

    override val userPreferencesFlow: Flow<UserPreferences> = preferencesDataStore.data

    override suspend fun setOnboardingCompleted(onboardingCompleted: Boolean) {
        preferencesDataStore.updateData { it.copy(onboardingCompleted = onboardingCompleted) }
    }
}