#!/bin/sh
./mvnw install
cp ./target/realtime-poc.jar ./realtime-poc.jar
docker-compose up -d