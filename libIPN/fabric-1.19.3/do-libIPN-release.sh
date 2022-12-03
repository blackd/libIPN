#!/bin/bash

. ~/.config/secrets/modrinth.sh
. ~/.config/secrets/curseforge.sh



../../gradlew --max-workers 2 clean build publishAllPublicationsToMavenRepository modrinth curseforge
