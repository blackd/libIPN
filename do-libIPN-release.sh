#!/bin/bash

. ~/.config/secrets/modrinth.sh
. ~/.config/secrets/curseforge.sh


pushd .

cd $(mktemp -d /tmp/IPN/libIPN-release.XXXX)

git clone git@gitea.lan:Inventory-Profiles-Next/libIPN.git libIPN

python -m venv ./venv
. ./venv/bin/activate

pip install pandoc
pip install pypandoc
pip install premailer
pip install pandoc_include

cd libIPN/description

python build_release_notes.py

cd ..

./gradlew --max-workers 32 clean compileKotlin compileJava

#./gradlew --max-workers 4 build publishAllPublicationsToIpnOfficialRepoRepository modrinth curseforge
