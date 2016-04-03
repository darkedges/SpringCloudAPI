#!/bin/bash

PROJECTS=( service-payroll service-employee server-zuul server-turbine server-eureka )
DIR_NAME=$(pwd)

for f in "${PROJECTS[@]}"
do
  cd "$DIR_NAME/$f"
  mvn clean package docker:build
done