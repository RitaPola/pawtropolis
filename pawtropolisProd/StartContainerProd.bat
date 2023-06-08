@echo off

REM Rimuovi il servizio del database se è attivo
docker-compose down

REM Avvia il servizio del database
docker-compose up -d

REM Esegui lo script di creazione nel servizio del database
docker-compose exec database psql -U postgres -d pawtropolis -f /docker-entrypoint-initdb.d/creation.sql