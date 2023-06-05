#!/bin/bash

CONTAINER_NAME="pawtropolis_container"

# Verifica se il contenitore esiste
if [[ $(docker ps -aq --filter "name=${CONTAINER_NAME}") ]]; then
  echo "Il contenitore esiste. Rimozione in corso..."
  
  # Ferma il contenitore
  docker stop ${CONTAINER_NAME}

  # Rimuovi il contenitore
  docker rm ${CONTAINER_NAME}

  echo "Il contenitore è stato rimosso."
fi

echo "Creazione del nuovo contenitore in corso..."

# Crea il contenitore
docker run -d -p 5433:5432 -e POSTGRES_DB=pawtropolis -e POSTGRES_PASSWORD=000000 --name ${CONTAINER_NAME} -v pawtropolis_volume:/var/lib/postgresql/data postgres

# Copia lo script.sql nel contenitore
docker cp script.sql ${CONTAINER_NAME}:/script.sql

# Attendi 1 secondo
sleep 1

# Esegui lo script.sql nel contenitore
docker exec -it ${CONTAINER_NAME} psql -U postgres -d pawtropolis -f /script.sql
