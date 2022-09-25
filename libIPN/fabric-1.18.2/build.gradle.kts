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

import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import com.matthewprenger.cursegradle.CurseExtension
import com.matthewprenger.cursegradle.CurseProject
import com.modrinth.minotaur.dependencies.ModDependency
import net.fabricmc.loom.task.RemapJarTask
import org.anti_ad.mc.libipn.buildsrc.configureCommonLib
import org.anti_ad.mc.libipn.buildsrc.fabricCommonAfterEvaluate
import org.anti_ad.mc.libipn.buildsrc.fabricCommonDependency
import org.anti_ad.mc.libipn.buildsrc.fabricRegisterCommonTasks
import org.anti_ad.mc.libipn.buildsrc.platformsCommonConfig
import org.anti_ad.mc.libipn.buildsrc.registerMinimizeJarTask
import org.anti_ad.mc.libipn.buildsrc.loom_version

val supported_minecraft_versions = listOf("1.18.2")
val mod_loader = "fabric"
val mod_version = project.version.toString()
val minecraft_version = "1.18.2"
val minecraft_version_string = "1.18.2"
val mappings_version = "1.18.2+build.4"
val loader_version = "0.14.8"
val modmenu_version = "3.0.1"
val fabric_api_version = "0.58.0+1.18.2"
val mod_artefact_version = project.ext["mod_artefact_version"]

buildscript {
    dependencies {
        classpath("com.guardsquare:proguard-gradle:7.2.1")
    }
}

logger.lifecycle("""
    ***************************************************
    Processing "${project.path}"
    supported versions: $supported_minecraft_versions
    loader: $mod_loader
    mod version: $mod_version
    building against MC: $minecraft_version
    loom version: $loom_version
    fabric api version: $fabric_api_version
    ***************************************************
    """.trimIndent())


plugins {
    kotlin("jvm")
    kotlin("plugin.serialization")
    `java-library`
    `maven-publish`
    signing
    id("fabric-loom")
    id("com.matthewprenger.cursegradle")
    id("com.modrinth.minotaur")
    id("com.github.johnrengelman.shadow")
}

configureCommonLib(true)
platformsCommonConfig()

group = "org.anti-ad.mc"

configure<JavaPluginExtension> {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

val compileKotlin: org.jetbrains.kotlin.gradle.tasks.KotlinCompile by tasks
compileKotlin.kotlinOptions {
    languageVersion = "1.5"
    jvmTarget = "17"
    freeCompilerArgs = freeCompilerArgs + listOf("-opt-in=kotlin.RequiresOptIn")
}

repositories {
    maven {
        url = uri("https://www.cursemaven.com")
        content {
            includeGroup ("curse.maven")
        }
    }
}

fabricCommonDependency(minecraft_version,
                       mappings_version,
                       loader_version,
                       fabric_api_version,
                       modmenu_version)
dependencies {

    "implementation"("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.2")
    "compileOnlyApi"(group = "org.apache.logging.log4j",
                     name = "log4j-api",
                     version = "2.18.0")
    "compileOnlyApi"(group = "org.lwjgl",
                     name = "lwjgl-glfw",
                     version = "3.3.1")
}

apply(plugin = "kotlinx-serialization")


loom {
    runConfigs["client"].programArgs.addAll(listOf<String>("--width=1280", "--height=720", "--username=DEV"))
    mixin.defaultRefmapName.set("libIPN-refmap.json")

}

afterEvaluate {
    project.sourceSets.getByName("main") {
        this.java.srcDirs("./src/shared/java")
        this.java.srcDirs("./src/shared/kotlin")
        //this.antlr.srcDirs(project.layout.projectDirectory.dir("src/shared/antlr"))
    }
}

tasks.named<ShadowJar>("shadowJar") {

    configurations = listOf(project.configurations["shaded"])

    archiveClassifier.set("shaded")
    setVersion(project.version)

    exclude("kotlin/**")
    exclude("kotlinx/**")

    //exclude("META-INF/**")
    //exclude("**/*.kotlin_metadata")
    //exclude("**/*.kotlin_module")
    //exclude("**/*.kotlin_builtins")
    //exclude("**/*_ws.class") // fixme find a better solution for removing *.ws.kts
    //exclude("**/*_ws$*.class")
    //exclude("**/*.stg")
    //exclude("**/*.st")
    exclude("mappings/mappings.tiny") // before kt, build .jar don"t have this folder (this 500K thing)
    exclude("com/ibm/**")
    exclude("org/glassfish/**")
    exclude("org/intellij/**")
    exclude("org/jetbrains/**")
    exclude("org/jline/**")
    exclude("net/minecraftforge/**")
    exclude("io/netty/**")
    //exclude("mappings/mappings.tiny") // before kt, build .jar don"t have this folder (this 500K thing)
    exclude("META-INF/maven/**")
    //exclude("META-INF/LICENSE")
    //exclude("META-INF/README")

    minimize()
}

val remapped = tasks.named<RemapJarTask>("remapJar") {
    group = "fabric"
    val shadowJar = tasks.getByName<ShadowJar>("shadowJar")
    dependsOn(shadowJar)
    //dependsOn("prepareRemapShadedJar")
    this.inputFile.set(shadowJar.archiveFile)
    archiveFileName.set(shadowJar.archiveFileName.get().replace(Regex("-shaded\\.jar$"), ".jar"))
    addNestedDependencies.set(true)
    //addDefaultNestedDependencies.set(false)
    //remapAccessWidener.set(true)
}

fabricRegisterCommonTasks(mod_loader, minecraft_version, mod_artefact_version?.toString().orEmpty())

registerMinimizeJarTask()

afterEvaluate {
    fabricCommonAfterEvaluate(mod_loader, minecraft_version, mod_artefact_version?.toString().orEmpty())
}

tasks.named<DefaultTask>("build") {
    dependsOn(remapped)
    dependsOn("packageSources")
    dependsOn("copyJarForPublish")
//    dependsOn("minimizeJar")
}




// ============
// curseforge
// ============

publishing {
    repositories {
        maven {
            val releasesRepoUrl = rootProject.layout.projectDirectory.dir("repos/releases")
            val snapshotsRepoUrl = rootProject.layout.projectDirectory.dir("repos/snapshots")
            url = uri(if (project.ext["mod_artefact_is_release"] as Boolean) releasesRepoUrl else snapshotsRepoUrl)
        }
    }
    publications {
        create<MavenPublication>("maven") {
            groupId = "org.anti_ad.mc"
            artifactId = "${rootProject.name}-${project.name}"
            version = project.version.toString()
            artifact(remapped)
            loom {
                this.disableDeprecatedPomGeneration(this@create)
            }
        }
    }
}
