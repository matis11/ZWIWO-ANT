package com.example.model

import javax.xml.bind.annotation.XmlRootElement

@XmlRootElement(name = "file")
data class FileInfo(
        var name: String? = null,
        var url: String? = null,
        var hash: Hash = Hash(),
        var size: Long = 0
)
