#!/bin/bash

if [[ n$IPNEXT_RELEASE != "n" ]]; then
  . ~/.config/secrets/modrinth.sh
  . ~/.config/secrets/curseforge.sh
fi


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


if [[ n$IPNEXT_PATREON != "n" ]]; then
  IPNEXT_RELEASE=1 --max-workers 32 clean compileKotlin compileJava
else
  ./gradlew --max-workers 32 clean compileKotlin compileJava
fi

GRADLE_ARG="build"

if [[ n$IPNEXT_RELEASE != "n" ]]; then
  GRADLE_ARG="--max-workers 4 $GRADLE_ARG publishAllPublicationsToIpnOfficialRepoRepository modrinth curseforge"
  ./gradlew $GRADLE_ARG
elif [[ n$IPNEXT_PATREON != "n" ]]; then
  GRADLE_ARG="--max-workers 32 $GRADLE_ARG"
  IPNEXT_RELEASE=1 ./gradlew $GRADLE_ARG
else
  GRADLE_ARG="--max-workers 32 $GRADLE_ARG"
  ./gradlew $GRADLE_ARG
fi


pwd

popd
