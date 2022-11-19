#!/bin/bash

. ~/.config/secrets/modrinth.sh
. ~/.config/secrets/curseforge.sh



./gradlew --max-workers 32 clean build publishAllPublicationsToMavenRepository #modrinth curseforge
