import "./App.css";
import MiNavbar from "./features/Header";
import Buscador from "./Components/BarraBusqueda";
import Container from "react-bootstrap/esm/Container";
import "bootstrap/dist/css/bootstrap.min.css";
import SeccionProductos from "./features/SeccionProductos";

function App() {
  return (
    <>
      <MiNavbar></MiNavbar>
      <Container className="mt-3">
        <Buscador />
      </Container>
    <SeccionProductos></SeccionProductos>
    </>
  );
}

export default App;
