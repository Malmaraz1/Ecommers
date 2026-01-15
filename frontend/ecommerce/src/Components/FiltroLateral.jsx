import { useState } from 'react';
import { Accordion, Form } from 'react-bootstrap';

function FiltrosLaterales() {
  // Estados para controlar qué está seleccionado
  const [categoriaSel, setCategoriaSel] = useState(null);
  const [subcategoriaSel, setSubcategoriaSel] = useState(null);

  return (
    <aside>
      <h5>Filtros</h5>
      <Accordion defaultActiveKey="0" flush>
        
        {/* ACORDEÓN DE CATEGORÍAS */}
        <Accordion.Item eventKey="0">
          <Accordion.Header>Categoría Principal</Accordion.Header>
          <Accordion.Body>
            {['Electrónica', 'Hogar', 'Deportes'].map((cat) => (
              <Form.Check 
                key={cat}
                type="radio"
                label={cat}
                name="cat-principal"
                onChange={() => {
                  setCategoriaSel(cat);
                  setSubcategoriaSel(null); // Resetear subcat si cambia la principal
                }}
              />
            ))}
          </Accordion.Body>
        </Accordion.Item>

        {/* SUBCATEGORÍAS: Solo aparecen si elegiste Electrónica */}
        {categoriaSel === 'Electrónica' && (
          <Accordion.Item eventKey="1">
            <Accordion.Header>Subcategorías</Accordion.Header>
            <Accordion.Body>
              {['Celulares', 'Laptops'].map((sub) => (
                <Form.Check 
                  key={sub}
                  type="radio"
                  label={sub}
                  name="sub-cat"
                  onChange={() => setSubcategoriaSel(sub)}
                />
              ))}
            </Accordion.Body>
          </Accordion.Item>
        )}

        {/* MODELOS: Solo aparecen si elegiste Celulares */}
        {subcategoriaSel === 'Celulares' && (
          <Accordion.Item eventKey="2">
            <Accordion.Header>Modelos de Celular</Accordion.Header>
            <Accordion.Body>
              <Form.Check type="checkbox" label="iPhone" />
              <Form.Check type="checkbox" label="Samsung" />
              <Form.Check type="checkbox" label="Xiaomi" />
            </Accordion.Body>
          </Accordion.Item>
        )}

      </Accordion>
    </aside>
  );
}
export default FiltrosLaterales;