#!/bin/bash

# Generate documentation
./gradlew clean dokka

# Use gh-pages import tool to push to a clean gh-pages branch
ghp-import build/gfm/javadoc/wekakt/ -p

