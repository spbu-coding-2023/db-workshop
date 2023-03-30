#!/usr/bin/env bash

BASEDIR=$(realpath "$(dirname "$0")/..")

function usage()
{
	echo "$0 <command=create|init|delete|drop> <database filename>"
}

if [[ $# -ne 2 || $1 != "create" && $1 != "init" && $1 != "delete" && $1 != "drop" ]]; then
  usage
  exit 1
fi

sqlite3 "${BASEDIR}/$2" < "${BASEDIR}/example/$1.sql"
