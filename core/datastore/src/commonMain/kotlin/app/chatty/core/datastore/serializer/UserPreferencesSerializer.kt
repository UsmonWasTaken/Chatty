package app.chatty.core.datastore.serializer

import androidx.datastore.core.Serializer
import app.chatty.core.domain.model.UserPreferences
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromStream
import kotlinx.serialization.json.encodeToStream
import java.io.InputStream
import java.io.OutputStream

internal object UserPreferencesSerializer : Serializer<UserPreferences> {

    override val defaultValue: UserPreferences
        get() = UserPreferences.getDefaultInstance()

    override suspend fun readFrom(input: InputStream): UserPreferences {
        return Json.decodeFromStream(
            deserializer = UserPreferences.serializer(),
            stream = input
        )
    }

    override suspend fun writeTo(t: UserPreferences, output: OutputStream) {
        return Json.encodeToStream(
            serializer = UserPreferences.serializer(),
            value = t,
            stream = output
        )
    }
}
