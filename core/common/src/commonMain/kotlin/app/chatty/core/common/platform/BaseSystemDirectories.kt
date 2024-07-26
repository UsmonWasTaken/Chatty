package app.chatty.core.common.platform

import java.io.File

interface BaseSystemDirectories {
    val configDir: File
    val dataDir: File
    val cacheDir: File
}