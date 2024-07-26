package app.chatty.core.common.platform

import android.content.Context
import java.io.File

internal class AndroidBaseSystemDirectories(
    private val context: Context,
) : BaseSystemDirectories {

    override val configDir: File
        get() = context.getDir("config", Context.MODE_PRIVATE)

    override val dataDir: File
        get() = context.filesDir

    override val cacheDir: File
        get() = context.cacheDir
}