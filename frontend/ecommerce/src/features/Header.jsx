import Container from "react-bootstrap/Container";
import Nav from "react-bootstrap/Nav";
import { FiShoppingCart } from 'react-icons/fi'; 
import Badge from 'react-bootstrap/Badge';
import Navbar from "react-bootstrap/Navbar";

function MiNavbar() {
  return (
    <Navbar expand="lg" className="bg-light py-3">
      <Container>
        {/* LADO IZQUIERDO: El Logo */}
        <Navbar.Brand href="#home">Wilson</Navbar.Brand>

        <Navbar.Toggle aria-controls="basic-navbar-nav" />

        <Navbar.Collapse id="basic-navbar-nav">
          {/* GRUPO 1: Se queda a la izquierda por defecto */}
          <Nav className="me-auto">
            <Nav.Link href="#home">Inicio</Nav.Link>
            <Nav.Link href="#productos">Productos</Nav.Link>
            <Nav.Link href="#vendidos">Los mas vendidos!</Nav.Link>
            <Nav.Link href="#nuevos">Lo nuevo!</Nav.Link>
          </Nav>

          {/* GRUPO 2: ms-auto empuja este grupo a la DERECHA */}
          <Nav className="ms-auto">
            <Nav.Link href="#login">Iniciar sesion</Nav.Link>
            <Nav.Link href="#register">Registrarse</Nav.Link>
            <Nav.Link href="#cart" className="position-relative">
              <FiShoppingCart size={24} />
              <Badge
                pill
                bg="danger"
                className="position-absolute top-0 start-100 translate-middle"
              >
                0
              </Badge>
            </Nav.Link>
          </Nav>
        </Navbar.Collapse>
      </Container>
    </Navbar>
  );
}

export default MiNavbar;
