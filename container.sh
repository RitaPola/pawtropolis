#!/bin/bash

CONTAINER_NAME="pawtropolis_container"

# Verifica se il contenitore esiste
if [[ -z $(docker ps -aq --filter "name=${CONTAINER_NAME}") ]]; then
  echo "Il contenitore non esiste. Creazione in corso..."

  # Rimuovi il contenitore se esiste
  docker rm ${CONTAINER_NAME}

  # Crea il contenitore
  docker run -d -p 5433:5432 -e POSTGRES_DB=pawtropolis -e POSTGRES_PASSWORD=000000 --name ${CONTAINER_NAME} postgres

  echo "Il contenitore è stato creato."
else
  echo "Il contenitore esiste già."
fi

# Copia lo script.sql nel contenitore
docker cp script.sql ${CONTAINER_NAME}:/script.sql

# Attendi 1 secondo
sleep 1

# Esegui lo script.sql nel contenitore
docker exec -it ${CONTAINER_NAME} psql -U postgres -d pawtropolis -f /script.sql
