import React from 'react';
import { Card, Button, Col } from 'react-bootstrap';

const ProductoCard = ({ producto }) => {
  return (
    <Col sm={12} md={6} lg={4} className="mb-4">
      <Card className="h-100 shadow-sm border-0">
        {/* Imagen del Producto */}
        <Card.Img 
          variant="top" 
          src={producto.imagen || 'https://via.placeholder.com/200'} 
          style={{ objectFit: 'contain', height: '200px', padding: '10px' }}
        />
        
        <Card.Body className="d-flex flex-column">
          <Card.Title className="fs-6 fw-bold">{producto.nombre}</Card.Title>
          <Card.Text className="text-muted small">
            Modelo: {producto.modelo}
          </Card.Text>
          <Card.Text className="fs-5 fw-bold text-success mt-auto">
            ${producto.precio}
          </Card.Text>
          
          <Button variant="dark" className="mt-2 w-100">
            Añadir al carrito
          </Button>
        </Card.Body>
      </Card>
    </Col>
  );
};

export default ProductoCard;