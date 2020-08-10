FROM jboss/keycloak@sha256:cc624aa8a797046a826bd70b1a2ff041beeb70a15ae5fa4ae4f832e4366f23f1
ENV KEYCLOAK_LOG_LEVEL=DEBUG
EXPOSE 8080/tcp
COPY ./keycloak/ /tmp/import
USER root
RUN chgrp -R 0 $JBOSS_HOME &&\
chmod -R g+rw $JBOSS_HOME &&\
chmod -R 777 /tmp/import
RUN sed -i -e 's/keycloak;AUTO_SERVER=TRUE/&;MVCC=TRUE;LOCK_TIMEOUT=10000/' $JBOSS_HOME/standalone/configuration/standalone.xml
CMD ["-b", "0.0.0.0", "-Dkeycloak.migration.action=import", "-Dkeycloak.migration.provider=dir", "-Dkeycloak.migration.dir=/tmp/import"]
USER jboss
