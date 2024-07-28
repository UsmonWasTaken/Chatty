package app.chatty.core.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.core.DataStoreFactory
import androidx.datastore.core.FileStorage
import app.chatty.core.common.platform.BaseSystemDirectories
import app.chatty.core.datastore.serializer.UserPreferencesSerializer
import app.chatty.core.domain.model.UserPreferences
import java.io.File

interface UserPreferencesDataStore : DataStore<UserPreferences>

internal fun UserPreferencesDataStore(
    systemDirectories: BaseSystemDirectories,
): UserPreferencesDataStore {
    val userPreferencesStorage = FileStorage(
        serializer = UserPreferencesSerializer,
        produceFile = {
            File(systemDirectories.configDir, "user-preferences.json")
        }
    )
    val datastore = DataStoreFactory.create(
        storage = userPreferencesStorage,
    )
    return UserPreferencesDataStoreImpl(datastore)
}

@JvmInline
private value class UserPreferencesDataStoreImpl(
    val dataStore: DataStore<UserPreferences>,
) : UserPreferencesDataStore, DataStore<UserPreferences> by dataStore