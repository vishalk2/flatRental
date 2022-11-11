import 'bootstrap/dist/css/bootstrap.min.css';
import Admin from './Admin';
import Footer from './Footer'; 


import AdminLogin from './AdminLogin';
import './App.css';
import {BrowserRouter as Router,Routes ,Route , Link  } from 'react-router-dom';

function App() {

  return (
    <>
    <Router>
    <div className="App">
     
        <Routes>
          <Route  path ="/" element = {<Admin/>}>
          
          </Route>
          <Route  path ="/AdminLogin" element = {<AdminLogin/>}>
          </Route>
        
          <Route  path ="/Footer" element = {<Footer/>}>
          </Route>
        </Routes>
     
    </div>
    
    </Router>

    

  
  </>
  );
  
}

export default App;
