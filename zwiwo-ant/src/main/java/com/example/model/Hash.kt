package com.example.model

import javax.xml.bind.annotation.*

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
data class Hash(
        @XmlAttribute(name = "type") var type: String = "MD5",
        var value: String? = null
)
