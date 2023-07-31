#!/bin/bash

java --version
java -Dpath=https://${mosip-admin-host}/ -DKeyclockURL=https://${mosip-iam-external-host} -Denv.user=${mosip-api-internal-host}  -Denv.endpoint=https://${mosip-api-internal-host}  -jar automationtests-*-jar-with-dependencies.jar
