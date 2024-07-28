package app.chatty.core.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.core.DataStoreFactory
import androidx.datastore.core.FileStorage
import app.chatty.core.common.platform.BaseSystemDirectories
import app.chatty.core.datastore.serializer.ThemePreferencesSerializer
import app.chatty.core.domain.model.ThemePreferences
import java.io.File

interface ThemePreferencesDataStore : DataStore<ThemePreferences>

internal fun ThemePreferencesDataStore(
    systemDirectories: BaseSystemDirectories,
): ThemePreferencesDataStore {
    val themePreferencesStorage = FileStorage(
        serializer = ThemePreferencesSerializer,
        produceFile = {
            File(systemDirectories.configDir, "theme-preferences.json")
        }
    )
    val dataStore = DataStoreFactory.create(
        storage = themePreferencesStorage,
    )
    return ThemePreferencesDataStoreImpl(dataStore)
}

@JvmInline
private value class ThemePreferencesDataStoreImpl(
    val dataStore: DataStore<ThemePreferences>,
) : ThemePreferencesDataStore, DataStore<ThemePreferences> by dataStore