#!/bin/bash

#
# Inventory Profiles Next
#
#   Copyright (c) 2024 Plamen K. Kosseff <p.kosseff@gmail.com>
#
# This program is free software: you can redistribute it and/or modify
# it under the terms of the GNU Affero General Public License as published by
# the Free Software Foundation, either version 3 of the License, or
# (at your option) any later version.
#
# This program is distributed in the hope that it will be useful,
# but WITHOUT ANY WARRANTY; without even the implied warranty of
# MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
# GNU Affero General Public License for more details.
#
# You should have received a copy of the GNU Affero General Public License
#     along with this program.  If not, see <https://www.gnu.org/licenses/>.
#

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
  IPNEXT_RELEASE=1 ./gradlew --max-workers 32 clean classes
else
  ./gradlew --max-workers 32 clean classes
fi

GRADLE_ARG="--exclude-task compileTestJava --exclude-task test build"


if [[ n$IPNEXT_M != "n" ]]; then
  GRADLE_ARG="$GRADLE_ARG modrinth"
fi

if [[ n$IPNEXT_C != "n" ]]; then
  GRADLE_ARG="$GRADLE_ARG curseforge"
fi

if [[ n$IPNEXT_P != "n" ]]; then
  GRADLE_ARG="$GRADLE_ARG publishAllPublicationsToIpnOfficialRepoRepository"
fi


GRADLE_ARG="--max-workers 32 $GRADLE_ARG"

./gradlew $GRADLE_ARG


pwd

popd
