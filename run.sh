#!/bin/sh +x
docker rm -f api-pet;
PROJECT_VERSION=$(ls target/*.jar | cut -d'-' -f 3)
echo "PROJECT VERSION: api-pet-${PROJECT_VERSION}"

docker run -d --name api-pet -p 8080:8080 api-pet:${PROJECT_VERSION}
