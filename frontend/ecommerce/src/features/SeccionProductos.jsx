import { Container, Row, Col } from "react-bootstrap";
import FiltrosLaterales from "../Components/FiltroLateral";
import OrdenadorProductos from "./ContenidoPrincipal";
import ProductoCard from "../Components/ProductoCard";// Importamos el nuevo componente

function SeccionProductos() {
  // Simulación de datos que vendrían de tu Backend
  const productos = [
    { id: 1, nombre: "iPhone 15", precio: 999, modelo: "Pro Max", imagen: "url_link" },
    { id: 2, nombre: "Samsung S23", precio: 850, modelo: "Ultra", imagen: "url_link" },
    { id: 3, nombre: "MacBook Air", precio: 1200, modelo: "M2", imagen: "url_link" },
    { id: 4, nombre: "Dell XPS 13", precio: 1100, modelo: "9315", imagen: "url_link" },
  ];

  const manejarOrden = (criterio) => {
    console.log("Ordenando por:", criterio);
    // Aquí iría tu lógica de backend: fetch(`/api/productos?sort=${criterio}`)
  };

  return (
    <Container className="mt-5">
      <Row>
        {/* ASIDE - IZQUIERDA */}
        <aside className="col-lg-3 d-none d-lg-block">
          <FiltrosLaterales />
        </aside>

        {/* MAIN - DERECHA */}
        <main className="col-lg-9">
          {/* Barra de ordenamiento */}
          <OrdenadorProductos alCambiarOrden={manejarOrden} />

          {/* GRILLA DE PRODUCTOS */}
          <Row>
            {productos.map((prod) => (
              <Col key={prod.id} sm={12} md={6} lg={4} className="mb-4">
                <ProductoCard producto={prod} />
              </Col>
            ))}
          </Row>
        </main>
      </Row>
    </Container>
  );
}

export default SeccionProductos;