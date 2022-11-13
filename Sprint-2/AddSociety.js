import React, { useState } from 'react';
import './css/AddSociety.css'

function AddSociety(props) {

    const initialValues={societyName:"",societyArea:"",societyState:"",societyCity:"",societyCountry:"",societyPincode:"",landlordId:0}
    
    const [formValues , setFormValues] = useState(initialValues);

    const handleChange = (event) =>{
        const {name, value} = event.target;
        setFormValues({...formValues, [name]: value});
        console.log(JSON.stringify(formValues));
    }
    
    const handleSubmit = (e) => {
        e.preventDefault();
        console.log("sasi")
        console.log(JSON.stringify(formValues));
        if(formValues.societyCountry==="")
            console.log("ushhhhhhhhhhhhh")
    }
    return (
        <div>
            <section id="addSociety">
                <form  onSubmit={handleSubmit}>
                <div className="ui form ms-auto">
                <div className="input-group" >
                    <div className="field me-auto" style={{ width:'fit-content'}}>
                        <label className="me-auto" style={{ width:'fit-content'}}><p style={{color:'red', width:'fit-content'}} className="me-auto">*</p>Name of the society</label>
                        <input type="text" name="societyName" placeholder='Society name'  onChange={handleChange} required/>
                    </div>
                    <div className="field me-auto" style={{ width:'fit-content'}}>
                        <label className="me-auto" style={{ width:'fit-content'}}><p style={{color:'red', width:'fit-content'}} className="me-auto">*</p>Your id</label>
                        <input type="number" name="landlordId" placeholder='Your id'  onChange={handleChange} required/>
                    </div>
                </div>
                    <div className="input-group" style={{justifyContent:'space-between'}}>
                    <div className="field">
                        <label className="me-auto" style={{ width:'fit-content'}}><p style={{color:'red', width:'fit-content'}} className="me-auto">*</p>Area</label>
                        <input type="text" name="societyArea" placeholder='Society area' onChange={handleChange} required/>
                    </div>
                    <div className="field" >
                        <label className="me-auto" style={{ width:'fit-content'}}><p style={{color:'red', width:'fit-content'}} className="me-auto">*</p>City</label>
                        <input type="text" name="societyCity" placeholder='City' onChange={handleChange} required/>
                    </div>
                    <div className="field">
                        <label className="me-auto" style={{ width:'fit-content'}}><p style={{color:'red', width:'fit-content'}} className="me-auto">*</p>State</label>
                        <input type="text" name="societyState" placeholder='State' onChange={handleChange} required/>
                    </div>
                    </div>
                    <div className="input-group" >
                    
                    <div className="field" >
                        <label className="me-auto" style={{ width:'fit-content'}}><p style={{color:'red', width:'fit-content'}} className="me-auto">*</p>Country</label>
                        <input type="text" name="societyCountry" placeholder='Country' onChange={handleChange} required/>
                    </div>

                    <div className="field" style={{width:'fit-content', marginLeft:'8%'}}>
                        <label className="me-auto" style={{ width:'fit-content'}}><p style={{color:'red', width:'fit-content'}} className="me-auto">*</p>Pincode</label>
                        <input type="number" name="societyPincode" placeholder='pincode' onChange={handleChange} required/>
                    </div>
                    </div>
                    
                    <div className="field ms-auto" style={{width:'fit-content', marginTop:'2%'}} >
                        <button  className="btn btn-warning" >Submit</button>
                        
                    </div>
                    </div>
                </form>
            </section>
        </div>
    );
}

export default AddSociety;
