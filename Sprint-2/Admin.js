import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import NavDropdown from 'react-bootstrap/NavDropdown';
import Button from 'react-bootstrap/Button';
import Footer from './Footer';



function Admin() {
  return (
    <>
    <Navbar bg="dark"  variant ="dark" expand="lg">
      <Container>
        <Navbar.Brand href="#home">Reserva</Navbar.Brand>
        <Navbar.Toggle aria-controls="basic-navbar-nav" />
        <Navbar.Collapse id="basic-navbar-nav">
          <Nav className="me-auto">
            <Nav.Link href="#home">Admin Name</Nav.Link>
            
            <NavDropdown title="Dropdown" id="basic-nav-dropdown">
             
              <NavDropdown.Item href="#action/3.3">Admin Details 1</NavDropdown.Item>
              <NavDropdown.Divider />
              <NavDropdown.Item href="#action/3.4">
                Admin Details 2
              </NavDropdown.Item>
            </NavDropdown>
          </Nav>
        </Navbar.Collapse>
      </Container>
    </Navbar>
    
    <a href="/Adminlogin" > Admin Please click here to  Here..  </a>
    <br>
    </br>
    <br>
    </br>
    <br>
    </br>
    

    <div className="mb-2">
      <Button  variant="primary" size="lg">
        view all Society..
      </Button> {'       '}
      <Button variant="secondary" size="lg">
       view all Flat...
      </Button>
      <br></br>
      <br></br>
      <br></br>

      <Button variant="primary" size="lg">
        Society Approval Request..
      </Button> {'  '}
      <Button variant="secondary" size="lg">
       Flat Approval Request...
      </Button> {'         '}
    </div>
    <div>
    <Footer/>
    </div>
</>
);
}


export default  Admin;

