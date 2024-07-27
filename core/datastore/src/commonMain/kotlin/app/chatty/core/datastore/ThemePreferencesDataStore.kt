package app.chatty.core.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.core.DataStoreFactory
import androidx.datastore.core.FileStorage
import app.chatty.core.common.platform.BaseSystemDirectories
import app.chatty.core.datastore.serializer.ThemePreferencesSerializer
import app.chatty.core.domain.model.ThemePreferences
import java.io.File

// TODO: Consider creating a dedicated UserPreferencesDataStore class for better abstraction
//  and potential future extensions (e.g., access control).
typealias ThemePreferencesDataStore = DataStore<ThemePreferences>

internal fun ThemePreferencesDataStore(
    systemDirectories: BaseSystemDirectories,
): ThemePreferencesDataStore {
    val themePreferencesStorage = FileStorage(
        serializer = ThemePreferencesSerializer,
        produceFile = {
            File(systemDirectories.configDir, "theme-preferences.json")
        }
    )
    return DataStoreFactory.create(
        storage = themePreferencesStorage,
    )
}

