import { Box, Grid } from '@mui/material';
import React, { useState } from 'react';
import { useNavigate } from "react-router";
import UserService from "./UserService";
import JwtRequest from "./JwtRequest";

import './css/Login.css'

function Login(props) {

    const [user, setUser] = useState({ login: new JwtRequest() });
    const navigate = useNavigate();
    let service = new UserService();

    const initialValues={username:"", password:""};
    const [formValues, setFormValues] = useState(initialValues);
    const[formErrors, setFormErrors] = useState({});
    

    const handleChange = (event) =>{
        const {name, value} = event.target;
        setFormValues({...formValues, [name]: value});
        console.log("hello");
        console.log(JSON.stringify(formValues));
    }
    
    const handleUsername = (e) =>{
        handleChange(e);
        setUser({ login: { ...user.login, userName: e.target.value } })
    }

    const handlePassword = (e) =>{
        handleChange(e);
        setUser({ login: { ...user.login, password: e.target.value } })
    }
    
    const finalSubmit = (event) => {
        console.log(formErrors);
        console.log(Object.keys(formErrors).length===0);
        if(Object.keys(formErrors).length===0){
            event.preventDefault();
            service
              .login(user.login)
              .then((result) => {
                alert(JSON.stringify(result));
                sessionStorage.setItem("currentUser", JSON.stringify(result));
                sessionStorage.setItem("username", user.login.userName);
                navigate("/flat/booking/{flatId}");
              })
              .catch((error) => {
                alert(error.message);
              });
    }
    }


    const handleSubmit=(event)=>{
        handleFormValues(event);
        finalSubmit(event);
    }
            
          
        
        
       

    
const handleFormValues = (event) => {
    console.log("in handleform values");
    event.preventDefault();
    setFormErrors(validateForm(formValues));
    console.log(formErrors);
    console.log(JSON.stringify(formValues));
}

    const validateForm = (values) => {
        console.log("in validate form");
        const errors = {};
        // const regex = /^[^\s@]+@[^\s@]+\.[^\s@]{2,}$/i;
        if(!values.username){
            errors.username = "Username is required";
        }
        if(!values.password){
            errors.password = "Password is required";
        }
        // else if(values.password.length<8){
        //     errors.password="Password should be atleast 8 characters";
        //     {console.log(values.password.length)}
        // }
        else if (values.password.length>12){
            errors.password="Password should not be long than 12 Characters";
            {console.log(values.password.length)}

        }
        return errors;
    }

    return (
        <>
        <center>
        <Grid container> 
            <Grid item   md={6} className="d-none d-md-block">
                <Box>

                </Box>
            </Grid>
            <Grid item md={6}>
        <div id="a">
            <form id="login-form" >
                <h1>Login</h1>
                <div className="ui divider"></div>
                <div className="ui form">
                    <div className="field">
                        <label>Username</label>
                        <input type="text" name="username" placeholder='Username' onChange={handleUsername}/>
                    </div>
                    <p id="error-message">{formErrors.username}</p>
                    <div className="field">
                        <label>Password</label>
                        <input type="password" name="password" placeholder='Password' onChange={handlePassword}/>
                         
                    </div>
                    <p id="error-message">{formErrors.password}</p>
                    <button className='fluid ui button' id="btn"
                    onClick={handleSubmit}
                    >Submit</button>
                </div>
                <p style={{paddingTop:'10px'}}>Dont have an account ? <a href="/register" style={{textDecoration:'none'}}>register</a></p>
            </form>
        </div>
        </Grid>
        </Grid>
        </center>
        </>
    );
}

export default Login;
