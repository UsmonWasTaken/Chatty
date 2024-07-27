package app.chatty.core.datastore.serializer

import androidx.datastore.core.Serializer
import app.chatty.core.domain.model.ThemePreferences
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromStream
import kotlinx.serialization.json.encodeToStream
import java.io.InputStream
import java.io.OutputStream

internal object ThemePreferencesSerializer : Serializer<ThemePreferences> {

    override val defaultValue: ThemePreferences
        get() = ThemePreferences.getDefaultInstance()

    override suspend fun readFrom(input: InputStream): ThemePreferences {
        return Json.decodeFromStream(
            deserializer = ThemePreferences.serializer(),
            stream = input
        )
    }

    override suspend fun writeTo(t: ThemePreferences, output: OutputStream) {
        return Json.encodeToStream(
            serializer = ThemePreferences.serializer(),
            value = t,
            stream = output
        )
    }
}
