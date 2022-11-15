import React, { useEffect, useRef, useState } from "react";
import UserDto from "./UserDto";
import { useNavigate } from "react-router";
import UserService from "./UserService";
import "./css/Login.css";
import "bootstrap/dist/css/bootstrap.css";

function Register() {
  const [userDto, setUserDto] = useState({ userDtoKey: new UserDto() });
  const navigate = useNavigate();
  let service = new UserService();

  const initialValues = {
    userName: "",
    emailId: "",
    userPhoneNumber: 0,
    userAge: 0,
    password: "",
    userType:'',
    name:''
  }
  const [formValues, setFormValues] = useState(initialValues);
  const [formErrors, setFormErrors] = useState({});
  const [formSubmit, setFormSubmit] = useState(false);

  const handleChange = (event) => {
    const { name, value } = event.target;
    setFormValues({ ...formValues, [name]: value });
    handleErrors(formValues);
    //console.log(JSON.stringify(formValues));
  };

 const handleErrors = (formValues) =>{
  setFormErrors(validateForm(formValues));
 }


  const handleSubmit = (event) => {
    event.preventDefault();
    
    if(Object.keys(formErrors).length===0){
    console.log("Done");
    console.log(JSON.stringify(formValues));
    setUserDto({ userDtoKey:  formValues });
    console.log(userDto.userDtoKey);
    service
      .register(userDto.userDtoKey)
      .then((result) => {
        console.log(JSON.stringify(result));
        const temp = result.userId;
        console.log(temp);
        sessionStorage.setItem("userId",temp);
        
      })
      .catch((error) => {
        alert(error.message);
      });
    }
  }



  const validateForm = (values) => {
    const errors = {};
    //const emailIdRegex = /^[^\s@]+@[^\s@]+\.[^\s@]{2,}$/i;
    const userPhoneNumberRegex = /[0-9]{10}/i;
    if (!values.userName) {
      errors.userName = "Username is required";
    }
    if (!values.name) {
        errors.name = "Name is required";
      }
    if (!values.password) {
      errors.password = "Password is required";
    }
   
    
    if (values.userPhoneNumber == 0) {
      errors.userPhoneNumber = "Phone number is required";
    } else if (!userPhoneNumberRegex.test(values.userPhoneNumber)) {
      errors.userPhoneNumber = "Enter valid phone number";
    }
    if (!values.emailId) {
      errors.emailId = "Email is required";
    } //else if(!emailRegex.test(values.email)){
    //     errors.email="Enter valid email address";
    // }
    else if (values.password.length < 8) {
      errors.password = "Password should be atleast 8 characters";
      {
        console.log(values.password.length);
      }
    } else if (values.password.length > 16) {
      errors.password = "Password should not be longer than 16 Characters";
      {
        console.log(values.password.length);
      }
    }
    return errors;
  };

  return (
    <>
      <div id="a" className="container">
        <form id="login-form" >
          <h1>Register</h1>
          <div className="ui divider"></div>
          <div className="ui form">
          <div className="field inline-group">
              <input type="radio" id="type" name="userType" value="tenant" onChange={handleChange}/>
              <label htmlFor="type" >Tenant</label>
              <input type="radio" id="type" name="userType" value="landlord" onChange={handleChange}/>
              <label htmlFor="type" >Landlord</label>
            </div>
            <div className="field">
              <label>Username</label>
              <input
                type="text"
                name="userName"
                placeholder="Username"
                     onChange={handleChange}
                required
              />
            </div>
            <p id="error-message">{formErrors.userName}</p>
            <div className="field">
              <label>Name</label>
              <input
                type="text"
                name="name"
                placeholder="Name"
                             onChange={handleChange}
                required
              />
            </div>
            <p id="error-message">{formErrors.name}</p>

            <div className="field">
              <label>Email</label>
              <input
                type="email"
                name="emailId"
                placeholder="Email"
                onChange={handleChange}
                                required
              />
            </div>
            <p id="error-message">{formErrors.emailId}</p>

            <div className="field">
              <label>Phone no</label>
              <input
                type="number"
                name="userPhoneNumber"
                placeholder="Phone number"
                onChange={handleChange}
                
                required
              />
            </div>
            <p id="error-message">{formErrors.userPhoneNumber}</p>

            <div className="field">
              <label>Age</label>
              <input
                type="number"
                min="18"
                max="120"
                name="userAge"
                placeholder="Age"
                onChange={handleChange}
                            required
              />
            </div>
            <p id="error-message">{formErrors.userAge}</p>

            <div className="field">
              <label>Password</label>
              <input
                type="password"
                name="password"
                placeholder="Password"
                onChange={handleChange}
                
                required
              />
            </div>
            <p id="error-message">{formErrors.password}</p>

            {/* <div className="field">
              <label>Confirm Password</label>
              <input
                type="password"
                name="confirmPassword"
                placeholder="Confirm Password"
                onChange={handleChange}
              />
            </div>
            <p id="error-message">{formErrors.confirmPassword}</p> */}

            <button className="fluid ui button" id="btn"onClick={handleSubmit}>
              Submit
            </button>
          </div>
          <p style={{ paddingTop: "10px" }}>
            Already have an account ?{" "}
            <a href="/login" style={{ textDecoration: "none" }}>
              login
            </a>
          </p>
        </form>
      </div>
    </>
  );
}

export default Register;
