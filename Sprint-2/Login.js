import React, { useState } from 'react';

import './css/Login.css'

function Login(props) {

    const initialValues={username:"", password:""};
    const [formValues, setFormValues] = useState(initialValues);
    const[formErrors, setFormErrors] = useState({});
    

    const handleChange = (event) =>{
        const {name, value} = event.target;
        setFormValues({...formValues, [name]: value});
        console.log(JSON.stringify(formValues));
    }
    

    const handleSubmit=(event)=>{
        event.preventDefault();
        setFormErrors(validateForm(formValues));

    }

    const validateForm = (values) => {
        const errors = {};
        // const regex = /^[^\s@]+@[^\s@]+\.[^\s@]{2,}$/i;
        if(!values.username){
            errors.username = "Username is required";
        }
        if(!values.password){
            errors.password = "Password is required";
        }
        else if(values.password.length<8){
            errors.password="Password should be atleast 8 characters";
            {console.log(values.password.length)}
        }
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
            <form id="login-form" onSubmit={handleSubmit}>
                <h1>Login</h1>
                <div className="ui divider"></div>
                <div className="ui form">
                    <div className="field">
                        <label>Username</label>
                        <input type="text" name="username" placeholder='Username' onChange={handleChange}/>
                    </div>
                    <p id="error-message">{formErrors.username}</p>
                    <div className="field">
                        <label>Password</label>
                        <input type="password" name="password" placeholder='Password' onChange={handleChange}/>
                         
                    </div>
                    <p id="error-message">{formErrors.password}</p>
                    <button className='fluid ui button' id="btn">Submit</button>
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
