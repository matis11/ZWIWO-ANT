package com.example

import javax.xml.bind.JAXBContext
import javax.xml.bind.JAXBException
import javax.xml.bind.Marshaller
import java.io.File

class XMLWriter {

    @Throws(JAXBException::class)
    fun write(`object`: Any, file: String) {
        val context = JAXBContext.newInstance(`object`.javaClass)
        val m = context.createMarshaller()
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true)
        m.marshal(`object`, System.out)
        m.marshal(`object`, File(file))
    }

}
