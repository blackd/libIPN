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
import net.minecraftforge.gradle.common.util.RunConfig
import net.minecraftforge.gradle.userdev.DependencyManagementExtension
import net.minecraftforge.gradle.userdev.UserDevExtension
import org.anti_ad.mc.libipn.buildsrc.configureCommonLib
import org.anti_ad.mc.libipn.buildsrc.forgeCommonAfterEvaluate
import org.anti_ad.mc.libipn.buildsrc.forgeCommonDependency
import org.anti_ad.mc.libipn.buildsrc.platformsCommonConfig
import org.anti_ad.mc.libipn.buildsrc.registerMinimizeJarTask
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val supported_minecraft_versions = listOf("1.16.2", "1.16.3", "1.16.4", "1.16.5")
val mod_loader = "forge"
val mod_version = project.version
val minecraft_version = "1.16.5"
val minecraft_version_string = "1.16.[2-5]"
val forge_version = "36.2.39"
val mod_artefact_version = project.ext["mod_artefact_version"]
val kotlin_for_forge_version = "1.17.0"
val mappingsMap = mapOf("channel" to "snapshot",
                        "version" to "20210309-1.16.5")


logger.lifecycle("""
    ***************************************************
    Processing "${project.path}"
    supported versions: $supported_minecraft_versions
    loader: $mod_loader
    mod version: $mod_version
    building against MC: $minecraft_version
    ***************************************************
    """.trimIndent())

buildscript {
    repositories {
        maven { url = uri("https://maven.minecraftforge.net/maven") }
        mavenCentral()

        //this is where out custom version of org.spongepowered.mixingradle is
        //I hope I'll be able to remove it soon
        maven {
            setUrl("../../temp/mixingradle-repo")
        }

        maven { url = uri("https://repo.spongepowered.org/repository/maven-public/") }
    }
    dependencies {
        classpath(group = "net.minecraftforge.gradle", name = "ForgeGradle", version = "5.+")
        //classpath(group = "org.spongepowered", name = "mixingradle", version = "0.8.1-SNAPSHOT" )
        classpath("com.guardsquare:proguard-gradle:7.2.2")
    }
}


/*
configurations.all {
    resolutionStrategy.cacheDynamicVersionsFor(30, "seconds")
}

 */

//apply(from = "https://raw.githubusercontent.com/SizableShrimp/Forge-Class-Remapper/main/classremapper.gradle")

//I have no idea why but these MUST be here and not in plugins {}...
apply(plugin = "net.minecraftforge.gradle")
//apply(plugin = "org.spongepowered.mixin")



plugins {
    kotlin("jvm")
    kotlin("plugin.serialization")
    java
    idea
    `maven-publish`
    signing
    id("com.matthewprenger.cursegradle")
    id("com.modrinth.minotaur")
    id("com.github.johnrengelman.shadow")
}

configureCommonLib(true)
platformsCommonConfig()


java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    languageVersion = "1.6"
    jvmTarget = "1.8"
}


group = "org.anti-ad.mc"

repositories {
    maven { url = uri("https://maven.minecraftforge.net/maven") }
    mavenCentral()
    maven { url = uri("https://repo.spongepowered.org/repository/maven-public/") }

    maven {
        url = uri("https://www.cursemaven.com")
        content {
            includeGroup ("curse.maven")
        }
    }
    gradlePluginPortal()
    maven {
        name = "kotlinforforge"
        url = uri("https://thedarkcolour.github.io/KotlinForForge/")
    }
}

val fg: DependencyManagementExtension = project.extensions["fg"] as DependencyManagementExtension

forgeCommonDependency(minecraft_version, forge_version, kotlin_for_forge_version)

dependencies {

}

afterEvaluate {
    project.sourceSets.getByName("main") {
        this.java.srcDirs("./src/shared/java")
        this.java.srcDirs("./src/shared/kotlin")
        resources.srcDirs("src/shared/resources")
    }
}

if ("true" == System.getProperty("idea.sync.active")) {
    afterEvaluate {
        tasks.withType<JavaCompile>().all {
            options.annotationProcessorPath = files()
        }
    }
}
registerMinimizeJarTask()

afterEvaluate {
    forgeCommonAfterEvaluate(mod_loader, minecraft_version, mod_artefact_version?.toString().orEmpty())
}

configure<UserDevExtension> {
    mappings(mappingsMap)
    runs {
        val runConfig = Action<RunConfig> {
            properties(mapOf(
                    //"forge.logging.markers" to "SCAN,REGISTRIES,REGISTRYDUMP",
                    "forge.logging.console.level" to "debug",
                    "mixin.env.remapRefMap" to "true",
                    "mixin.env.refMapRemappingFile" to "${projectDir}/build/createSrgToMcp/output.srg",
                    "mixin.debug.verbose" to "true",
                    "mixin.debug.export" to "true",
                    "mixin.debug.dumpTargetOnFailure" to "true"
            ))
            //arg("-mixin.config=mixins.ipnext.json")
            args("--width=1280", "--height=720", "--username=DEV")
            workingDirectory = project.file("run").canonicalPath
            source(sourceSets["main"])

            if (JavaVersion.current() >= JavaVersion.VERSION_11) {
                jvmArg("--add-exports=java.base/sun.security.util=ALL-UNNAMED")
                jvmArg("--add-opens=java.base/java.util.jar=ALL-UNNAMED")
            }
            this.forceExit = false
        }
        create("client", runConfig)
        create("server", runConfig)
        //create("data", runConfig)
    }
}


afterEvaluate {
    tasks.forEach {
        logger.info("*******************8found task: {} {} {}", it, it.name, it.group)
    }

    tasks.getByName("publishMavenPublicationToIpnOfficialRepoRepository").dependsOn("minimizeJar")
}

val deobfJar = tasks.register<Jar>("deobfJar") {
    from(sourceSets["main"].output)
    archiveBaseName.set("${rootProject.name}-${project.name}")
    //archiveClassifier.set("dev")
    group = "forge"
}

val deobfElements = configurations.register("deobfElements") {
    isVisible = false
    description = "De-obfuscated elements for libs"
    isCanBeResolved = false
    isCanBeConsumed = true
    attributes {
        attribute(Usage.USAGE_ATTRIBUTE, project.objects.named(Usage.JAVA_API))
        attribute(Category.CATEGORY_ATTRIBUTE, project.objects.named(Category.LIBRARY))
        attribute(Bundling.BUNDLING_ATTRIBUTE, project.objects.named(Bundling.EXTERNAL))
        attribute(LibraryElements.LIBRARY_ELEMENTS_ATTRIBUTE, project.objects.named(LibraryElements.JAR))
        attribute(TargetJvmVersion.TARGET_JVM_VERSION_ATTRIBUTE, 8)
    }
    outgoing.artifact(tasks.named("deobfJar"))
}

val javaComponent = components["java"] as AdhocComponentWithVariants
javaComponent.addVariantsFromConfiguration(deobfElements.get()) {
    mapToMavenScope("runtime")
}

val sourceJar = tasks.create<Jar>("sourcesJar") {
    from(sourceSets["main"]?.allSource)
    archiveClassifier.set("sources")
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
            artifact(deobfJar)
            artifact(sourceJar) {
                classifier = "sources"
            }
        }
    }

}

configure<CurseExtension> {

    if (System.getenv("CURSEFORGE_DEPOY_TOKEN") != null && System.getenv("IPNEXT_RELEASE") != null) {
        apiKey = System.getenv("CURSEFORGE_DEPOY_TOKEN")
    }

    val clasifier = if (System.getenv("IPN_CLASSIFIER") != null) {
        System.getenv("IPN_CLASSIFIER")
    } else {
        ""
    }

    project(closureOf<CurseProject> {
        id = "679177"
        changelogType = "markdown"
        changelog = file("../../description/out/pandoc-release_notes.md")
        releaseType = "beta"
        supported_minecraft_versions.forEach {
            if (!it.toLowerCase().contains("pre") && !it.toLowerCase().contains("shanpshot")) {
                this.addGameVersion(it)
            }
        }
        val forgeReobfJar = tasks.named<Jar>("deobfJar").get()
        val remappedJarFile = forgeReobfJar.archiveFile.get().asFile
        mainArtifact(remappedJarFile, closureOf<com.matthewprenger.cursegradle.CurseArtifact> {
            displayName = "libIPN-$mod_loader-$minecraft_version_string-$mod_version$clasifier"
        })

        afterEvaluate {
            uploadTask.dependsOn("build")
        }
        relations(closureOf<com.matthewprenger.cursegradle.CurseRelation> {
            requiredDependency("kotlin-for-forge")
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

    val clasifier = if (System.getenv("IPN_CLASSIFIER") != null) {
        System.getenv("IPN_CLASSIFIER")
    } else {
        ""
    }

    projectId.set("onSQdWhM")
    versionNumber.set("$mod_loader-$minecraft_version-$mod_version$clasifier") // Will fail if Modrinth has this version already
    val forgeReobfJar = tasks.named<Jar>("deobfJar").get()
    val remappedJarFile = forgeReobfJar.archiveFile
    uploadFile.set(remappedJarFile as Any) // This is the java jar task. If it can't find the jar, try 'jar.outputs.getFiles().asPath' in place of 'jar'
    gameVersions.addAll(supported_minecraft_versions)
    logger.lifecycle("""
        +*************************************************+
        Will release ${remappedJarFile.get().asFile.path}
        +*************************************************+
    """.trimIndent())
    versionName.set("libIPN $mod_version for $mod_loader$clasifier $minecraft_version_string")
    this.changelog.set(project.rootDir.resolve("description/out/pandoc-release_notes.md").readText())
    loaders.add(mod_loader)
    dependencies.set(
        mutableListOf(
            ModDependency("ordsPcFz", "required")))
}
