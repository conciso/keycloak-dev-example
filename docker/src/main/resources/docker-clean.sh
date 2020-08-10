#!/bin/bash
# kill running containers
#docker ps -aq | xargs -r docker stop
#docker ps -aq | xargs -r docker kill

# remove exited/created containers:
docker ps --filter status=dead --filter status=exited --filter status=created -aq | xargs -r docker rm -v

# remove unused images:
docker images --no-trunc | grep '<none>' | awk '{ print $3 }' | xargs -r docker rmi

# remove unused volumes:
docker volume prune -f
