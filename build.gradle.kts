

import java.io.FileInputStream

// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
}



val apikeyPropertiesFile = rootProject.file("apikey.properties")

if (apikeyPropertiesFile.exists()) {
    val apikeyProperties = java.util.Properties().apply {
        load(FileInputStream(apikeyPropertiesFile))
    }
    apikeyProperties.forEach { key, value ->
        project.extensions.extraProperties[key.toString()] = value
    }
}
