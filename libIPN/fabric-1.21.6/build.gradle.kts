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
import org.anti_ad.mc.libipn.buildsrc.Loaders.*
import org.anti_ad.mc.libipn.buildsrc.*


val supported_minecraft_versions = mapOf(MODRINTH to listOf("1.21.6-pre3"),
                                         CURSEFORGE to listOf("1.21.6-snapshot"))
val mod_loader = "fabric"
val mod_version = project.version.toString()
val minecraft_version = "1.21.6-pre3"
val minecraft_version_string = "1.21.6"
val mappings_version = "1.21.6-pre3+build.1"
val loader_version = "0.16.14"
val modmenu_version = "14.0.0-beta.2"
val fabric_api_version = "0.126.0+1.21.6"
val mod_artefact_version = project.ext["mod_artefact_version"]

buildscript {
    dependencies {
        classpath("com.guardsquare:proguard-gradle:7.+")
    }
}

logger.lifecycle("""
    ***************************************************
    Processing "${project.path}"
    supported versions: $supported_minecraft_versions
    loader: $mod_loader
    mod version: $mod_version
    building against MC: $minecraft_version
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
    id("io.github.goooler.shadow")
    java
    idea
}

configureCommon(JavaVersion.VERSION_21)
platformsCommonConfig()

val genModInfoTask = createModInfoGeneratorTask("org.anti_ad.mc.libipn.gen")

fabricCommonDependency(minecraft_version,
                       mappings_version,
                       loader_version,
                       fabric_api_version,
                       modmenu_version)

loom {
    runConfigs["client"].ideConfigGenerated(true)
    runConfigs["client"].vmArgs.add("-Dfabric-tag-conventions-v1.legacyTagWarning=DEV_VERBOSE")
    runConfigs["client"].property("fabric-tag-conventions-v1.legacyTagWarning","DEV_VERBOSE")
    runConfigs["client"].property("fabric-tag-conventions-v2.missingTagTranslationWarning","DEV_VERBOSE")
    runConfigs["client"].vmArgs.add("-Dfabric-tag-conventions-v2.missingTagTranslationWarning=VERBOSE")
    runConfigs["client"].programArgs.addAll(listOf<String>("--width=1280",
                                                           "--height=720",
                                                           "--username=DEV"))
    mixin.defaultRefmapName.set("libIPN-refmap.json")
    accessWidenerPath.set {
        project.layout.projectDirectory.file("src/main/resources/ipn.accesswidener").asFile
    }
}


project.sourceSets.getByName("main") {
    this.java.srcDirs("./src/shared/java")
    this.java.srcDirs("./src/shared/kotlin")
    resources.srcDirs("src/shared/resources")
}

val shadowJar = tasks.named<ShadowJar>("shadowJar") {

    configurations = listOf(project.configurations["shaded"])

    archiveClassifier.set("shaded")
    setVersion(project.version)

    exclude("kotlin/**")
    exclude("kotlinx/**")

    exclude("mappings/mappings.tiny") // before kt, build .jar don"t have this folder (this 500K thing)
    exclude("com/ibm/**")
    exclude("org/glassfish/**")
    exclude("org/intellij/**")
    exclude("org/jetbrains/**")
    exclude("org/jline/**")
    exclude("net/minecraftforge/**")
    exclude("io/netty/**")

    exclude("META-INF/maven/**")

    relocate("ca.solostudios", "org.anti_ad.embedded.ca.solostudios")
    relocate("com.yevdo", "org.anti_ad.embedded.com.yevdo")


    minimize()
}.get()

val remapped = tasks.named<RemapJarTask>("remapJar") {
    group = "fabric"
    dependsOn(shadowJar)
    this.inputFile.set(shadowJar.archiveFile)
    archiveFileName.set(shadowJar.archiveFileName.get().replace(Regex("-shaded\\.jar$"), ".jar"))
    addNestedDependencies.set(true)
}

fabricRegisterCommonTasks(mod_loader, minecraft_version, mod_artefact_version?.toString().orEmpty())

val minimizeJar = registerMinimizeJarTask()

afterEvaluate {
    fabricCommonAfterEvaluate(mod_loader, minecraft_version, mod_artefact_version?.toString().orEmpty())
}

tasks.named<DefaultTask>("build") {
    dependsOn(remapped)
    dependsOn("packageSources")
    dependsOn(minimizeJar)
}


val sourceJar = tasks.create<Jar>("sourcesJar") {
    dependsOn(genModInfoTask)
    from(sourceSets["main"]?.allSource)
    exclude("org/anti_ad/mc/common/gen/*.tokens")
}

publishing {
    repositories {
        maven {
            val releasesRepoUrl = "https://maven.ipn-mod.org/releases"
            val snapshotsRepoUrl = "https://maven.ipn-mod.org/snapshots"
            logger.lifecycle("project.ext[\"mod_artefact_is_release\"] = ${project.ext["mod_artefact_is_release"]}")
            name = "ipnOfficialRepo"
            credentials(PasswordCredentials::class)
            authentication {
                create<BasicAuthentication>("basic")
            }
            url = uri(if (project.ext["mod_artefact_is_release"] as Boolean) releasesRepoUrl else snapshotsRepoUrl)
        }
    }
    publications {
        create<MavenPublication>("maven") {
            groupId = "org.anti_ad.mc"
            artifactId = "${rootProject.name}-${project.name}"
            version = project.version.toString()
            artifact(minimizeJar.outputs.files.first())
            artifact(sourceJar) {
                classifier = "sources"
            }
            afterEvaluate {
                artifact(tasks.named<DefaultTask>("makeDevJar")) {
                    classifier = "dev"
                }
            }
            loom {
                this.disableDeprecatedPomGeneration(this@create)
            }
        }
    }
}


// ============
// curseforge
// ============

configure<CurseExtension> {

    if (System.getenv("CURSEFORGE_DEPOY_TOKEN") != null && System.getenv("IPNEXT_RELEASE") != null) {
        apiKey = System.getenv("CURSEFORGE_DEPOY_TOKEN")
    }

    project(closureOf<CurseProject> {
        id = "679177"
        changelogType = "markdown"
        changelog = file("../../description/out/pandoc-release_notes.md")
        releaseType = "release"
        supported_minecraft_versions[CURSEFORGE]!!.forEach  {
            this.addGameVersion(it)
        }
        this.addGameVersion("Fabric")
        this.addGameVersion("Quilt")
        val remappedJarFile = minimizeJar.outputs.files.first()
        logger.lifecycle("""
            +*************************************************+
            Will release ${remappedJarFile.path}
            +*************************************************+
        """.trimIndent())
        mainArtifact(remappedJarFile, closureOf<com.matthewprenger.cursegradle.CurseArtifact> {
            displayName = "libIPN-fabric-$minecraft_version_string-$mod_version"
        })

        relations(closureOf<com.matthewprenger.cursegradle.CurseRelation> {
            requiredDependency("fabric-api")
            requiredDependency("fabric-language-kotlin")
        })
    })
    options(closureOf<com.matthewprenger.cursegradle.Options> {
        debug = false
        javaIntegration = false
        forgeGradleIntegration = mod_loader == "forge"
    })
}
// ============
// modrith
// ============

modrinth {

    this.failSilently.set(true)

    if (System.getenv("IPNEXT_RELEASE") != null) {
        token.set(System.getenv("MODRINTH_TOKEN"))
    }

    projectId.set("onSQdWhM")
    versionNumber.set("$mod_loader-$minecraft_version-$mod_version") // Will fail if Modrinth has this version already
    val remappedJarFile = minimizeJar.outputs.files.first()
    uploadFile.set(remappedJarFile as Any) // This is the java jar task. If it can't find the jar, try 'jar.outputs.getFiles().asPath' in place of 'jar'
    gameVersions.addAll(supported_minecraft_versions[MODRINTH]!!)
    logger.lifecycle("""
        +*************************************************+
        Will release ${remappedJarFile.path}
        +*************************************************+
    """.trimIndent())
    versionName.set("libIPN $mod_version for $mod_loader $minecraft_version_string")
    this.changelog.set(project.rootDir.resolve("description/out/pandoc-release_notes.md").readText())
    loaders.add(mod_loader)
    loaders.add("quilt")
    dependencies.set(
        mutableListOf(
            ModDependency("P7dR8mSH", "required"),
            ModDependency("Ha28R6CL", "required")))

    this.versionType.set(com.modrinth.minotaur.request.VersionType.RELEASE.name)
}
