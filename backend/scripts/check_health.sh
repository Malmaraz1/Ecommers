#!/usr/bin/env bash

PROJECT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
LOG_FILE="${PROJECT_DIR}/healthcheck.log"
TIMESTAMP="$(date +'%Y-%m-%d %H:%M:%S')"

check_service() {
    local service_name="$1"
    local container_name="$2"
    local port="$3"

    # Consultamos dentro de la red Docker usando wget/curl desde el contenedor de Nginx o Prometheus
    local status_code
    status_code=$(docker exec backend-prometheus-1 wget --spider -S "http://${service_name}:${port}/actuator/health" 2>&1 | awk '/HTTP\// {print $2}' | tail -n 1 || echo "DOWN")

    if [ "${status_code}" = "200" ]; then
        echo "[${TIMESTAMP}] OK: ${service_name} respondiendo correctamente (HTTP 200)." >> "${LOG_FILE}"
        echo "✔ ${service_name}: OK"
    else
        echo "[${TIMESTAMP}] ALERTA: ${service_name} DOWN (Status: ${status_code}). Reiniciando ${container_name}..." >> "${LOG_FILE}"
        echo "✖ ${service_name} DOWN (Status: ${status_code}). Reiniciando..."
        docker restart "${container_name}" >> "${LOG_FILE}" 2>&1
        echo "✔ ${container_name} reiniciado."
    fi
}

echo "=== Ejecutando Watchdog [${TIMESTAMP}] ==="
check_service "api-principal" "backend-api-principal-1" "8001"
check_service "servidor-stock" "backend-servidor-stock-1" "8002"
echo "=========================================="
