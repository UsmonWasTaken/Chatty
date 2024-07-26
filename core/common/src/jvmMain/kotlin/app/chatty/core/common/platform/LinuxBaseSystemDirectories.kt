package app.chatty.core.common.platform

import java.io.File

internal class LinuxBaseSystemDirectories : BaseSystemDirectories {

    override val configDir: File
        get() = linuxConfigDir()

    override val dataDir: File
        get() = linuxDataDir()

    override val cacheDir: File
        get() = linuxCacheDir()

    private fun linuxConfigDir(): File {
        val configDirPath = System.getenv("XDG_CONFIG_HOME")?.ifBlank {
            System.getenv("HOME")?.let { "$it/.config" }
        }
        checkNotNull(configDirPath) {
            "This application requires access to your user config directory. Please ensure that either the '\$XDG_CONFIG_HOME' or '\$HOME' environment variable is set in your system configuration."
        }
        val configDir = File(configDirPath)
        check(configDir.canRead() && configDir.canWrite()) {
            "This application requires read and write access to your user config directory. Please ensure that you have correct permissions for the [$configDirPath] directory."
        }
        return File(configDir, "Chatty").also { directory ->
            if (directory.exists()) {
                check(directory.isDirectory) {
                    "The [${directory.path}] is not a directory. Please remove the file or ensure that the [${directory.path}] is a directory."
                }
                check(directory.canRead() && directory.canWrite()) {
                    "This application requires read and write access to the [${directory.path}] directory. Please ensure that you have correct permissions for the [${directory.path}] directory."
                }
            }
            directory.mkdirs()
        }
    }

    private fun linuxDataDir(): File {
        val dataDirPath = System.getenv("XDG_DATA_HOME")?.ifBlank {
            System.getenv("HOME")?.let { "$it/.local/share" }
        }
        checkNotNull(dataDirPath) {
            "This application requires access to your user data directory. Please ensure that either the '\$XDG_DATA_HOME' or '\$HOME' environment variable is set in your system configuration."
        }
        val dataDir = File(dataDirPath)
        check(dataDir.canRead() && dataDir.canWrite()) {
            "This application requires read and write access to your user data directory. Please ensure that you have correct permissions for the [$dataDirPath] directory."
        }
        return File(dataDir, "Chatty").also { directory ->
            if (directory.exists()) {
                check(directory.isDirectory) {
                    "The [${directory.path}] is not a directory. Please remove the file or ensure that the [${directory.path}] is a directory."
                }
                check(directory.canRead() && directory.canWrite()) {
                    "This application requires read and write access to the [${directory.path}] directory. Please ensure that you have correct permissions for the [${directory.path}] directory."
                }
            }
            directory.mkdirs()
        }
    }

    private fun linuxCacheDir(): File {
        val cacheDirPath = System.getenv("XDG_CACHE_HOME")?.ifBlank {
            System.getenv("HOME")?.let { "$it/.cache" }
        }
        checkNotNull(cacheDirPath) {
            "This application requires access to your user cache directory. Please ensure that either the '\$XDG_CACHE_HOME' or '\$HOME' environment variable is set in your system configuration."
        }
        val cacheDir = File(cacheDirPath)
        check(cacheDir.canRead() && cacheDir.canWrite()) {
            "This application requires read and write access to your user cache directory. Please ensure that you have correct permissions for the [$cacheDirPath] directory."
        }
        return File(cacheDir, "Chatty").also { directory ->
            if (directory.exists()) {
                check(directory.isDirectory) {
                    "The [${directory.path}] is not a directory. Please remove the file or ensure that the [${directory.path}] is a directory."
                }
                check(directory.canRead() && directory.canWrite()) {
                    "This application requires read and write access to the [${directory.path}] directory. Please ensure that you have correct permissions for the [${directory.path}] directory."
                }
            }
            directory.mkdirs()
        }
    }
}