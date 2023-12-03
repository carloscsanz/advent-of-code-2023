package com.carloscsanz.utils

import java.io.InputStream

object ResourceFile {
    fun read(path: String): InputStream =
        object {}.javaClass.getResourceAsStream(path)
            ?: throw IllegalArgumentException("Resource file $path not found")
}