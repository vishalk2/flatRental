// private int landlordId;
// 	private int flatNo;
// 	private String flatType;
// 	private double rentalCost;
	
// 	private int societyId;
	
// 	private String area;
// 	private String city;
// 	private String state;
// 	private String country;
// 	private int pincode;
	
// 	private boolean garden;
// 	private boolean swimmingPool;
// 	private boolean carParking;
// 	private String houseFacing;
// 	private double squareFeet;
import React, { useState } from 'react';

function AddFlat(props) {
    const initialValues={area:"",state:"",city:"",country:"",pincode:0,landlordId:0,societyId:0,flatId:0,flatType:'',rentalCost:0, garden:false,carParking:false, swimmingPool:false, houseFacing:'' }
    
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
    }

    const handleCheckBox = (e) => {
        const {name, value} = e.target;
        console.log(name);
        setFormValues({...formValues, [name]: formValues[name]===true?false:true});
        console.log(JSON.stringify(formValues));

    }
    return (
        <div>
            <section id="addSociety">
                <form  onSubmit={handleSubmit}>
                <div className="ui form ms-auto">
                <div className="input-group" style={{justifyContent:'space-between'}}>
                    <div className="field me-auto" style={{ width:'fit-content'}}>
                        <label className="me-auto" style={{ width:'fit-content'}}><p style={{color:'red', width:'fit-content'}} className="me-auto">*</p>Your id</label>
                        <input type="number" name="landlordId" placeholder='Your id'  onChange={handleChange} required/>
                    </div>
                    <div className="field me-auto" style={{ width:'fit-content'}}>
                        <label className="me-auto" style={{ width:'fit-content'}}><p style={{color:'red', width:'fit-content'}} className="me-auto">*</p>Society Id</label>
                        <input type="number" name="societyId" placeholder='SocietyI id'  onChange={handleChange} required/>
                    </div>
                </div>


                <div className="input-group" style={{justifyContent:'space-between'}}>
                    <div className="field me-auto" style={{ width:'fit-content'}}>
                        <label className="me-auto" style={{ width:'fit-content'}}><p style={{color:'red', width:'fit-content'}} className="me-auto">*</p>Flat No.</label>
                        <input type="number" name="flatId" placeholder='Flat no.'  onChange={handleChange} required/>
                    </div>
                    <div className="field me-auto" style={{ width:'fit-content'}}>
                        <label className="me-auto" style={{ width:'fit-content'}}><p style={{color:'red', width:'fit-content'}} className="me-auto">*</p>Flat Type</label>
                        <input type="text" name="flatType" placeholder='Flat type'  onChange={handleChange} required/>
                    </div>
                    <div className="field me-auto" style={{ width:'fit-content'}}>
                        <label className="me-auto" style={{ width:'fit-content'}}><p style={{color:'red', width:'fit-content'}} className="me-auto">*</p>Rental cost</label>
                        <input type="text" name="rentalCost" placeholder='Cost'  onChange={handleChange} required/>
                    </div>
                </div>

                    <div className="input-group" style={{justifyContent:'space-between'}}>
                    <div className="field">
                        <label className="me-auto" style={{ width:'fit-content'}}><p style={{color:'red', width:'fit-content'}} className="me-auto">*</p>Area</label>
                        <input type="text" name="area" placeholder='Area' onChange={handleChange} required/>
                    </div>
                    <div className="field" >
                        <label className="me-auto" style={{ width:'fit-content'}}><p style={{color:'red', width:'fit-content'}} className="me-auto">*</p>City</label>
                        <input type="text" name="city" placeholder='City' onChange={handleChange} required/>
                    </div>
                    <div className="field">
                        <label className="me-auto" style={{ width:'fit-content'}}><p style={{color:'red', width:'fit-content'}} className="me-auto">*</p>State</label>
                        <input type="text" name="state" placeholder='state' onChange={handleChange} required/>
                    </div>
                    </div>
                    
                    <div className="input-group" >
                    
                    <div className="field" >
                        <label className="me-auto" style={{ width:'fit-content'}}><p style={{color:'red', width:'fit-content'}} className="me-auto">*</p>Country</label>
                        <input type="text" name="country" placeholder='Country' onChange={handleChange} required/>
                    </div>

                    <div className="field" style={{width:'fit-content', marginLeft:'8%'}}>
                        <label className="me-auto" style={{ width:'fit-content'}}><p style={{color:'red', width:'fit-content'}} className="me-auto">*</p>Pincode</label>
                        <input type="number" name="pincode" placeholder='pincode' onChange={handleChange} required/>
                    </div>
                    </div>
                    <div style={{width:'fit-content', marginLeft:"0%"}} className="me-auto">
                        
                        <input type="checkbox" name="garden" id="garden"  onClick={handleCheckBox}/>
                        <label>Garden</label><br />
                        <input type="checkbox" name="carParking" id="parking"  onClick={handleCheckBox}/>
                        <label>Car Parking</label><br />
                        <input type="checkbox" name="swimmingPool" id="pool"  onClick={handleCheckBox}/>
                        <label>Swimming pool</label><br />
                    </div>

                    <div className="me-auto " style={{width:'fit-content'}}>
                        <label>House Facing</label>
                        <input type="text" name="houseFacing" placeholder='N-E-W-S' onChange={handleChange} required/>
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

export default AddFlat;
