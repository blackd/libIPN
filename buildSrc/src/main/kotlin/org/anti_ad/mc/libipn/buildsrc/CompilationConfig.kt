/*
 * Inventory Profiles Next
 *
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

package org.anti_ad.mc.libipn.buildsrc

import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.api.plugins.ExtraPropertiesExtension
import org.gradle.api.plugins.JavaPluginExtension
import org.gradle.api.tasks.bundling.Jar
import org.gradle.api.tasks.compile.JavaCompile
import org.gradle.kotlin.dsl.*

import org.gradle.language.jvm.tasks.ProcessResources


private val Project.modId: String
    get() = name.lowercase().replace(" ", "-")

private val Project.modLoader: String
    get() {
        return when {
            name.contains("fabric")   -> "fabric"
            name.contains("neoforge") -> "neoforge"
            name.contains("forge")    -> "forge"
            else                              -> {
                throw RuntimeException("Project name: $name doesn't contain supported modloader")
            }
        }
    }

private val Project.ipnDependencyLine: String
    get() {
        val ext = (extensions["ext"] as ExtraPropertiesExtension)
        return if (ext.properties.contains("IPN_version")) {
            if (modLoader == "fabric") {
                "\"inventoryprofilesnext\": \">=${ext["IPN_version"]}\","
            } else {
                """
                    [[dependencies.${project.modId}]]
                    modId="inventoryprofilesnext"
                    mandatory=true
                    versionRange="[${ext["IPN_version"]},)"
                    ordering="NONE"
                    side="CLIENT"
                """.trimIndent()
            }
        } else {
            ""
        }
    }

fun Project.createModInfoGeneratorTask(packageName: String): ModInfoGeneratorTask {
    return project.tasks.create<ModInfoGeneratorTask>("generateModInfo") {
        this.group = "libIPN"
        this.description = "generate ModInfo.kt"
        this.modVersion = project.version.toString()
        this.modId = rootProject.modId
        this.modLoader = project.modLoader
        this.modName = properties["mod.displayName"].toString()
        this.packageName = packageName
        project.tasks.getByName("classes").dependsOn(this)
    }
}

fun Project.configureCompilation(javaVersion: JavaVersion = JavaVersion.VERSION_21, jarBaseName: String) {
    apply(plugin = "maven-publish")
    apply(plugin = "idea")

    configure<JavaPluginExtension> {
        sourceCompatibility = javaVersion
        targetCompatibility = javaVersion
    }

    tasks.withType<JavaCompile> {
        options.encoding = "UTF-8"
        doFirst {
            options.compilerArgs.add("-Xlint:all")
        }
    }



    tasks.withType<ProcessResources> {
        include("**/*")
        val ext = (project.extensions["ext"] as ExtraPropertiesExtension)
        val mc_ver = if (project.path.contains("fabric")) {
            if (ext.properties.get("mc_ver").toString().isNotBlank()) {
                ">=" + ext.properties.get("mc_ver")
            } else {
                ""
            }
        } else {
            if (ext.properties.get("mc_ver").toString().isNotBlank()) {
                "[${ext.properties.get("mc_ver")}, "
            } else {
                ""
            }
        }
        val mc_ver_max = if (project.path.contains("fabric")) {
            if (ext.properties.get("mc_ver_max").toString().isNotBlank()) {
                " <" + ext.properties.get("mc_ver_max")
            } else {
                ""
            }
        } else {
            if (ext.properties.get("mc_ver_max").toString().isNotBlank()) {
                "${ext.properties.get("mc_ver_max")})"
            } else {
                ""
            }
        }
        val tokens = mutableMapOf("VERSION" to version.toString(),
                                  "DESCRIPTION" to properties["mod.description"],
                                  "WIKI" to properties["mod.docs"],
                                  "SOURCE" to properties["mod.scm"],
                                  "ISSUES" to properties["mod.tracker"],
                                  "LICENSE" to properties["mod.license"],
                                  "LIBIPN_VERSION" to (ext.properties["libIPN_version"] ?: ""),
                                  "LIBIPN_VERSION_MAX" to (ext.properties["libIPN_version_max"] ?: ""),
                                  "MC_VER" to mc_ver,
                                  "MC_VER_MAX" to mc_ver_max,
                                  "FABRIC_LOADER" to (ext.properties.get("fabric_loader") ?: ""),
                                  "FABRIC_LANGUAGE_KOTLIN" to (ext.properties.get("fabric_language_kotlin") ?: ""),
                                  "KFF_LOADER_VER" to (ext.properties.get("kff_ver") ?: ""),
                                  "CONTRIBUTORS" to properties["mod.contributors"],
                                  "CONTRIBUTORS_FORGE" to properties["mod.contributors.forge"],
                                  "FORGE_VER" to (ext.properties.get("forge_ver") ?: ""),
                                  "FORGE_VER_MAX" to (ext.properties.get("forge_ver_max") ?: ""),
                                  "MODID" to rootProject.modId,
                                  "DISPLAY_NAME" to (properties["mod.displayName"]),
                                  "IPN_VERSION" to (ext.properties.get("IPN_version") ?: ""),
                                  "IPN_DEPENDENCY_LINE" to project.ipnDependencyLine)
        filesMatching(listOf("**/*.json", "**/*.txt", "**/*.toml", "**/*.xml")) {
            filter<org.apache.tools.ant.filters.ReplaceTokens>("tokens" to tokens)
        }
    }

    tasks.withType<Jar> {
        archiveBaseName.set("$jarBaseName-${archiveBaseName.get()}")
        from("../LICENSE", "../../LICENSE")
    }
}
