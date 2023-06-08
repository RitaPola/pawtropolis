#!/bin/bash

docker-compose down


docker-compose up -d


docker-compose exec database psql -U postgres -d pawtropolis -f /docker-entrypoint-initdb.d/creation.sql