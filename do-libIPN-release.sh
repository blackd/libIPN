#!/bin/bash

. ~/.config/secrets/modrinth.sh
. ~/.config/secrets/curseforge.sh

pushd . 

cd $(mktemp -d /tmp/libIPN-release.XXXX)

git clone git@github.com:blackd/libIPN.git libIPN

cd libIPN/description

#python build_html.py
python build_release_notes.py

cd ..

./gradlew --max-workers 4 clean build publishAllPublicationsToMavenRepository #modrinth curseforge


ls -la build/lib/

pwd

popd
