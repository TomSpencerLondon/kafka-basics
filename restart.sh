#!/bin/bash

echo "Stopping and removing all containers and networks..."
docker-compose down

echo "Removing all related Docker images..."
docker images | grep "kafka-microservices" | awk '{print $3}' | xargs docker rmi -f

echo "Cleaning and building the Maven project..."
mvn clean package

echo "Rebuilding Docker images..."
docker-compose build

echo "Starting all services in detached mode..."
docker-compose up -d

echo "Restart process completed!"
