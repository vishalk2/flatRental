import React, { useEffect, useState } from 'react';

import './css/Login.css'

function Register() {

    const initialValues={username:"", email:"", phoneno:0, age:0,  password:"",  confirmPassword:"", };
    const [formValues, setFormValues] = useState(initialValues);
    const[formErrors, setFormErrors] = useState({});
    const [formSubmit, setFormSubmit] = useState(false);

    const handleChange = (event) =>{
        const {name, value} = event.target;
        setFormValues({...formValues, [name]: value});
        //console.log(JSON.stringify(formValues));
    }
    

    const handleSubmit=(event)=>{
        event.preventDefault();
        setFormErrors(validateForm(formValues));

    }
    useEffect(
        () =>{
            console.log(formErrors);
            if(Object.keys(formErrors).length===0){
                    console.log(JSON.stringify(formValues));
            }
        }, [formErrors]
    );

    const validateForm = (values) => {
        const errors = {};
         //const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]{2,}$/i;
         const phonenoRegex = /[0-9-()+]+$/i;
        if(!values.username){
            errors.username = "Username is required";
        }
        if(!values.password){
            errors.password = "Password is required";
        }
        if( ! values.confirmPassword ){
            errors.confirmPassword = "Password is required";
        }
        if(values.confirmPassword!=values.password){
            errors.confirmPassword = "Password mismatch";
        }
        if(values.phoneno==0){
            errors.phoneno = "Phone number is required";
        }else if(!phonenoRegex.test(values.phoneno)){
            errors.phoneno = "Enter valid phone number";
        }
        if(!values.email){
            errors.email = "Email is required";
         }//else if(!emailRegex.test(values.email)){
        //     errors.email="Enter valid email address";
        // }
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
        <div id="a">
            <form id="login-form" onSubmit={handleSubmit}>
                <h1>Register</h1>
                <div className="ui divider"></div>
                <div className="ui form">
                    <div className="field">
                        <label>Username</label>
                        <input type="text" name="username" placeholder='Username' onChange={handleChange}/>
                    </div>
                    <p id="error-message">{formErrors.username}</p>

                    <div className="field">
                        <label>Email</label>
                        <input type="email" name="email" placeholder='Email' onChange={handleChange}/>
                         
                    </div>
                    <p id="error-message">{formErrors.email}</p>

                    <div className="field">
                        <label>Phone no</label>
                        <input type="number" name="phoneno" placeholder='Phone number' onChange={handleChange}/>
                         
                    </div>
                    <p id="error-message">{formErrors.phoneno}</p>

                    <div className="field">
                        <label>Age</label>
                        <input type="number" min="18" max="120" name="age" placeholder='Age' onChange={handleChange}/>
                         
                    </div>
                    <p id="error-message">{formErrors.age}</p>

                    <div className="field">
                        <label>Password</label>
                        <input type="password" name="password" placeholder='Password' onChange={handleChange}/>
                         
                    </div>
                    <p id="error-message">{formErrors.password}</p>

                    <div className="field">
                        <label>Confirm Password</label>
                        <input type="password" name="confirmPassword" placeholder='Confirm Password' onChange={handleChange}/>
                         
                    </div>
                    <p id="error-message">{formErrors.confirmPassword}</p>

                    
                    <button className='fluid ui button' id="btn">Submit</button>
                </div>
                <p style={{paddingTop:'10px'}}>Already have an account ? <a href="/login" style={{textDecoration:'none'}}>login</a></p>
            </form>
        </div>
        </>
    );
}

export default Register;
