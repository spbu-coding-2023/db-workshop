#!/usr/bin/env bash

BASEDIR=$(realpath "$(dirname "$0")")

. "${BASEDIR}/CONTAINER.conf"

docker exec \
  --interactive \
  --tty \
  "$CONTAINER_NAME" \
  cypher-shell -u neo4j -p "$PASSWORD" --file "${EXAMPLE_DIR}/init.cql"
