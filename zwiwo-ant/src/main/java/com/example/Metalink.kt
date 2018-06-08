package com.example

import com.example.model.FileInfo
import com.example.model.MetalinkFile
import org.apache.tools.ant.BuildException
import org.apache.tools.ant.Task
import org.apache.tools.ant.types.FileSet
import java.io.File
import java.util.*

@Suppress("RedundantVisibilityModifier")
class Metalink : Task() {
    companion object {
        const val SERVER_FILES_URL = "server.files.url"
        const val USER_DIR = "user.dir"
    }

    public lateinit var url: String
    public lateinit var file: String
    public lateinit var userDir: String

    private val files: Vector<FileSet> = Vector()
    private val metalinkFile = MetalinkFile()

    @Throws(BuildException::class)
    override fun execute() {
        super.execute()
        url = getProject().getProperty(SERVER_FILES_URL)
        userDir = getProject().getProperty(USER_DIR)

        files.forEach { file -> if (file is FileSet) scanDir(file.dir) }

        val xmlWriter = XMLWriter()
        try {
            xmlWriter.write(metalinkFile, file)
        } catch (e: Exception) {
            println(e.stackTrace)
            throw BuildException("ERROR")
        }
    }

    private fun scanDir(file: File) {
        if (file.isDirectory) {
            file.listFiles().forEach { nestedFile -> generateMetaInfo(nestedFile) }
        } else {
            generateMetaInfo(file)
        }
    }

    private fun generateMetaInfo(file: File) {
        if (file.isDirectory)
            return

        val info = FileInfo()
        val name = file.path.replace(userDir + "\\", "")
        info.name = name
        info.url = url + name.replace("\\", "/")
        info.hash.value = MD5Util.calculateHash(file)
        info.size = file.length()
        metalinkFile.add(info)
    }

    @Suppress("unused")
    public fun addFileset(fileset: FileSet) {
        files.add(fileset)
    }

}
