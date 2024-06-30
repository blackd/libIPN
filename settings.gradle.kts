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


rootProject.name = "libIPN"

//includeBuild("ipn-project")

/*
include("libIPN:fabric-1.20")
include("libIPN:fabric-1.20.2")
include("libIPN:fabric-1.20.3")
*/
include("libIPN:fabric-1.21")
include("libIPN:forge-1.21")

//includeBuild("libIPN/forge/forge-1.21")

/*
include("libIPN:fabric-1.19")
include("libIPN:fabric-1.18.2")

include("libIPN:forge-1.20")
include("libIPN:forge-1.20.2")

include("libIPN:forge-1.19")
include("libIPN:forge-1.18.2")
*/






pluginManagement {
    repositories {
        maven(url = "https://maven.fabricmc.net") {
            name = "Fabric"
        }
        maven (url = "https://maven.minecraftforge.net/") {
            name = "MinecraftForge"
        }
        mavenCentral()
        google()
        gradlePluginPortal()
    }
}

plugins {
    id("com.gradle.enterprise") version "3.4.1"
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}

gradleEnterprise {
    buildScan {
        termsOfServiceUrl = "https://gradle.com/terms-of-service"
        termsOfServiceAgree = "yes"
    }
}
