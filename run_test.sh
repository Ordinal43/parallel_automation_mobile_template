#!/bin/bash

THREADS=${1:-"1"}
echo "Run test on $THREADS parallel threads"

if [[ "$THREADS" =~ ^[0-9]+$ ]]; then
  ./gradlew runTest -Dcourgette.threads="$THREADS"
  allure generate ./build/allure-results/ -o ./build/allure-report --clean
else
  echo "Argument must be a positive integer"
fi
