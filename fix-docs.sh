#!/usr/bin/env bash

find ./build/ -type f -name index.md -exec sed -i 's/\.`operator fun/\.<br>`operator fun/g' {} \;
find ./build/ -type f -name index.md -exec sed -i 's/\.`fun/\.<br>`fun/g' {} \;

echo "Finished fixing dokka generated docs"