#!/bin/bash

if [ -z "$(docker images | grep custom-mssql)" ]
then
    echo "docker image custom-mssql not found."
    echo "Building..."
    docker build -t custom-mssql .
    echo "you may now use '$ docker-compose up' for tests"
else
    echo "Docke image custom-mssql found."
    echo "you may now use '$ docker-compose up' for tests"
fi
