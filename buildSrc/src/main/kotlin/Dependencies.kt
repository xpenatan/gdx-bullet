import java.io.File
import java.util.*

object LibExt {
    const val groupId = "com.github.xpenatan.gdx-bullet"
    val libVersion: String = getVersion()

    const val gdxVersion = "1.12.1"
    const val teaVMVersion = "0.9.2"

    const val jParserVersion = "-SNAPSHOT"
    const val gdxTeaVMVersion = "-SNAPSHOT"
}

private fun getVersion(): String {
    val isReleaseStr = System.getenv("RELEASE")
    val isRelease = isReleaseStr != null && isReleaseStr.toBoolean()
    var libVersion = "-SNAPSHOT"
    val file = File("gradle.properties")
    if(file.exists()) {
        val properties = Properties()
        properties.load(file.inputStream())
        val version = properties.getProperty("version")
        if(isRelease) {
            libVersion = version
        }
    }
    else {
        if(isRelease) {
            throw RuntimeException("properties should exist")
        }
    }
    println("Lib Version: $libVersion")
    return libVersion
}