

import React from 'react';
import { Nav } from 'react-bootstrap';
import { Funnel } from 'react-bootstrap-icons';

const OrdenadorProductos = ({ alCambiarOrden }) => {
  return (
    <div className="d-flex justify-content-between align-items-center mb-4 bg-light p-2 rounded shadow-sm">
      {/* Sección del Icono */}
      <div className="d-flex align-items-center ms-2">
        <Funnel size={20} className="me-2 text-secondary" />
        <span className="fw-bold text-dark">Ordenar por:</span>
      </div>

      {/* Botones de Ordenamiento */}
      <Nav 
        variant="pills" 
        className="gap-3 me-2" 
        onSelect={(selectedKey) => alCambiarOrden(selectedKey)}
      >
        <Nav.Item>
          <Nav.Link eventKey="ventas" className="border text-dark bg-white">
            Más vendido
          </Nav.Link>
        </Nav.Item>
        <Nav.Item>
          <Nav.Link eventKey="precio-asc" className="border text-dark bg-white">
            Precio Min
          </Nav.Link>
        </Nav.Item>
        <Nav.Item>
          <Nav.Link eventKey="precio-desc" className="border text-dark bg-white">
            Precio Max
          </Nav.Link>
        </Nav.Item>
      </Nav>
    </div>
  );
};

export default OrdenadorProductos;