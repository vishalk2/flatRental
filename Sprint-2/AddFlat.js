
import React, { useState } from 'react';
import FlatDto from './FlatDto';
import FlatService from './FlatService';
import { useNavigate } from "react-router";
import { Box } from '@mui/system';
import Societyinfo from './Societyinfo';
import FlatAdd from './FlatAdd';

function AddFlat(props) {
    const[result, setResult] = useState();
    const[flatDto, setFlatDto] = useState({FlatDtoKey: new FlatDto()});
    const navigate = useNavigate();
    let flatService = new FlatService();
    const initialValues={area:"",state:"",city:"",country:"",pincode:0,landlordId:0,societyId:0,flatNo:0,flatType:'',rentalCost:0, garden:false,carParking:false, swimmingPool:false, houseFacing:'', squareFeet:0 }
    
    

    const [formValues , setFormValues] = useState(initialValues);

    const handleChange = (event) =>{
        const {name, value} = event.target;
        setFormValues({...formValues, [name]: value});
        console.log(JSON.stringify(formValues));
    }
    const onYes =() =>{
        navigate("/login");
      }
    const handleSubmit = (e) => {
        e.preventDefault();
        console.log("sasi");
        console.log(JSON.stringify(formValues));
        setFlatDto({ FlatDtoKey: { ...formValues } });
        console.log(JSON.stringify(flatDto));
        flatService.addFlat(flatDto.FlatDtoKey)
        .then((result) => {
            setResult(result);
        }).catch((error) => {
            alert(error.message);
          });

    }

    const handleCheckBox = (e) => {
        const {name, value} = e.target;
        console.log(name);
        setFormValues({...formValues, [name]: formValues[name]===true?false:true});
        console.log(JSON.stringify(formValues));

    }
    return (
        <div>
            {
                result?
                <center>
        <Box>
        {
                
                result ?(
                                  
                    <FlatAdd key={result.flatId} flat={result} />
                   
              
              ):null
            }
            {result?<button onClick={onYes}>ok</button>:null}
        </Box>
      </center>
      :
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
                        <input type="number" name="flatNo" placeholder='Flat no.'  onChange={handleChange} required/>
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
                    <div className="me-auto " style={{width:'fit-content'}}>
                        <label>Square Feet</label>
                        <input type="text" name="squareFeet" placeholder='Square feet' onChange={handleChange} required/>
                    </div>
                    
                    <div className="field ms-auto" style={{width:'fit-content', marginTop:'2%'}} >
                        <button  className="btn btn-warning" >Submit</button>
                        
                    </div>
                    </div>
                </form>
            </section>
}
        </div>
    );
}

export default AddFlat;
