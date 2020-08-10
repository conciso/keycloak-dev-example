# Keycloak Docker Container for local dev environments

## How to export new keycloak configuration while container is running:

### Login to docker container
```
docker exec -i -t resources_keycloak_1 /bin/bash
```

### Export the configuration

Use the provided keycloak function to export all realms and user configuration:
```
/opt/jboss/keycloak/bin/standalone.sh -Dkeycloak.migration.action=export -Dkeycloak.migration.provider=dir -Dkeycloak.migration.dir=/tmp/export -Djboss.socket.binding.port-offset=10
```

Move the configuration files from `/resources/keycloak` to `/docker/keycloak`

### Import the configuration to a freshly build container image

Rebuild the container image using:
```
mvn install
```