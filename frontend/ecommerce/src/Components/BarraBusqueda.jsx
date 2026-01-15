import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';

function Buscador() {
  return (
    <Form className="d-flex" style={{ maxWidth: '350px' }}>
      <Form.Control
        type="search"
        placeholder="¿Qué estás buscando?"
        className="me-2"
      />
      <Button variant="outline-success">Buscar</Button>
    </Form>
  );
}

export default Buscador;