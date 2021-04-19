#!/bin/bash
set -e

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" <<-EOSQL
    CREATE DATABASE movies;
    GRANT ALL PRIVILEGES ON DATABASE movies TO postgres;
EOSQL