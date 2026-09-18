#!/usr/bin/env bash
set -euo pipefail

PROJECT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
BACKUP_DIR="${PROJECT_DIR}/backups"

if [ -f "${PROJECT_DIR}/.env" ]; then
    set -a
    source <(sed -e 's/\r$//' -e '/^[[:space:]]*#/d' -e '/^[[:space:]]*$/d' "${PROJECT_DIR}/.env")
    set +a
fi

echo "=========================================="
echo " RESTAURACIÓN DE BASES DE DATOS"
echo "=========================================="

# Buscar el backup más reciente de cada una
LATEST_MYSQL=$(ls -t "${BACKUP_DIR}"/mysql_*.sql.gz 2>/dev/null | head -n 1 || true)
LATEST_PG=$(ls -t "${BACKUP_DIR}"/postgres_*.sql.gz 2>/dev/null | head -n 1 || true)

if [ -z "${LATEST_MYSQL}" ] || [ -z "${LATEST_PG}" ]; then
    echo "Error: No se encontraron archivos de backup en ${BACKUP_DIR}"
    exit 1
fi

# Restaurar MySQL
echo "Restaurando MySQL desde: $(basename "${LATEST_MYSQL}")..."
gunzip -c "${LATEST_MYSQL}" | docker exec -i -e MYSQL_PWD="${MYSQL_ROOT_PASSWORD}" backend-mysql8-1 mysql -u root "${DB_DATABASE}"
echo "✔ MySQL restaurado con éxito."

# Restaurar PostgreSQL
echo "Restaurando PostgreSQL desde: $(basename "${LATEST_PG}")..."
gunzip -c "${LATEST_PG}" | docker exec -i -e PGPASSWORD="${POSTGRES_PASSWORD}" backend-postgres14-1 psql -U postgres -d "${POSTGRES_DB}"
echo "✔ PostgreSQL restaurado con éxito."

echo "=========================================="
echo "✔ Proceso de restore completado."
echo "=========================================="
