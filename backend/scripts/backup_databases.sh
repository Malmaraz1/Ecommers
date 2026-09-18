
set -euo pipefail


PROJECT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
BACKUP_DIR="${PROJECT_DIR}/backups"
TIMESTAMP="$(date +'%Y-%m-%d_%H-%M-%S')"
RETENTION_DAYS=7


if [ -f "${PROJECT_DIR}/.env" ]; then
    export $(grep -v '^#' "${PROJECT_DIR}/.env" | xargs)
fi

mkdir -p "${BACKUP_DIR}"

echo "=========================================="
echo "Iniciando backup: ${TIMESTAMP}"
echo "=========================================="


MYSQL_CONTAINER="backend-mysql8-1"
MYSQL_BACKUP_FILE="${BACKUP_DIR}/mysql_${DB_DATABASE}_${TIMESTAMP}.sql.gz"

echo "[1/3] Realizando dump de MySQL (${DB_DATABASE})..."
docker exec -e MYSQL_PWD="${MYSQL_ROOT_PASSWORD}" "${MYSQL_CONTAINER}" mysqldump -u root "${DB_DATABASE}" \
    | gzip > "${MYSQL_BACKUP_FILE}"

echo "✔ MySQL guardado en: $(basename "${MYSQL_BACKUP_FILE}")"


PG_CONTAINER="backend-postgres14-1"
PG_BACKUP_FILE="${BACKUP_DIR}/postgres_${POSTGRES_DB}_${TIMESTAMP}.sql.gz"

echo "[2/3] Realizando dump de PostgreSQL (${POSTGRES_DB})..."
docker exec -e PGPASSWORD="${POSTGRES_PASSWORD}" "${PG_CONTAINER}" pg_dump -U postgres -d "${POSTGRES_DB}" \
    | gzip > "${PG_BACKUP_FILE}"

echo "✔ PostgreSQL guardado en: $(basename "${PG_BACKUP_FILE}")"


echo "[3/3] Aplicando política de rotación (archivos mayores a ${RETENTION_DAYS} días)..."
find "${BACKUP_DIR}" -type f -name "*.sql.gz" -mtime +"${RETENTION_DAYS}" -exec rm -f {} \;

echo "=========================================="
echo "✔ Backup completado con éxito."
echo "Tamaño de archivos generados:"
ls -lh "${BACKUP_DIR}"/*"${TIMESTAMP}"*.sql.gz
echo "=========================================="
