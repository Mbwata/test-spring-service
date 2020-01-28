#!/bin/sh

docker build -t housems/mattcat:latest .
docker push housems/mattcat:latest
