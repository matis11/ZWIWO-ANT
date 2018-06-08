package com.example

import org.apache.commons.codec.digest.DigestUtils

import java.io.File
import java.io.FileInputStream

object MD5Util {

    fun calculateHash(input: File): String {
        return try {
            val fileInputStream = FileInputStream(input)
            val hash = DigestUtils.md5Hex(fileInputStream)
            fileInputStream.close()

            hash
        } catch (e: Exception) {
            "ERROR"
        }

    }

}
