#!/bin/bash

. ~/.config/secrets/modrinth.sh
. ~/.config/secrets/curseforge.sh


pushd .

cd $(mktemp -d /tmp/libIPN-release.XXXX)

git clone git@github.com:blackd/libIPN.git libIPN

cd libIPN/description

python build_release_notes.py

cd ..

./gradlew --max-workers 32 clean compileKotlin compileJava

./gradlew --max-workers 4 build publishAllPublicationsToIpnOfficialRepoRepository modrinth curseforge
