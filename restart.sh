#!/bin/bash

# Termina il contenitore
docker stop pawtropolis_container

# Rimuove il contenitore
docker rm pawtropolis_container

# Ricrea il contenitore
docker run -d -p 5433:5432 -e POSTGRES_DB=pawtropolis -e POSTGRES_PASSWORD=000000 --name pawtropolis_container postgres

# Copia lo script.sql nel contenitore
docker cp script.sql pawtropolis_container:/script.sql

# Attendi 1 secondi
sleep 1

# Esegui lo script.sql nel contenitore
docker exec -it pawtropolis_container psql -U postgres -d pawtropolis -f /script.sql
