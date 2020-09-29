#!/bin/sh +x
PROJECT_VERSION=$(ls target/*.jar | cut -d'-' -f 3)
echo "PROJECT VERSION: api-pet-${PROJECT_VERSION}"

docker build . -t api-pet:${PROJECT_VERSION}
