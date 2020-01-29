#!/bin/sh

docker rm -f mattcattest
docker rmi cattest
docker build -t cattest:latest .
docker run -d --rm --name mattcattest -p 8888:8080 cattest
open -a safari http://localhost:8888/claimnumber
