#!/bin/bash

. ~/.config/secrets/modrinth.sh
. ~/.config/secrets/curseforge.sh


pushd .
mkdir /tmp/IPN
cd $(mktemp -d /tmp/IPN/libIPN-release.XXXX)

git clone git@gitea.lan:Inventory-Profiles-Next/libIPN.git libIPN

if [[ ! -e ../venv ]]; then
  python -m venv ../venv
  . ../venv/bin/activate
  pip install pandoc
  pip install pypandoc
  pip install premailer
  pip install pandoc_include
else
  . ../venv/bin/activate
fi

cd libIPN/description

python build_release_notes.py

cd ..

./gradlew --max-workers 32 clean compileKotlin compileJava

GRADLE_ARG="--max-workers 4 build"

if [[ n$IPNEXT_RELEASE != "n" ]]; then
  GRADLE_ARG="$GRADLE_ARG publishAllPublicationsToIpnOfficialRepoRepository modrinth curseforge"
fi

./gradlew $GRADLE_ARG
