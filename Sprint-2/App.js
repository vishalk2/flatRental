
import './App.css';
import Home from './Home';
import NavbarComp from './NavbarComp.js';
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Login from './Login';
import Register from './Register';
import 'bootstrap/dist/css/bootstrap.min.css';
import BookingRequest from './BookingRequest';

function App() {
  return (
    <div>

      <Router>

        <Routes>

          <Route path="/" element={<Home />} />
          
          <Route path="/home" element={<Home />} />
 
          <Route path='/login' element={<Login />} />

          <Route path="/register" element={<Register />} />

          <Route path="/flat/booking/{flatId}" element={<BookingRequest />} />



        </Routes>
      </Router>
    </div>
  );
}

export default App;
