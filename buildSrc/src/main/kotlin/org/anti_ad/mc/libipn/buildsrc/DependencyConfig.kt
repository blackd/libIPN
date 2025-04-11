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

import org.gradle.api.Project
import org.gradle.kotlin.dsl.*
import org.gradle.kotlin.dsl.dependencies

//var shadedApi: Configuration? = null

fun Project.configureDependencies() {
    apply(plugin = "kotlin")
    apply(plugin = "java")
    apply(plugin = "java-library")



    configurations {
        val shaded = create("shaded")
        val shadedApi = create("shadedApi")
        shaded.extendsFrom(shadedApi)
        getByName("api").extendsFrom(shadedApi)
        val shadedImplementation = create("shadedImplementation")
        shaded.extendsFrom(shadedImplementation)
        getByName("implementation").extendsFrom(shadedImplementation)
    }

    repositories {
        gradlePluginPortal()
        mavenCentral()
        maven {
            name = "libIPN-Snapshots"
            this.mavenContent {
                this.snapshotsOnly()
            }
            url = project.uri("https://maven.ipn-mod.org/snapshots")
        }
        maven {
            name = "libIPN-Releases"
            this.mavenContent {
                this.releasesOnly()
            }
            url = uri("https://maven.ipn-mod.org/releases")
        }
        maven { url = uri("https://repo.spongepowered.org/repository/maven-public/") }
        maven { url = uri("https://maven.minecraftforge.net/maven") }
        maven { url = uri("https://maven.enginehub.org/repo/") }
        maven { url = uri("https://repo.codemc.org/repository/maven-public") }
        //maven { url = uri("https://papermc.io/repo/repository/maven-public/") }
        //maven("https://raw.githubusercontent.com/TerraformersMC/Archive/main/releases")
        maven { url = uri("https://maven.terraformersmc.com/releases") }
        maven { url = uri("https://hub.spigotmc.org/nexus/content/repositories/snapshots/") }
        maven { url = uri("https://hub.spigotmc.org/nexus/content/repositories/releases/") }
        maven { url = uri("https://maven.fabricmc.net/") }
        maven { url = uri("https://maven.shedaniel.me") }
        maven {
            url = uri("https://www.cursemaven.com")
            content {
                includeGroup ("curse.maven")
            }
        }
        maven {
            name = "kotlinforforge"
            url = uri("https://thedarkcolour.github.io/KotlinForForge/")
        }
    }

    dependencies {
        //"api"("org.jetbrains:annotations:20.1.0")

        "shadedApi"("com.yevdo:jwildcard:1.4")
        "shadedApi"("ca.solo-studios:kt-fuzzy-jvm:0.1.0") {
            exclude("org.jetbrains.kotlin")
        }
        "shadedApi"("com.yevdo:jwildcard:1.4")
    }
}

fun Project.fabricCommonDependency(minecraft_version: Any,
                                   mappings_version: Any,
                                   loader_version: Any,
                                   fabric_api_version: Any,
                                   modmenu_version: Any? = null) {


    configurations.all {
        resolutionStrategy {
            force("net.fabricmc:fabric-loader:$loader_version")
        }
    }

    dependencies {

        "api"(kotlin("stdlib"))
        "api"(kotlin("reflect"))
        "implementation"("org.jetbrains.kotlinx:kotlinx-serialization-json:1.7.0")
        "implementation"("org.jetbrains.kotlinx:kotlinx-serialization-core:1.7.0")

        "minecraft"("com.mojang:minecraft:$minecraft_version")
        "mappings"("net.fabricmc:yarn:$mappings_version:v2")

        "modImplementation"("net.fabricmc:fabric-loader:$loader_version")
        "modImplementation"("net.fabricmc.fabric-api:fabric-api:$fabric_api_version")

        modmenu_version?.let {
            "modApi"("com.terraformersmc:modmenu:$modmenu_version")
        }

        "modRuntimeOnly"("net.fabricmc:fabric-language-kotlin:1.13.0+kotlin.2.1.0")
    }
}

fun Project.forgeCommonDependency(minecraft_version: Any,
                                  loader_version: Any,
                                  kotlin_for_forge_version: Any) {
    dependencies {

        val kffverstr = kotlin_for_forge_version.toString()[0]

        /*"implementation"("thedarkcolour:kotlinforforge:$kotlin_for_forge_version")*/

        "implementation"("org.joml:joml:1.10.5") {
            version {
                strictly("1.10.5")
            }
        }

        "implementation"("thedarkcolour:kotlinforforge:$kotlin_for_forge_version") {
            this.isChanging = true
            exclude("cpw.mods")
        }

        "runtimeOnly"("ca.solo-studios:kt-fuzzy-jvm:0.1.0") {
            exclude("org.jetbrains.kotlin")
        }


        "implementation"("net.sf.jopt-simple:jopt-simple:5.0.4") {
            version {
                strictly("5.0.4")
            }
        }
        "compileOnly"("org.jetbrains.kotlinx:kotlinx-serialization-json:1.7.0") {
            exclude("org.jetbrains.kotlin")
        }
        "minecraft"("net.minecraftforge:forge:$minecraft_version-$loader_version")
    }
}

fun Project.neoForgeCommonDependency(minecraft_version: Any,
                                     loader_version: Any,
                                     kotlin_for_forge_version: Any) {
    dependencies {

        "implementation"("net.neoforged:neoforge:${loader_version}")
        "implementation"("thedarkcolour:kotlinforforge-neoforge:$kotlin_for_forge_version")
        "runtimeOnly"("com.yevdo:jwildcard:1.4")
        "runtimeOnly"("ca.solo-studios:kt-fuzzy-jvm:0.1.0") {
            exclude("org.jetbrains.kotlin")
        }

/*
        "implementation"("thedarkcolour:kfflang:$kotlin_for_forge_version") {
            isChanging = true
        }
        "implementation"("thedarkcolour:kfflib:$kotlin_for_forge_version") {
            isChanging =  true
        }
        "implementation"("thedarkcolour:kffmod:$kotlin_for_forge_version") {
            isChanging = true
        }
*/

        "compileOnly"("org.jetbrains.kotlinx:kotlinx-serialization-json-jvm:1.7.1") {
            //exclude("org.jetbrains.kotlin")
        }
        "compileOnly"("org.jetbrains.kotlinx:kotlinx-serialization-core-jvm:1.7.1")

    }
}
