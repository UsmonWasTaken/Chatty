package app.chatty.core.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.core.DataStoreFactory
import androidx.datastore.core.FileStorage
import app.chatty.core.common.platform.BaseSystemDirectories
import app.chatty.core.datastore.serializer.UserPreferencesSerializer
import app.chatty.core.domain.model.UserPreferences
import java.io.File

// TODO: Consider creating a dedicated UserPreferencesDataStore class for better abstraction
//  and potential future extensions (e.g., access control).
typealias UserPreferencesDataStore = DataStore<UserPreferences>

internal fun UserPreferencesDataStore(
    systemDirectories: BaseSystemDirectories,
): UserPreferencesDataStore {
    val userPreferencesStorage = FileStorage(
        serializer = UserPreferencesSerializer,
        produceFile = {
            File(systemDirectories.configDir, "user-preferences.json")
        }
    )
    return DataStoreFactory.create(
        storage = userPreferencesStorage,
    )
}

