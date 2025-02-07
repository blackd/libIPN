/*
 * Inventory Profiles Next
 *
 *   Copyright (c) 2019-2020 jsnimda <7615255+jsnimda@users.noreply.github.com>
 *   Copyright (c) 2021-2022 Plamen K. Kosseff <p.kosseff@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

import org.anti_ad.mc.libipn.buildsrc.VersionProperties
import org.anti_ad.mc.libipn.buildsrc.getGitHash
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import java.io.ByteArrayOutputStream

val versionObj = Version("6", "3", "0",
                         preRelease = (System.getenv("IPNEXT_RELEASE") == null))

val loom_version: String by project


repositories {
    google()
    gradlePluginPortal()
    mavenCentral()
    maven(url = "https://maven.fabricmc.net") {
        name = "Fabric"
    }
    maven("https://maven.terraformersmc.com/releases")
    maven ("https://plugins.gradle.org/m2/")


}


plugins {

    `kotlin-dsl`
    kotlin("jvm") version "2.0.21"
    kotlin("plugin.serialization") version "2.0.21"


    idea

    `java-library`
    `maven-publish`
    signing
    id("idea")
    id("io.github.goooler.shadow") version "8+" apply false
    id("io.github.gradle-nexus.publish-plugin") version "1.1.0" apply true
    id("fabric-loom") version "1.9-SNAPSHOT" apply false
    id("com.matthewprenger.cursegradle") version "1.4.+" apply false
    id("com.modrinth.minotaur") version "2.+" apply false
    //id("net.minecraftforge.gradle") version "6.+" apply false
    id("net.neoforged.gradle.userdev") version "7.+" apply false
}





// This is here but it looks like it's not inherited by the child projects
tasks.named<KotlinCompile>("compileKotlin") {
    compilerOptions {
        jvmTarget.set(JvmTarget.JVM_21)
        freeCompilerArgs = listOf("-opt-in=kotlin.ExperimentalStdlibApi")
    }
}

evaluationDependsOnChildren()

allprojects {
    version = versionObj.toString()
    group = "org.anti-ad.mc"
    ext.set("mod_artefact_version", versionObj.toCleanString())
    ext.set("mod_artefact_is_release", versionObj.isRelease())

    tasks.withType<JavaCompile>().configureEach {
        options.isFork = true
        options.isIncremental = true
    }



    tasks.withType<KotlinCompile>().configureEach {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_21)
            languageVersion.set(org.jetbrains.kotlin.gradle.dsl.KotlinVersion.KOTLIN_2_1)
            optIn.add("kotlin.ExperimentalStdlibApi")
            optIn.add("kotlin.RequiresOptIn")
        }
        this.incremental = true
    }
}

tasks.named<Jar>("jar") {
    enabled = false
}


tasks.register<Exec>("owner-testing-env") {
    onlyIf {
        System.getenv("IPNEXT_ITS_ME") != null
    }

    val bos = ByteArrayOutputStream()

    workingDir = layout.projectDirectory.asFile.absoluteFile
    commandLine("${System.getenv("HOME")}/.local/bin/update-ipnext-test-env.sh",
                project.layout.buildDirectory.dir("libs").get().asFile.absolutePath,
                "-$versionObj")
    standardOutput = bos

    logger.lifecycle(bos.toString())

}


tasks.register<Copy>("copyPlatformJars") {
    subprojects.filter {
        val isFabric = it.name.startsWith("fabric")
        val isForge = it.name.startsWith("forge") || it.name.startsWith("neoforge")
        isFabric || isForge
    }.forEach {
        val isForge = !it.name.startsWith("fabric")
        val jarTask = it.tasks.named<DefaultTask>("minimizeJar")
        dependsOn(jarTask)
        if (isForge) {
            val endTask = it.tasks.named("jar")
            dependsOn(endTask)
        }
        val jarFile = jarTask.get()
        val jarPath = jarFile.outputs.files.first()
        logger.debug("""
            *************************
              ${it.path} finalized mod jar is $jarPath
            *************************
        """.trimIndent())
        from(jarPath)
    }

    into(layout.buildDirectory.dir("libs"))

    finalizedBy("owner-testing-env")
}



tasks.named<DefaultTask>("build") {
    dependsOn(tasks["copyPlatformJars"])
}


/**
 * Version class that does version stuff.
 */
@Suppress("MemberVisibilityCanBePrivate")
class Version(val major: String, val minor: String, val revision: String, val preRelease: Boolean = false) {

    val gitHash
        get() = getGitHash()

    override fun toString(): String {
        return if (!preRelease)
            "$major.$minor.$revision"
        else //Only use git hash if it's a prerelease.
            "$major.$minor.$revision-SNAPSHOT"
    }

    fun toCleanString(): String {
        return if (!preRelease)
            "$major.$minor.$revision"
        else //Only use git hash if it's a prerelease.
            "$major.$minor.$revision-SNAPSHOT"
    }

    fun isRelease() = !preRelease
}
