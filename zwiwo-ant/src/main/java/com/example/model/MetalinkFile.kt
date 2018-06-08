package com.example.model

import java.util.*
import javax.xml.bind.annotation.XmlRootElement

@XmlRootElement(name = "metalink")
data class MetalinkFile(
        var published: Date = Date(),
        var files: MutableList<FileInfo> = ArrayList()
) {
    fun add(fileInfo: FileInfo) {
        files.add(fileInfo)
    }
}
