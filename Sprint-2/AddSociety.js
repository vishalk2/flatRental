import React, { useState } from "react";
import SocietyDto from "./SocietyDto";
import AddSocietyService from "./AddSocietyService";
import { useNavigate } from "react-router";
import Societyinfo from "./Societyinfo";
import { Box } from "@mui/system";

function AddSociety() {
  const[result, setResult] = useState();
  const [societyDto, setSocietyDto] = useState({
    societyDtoKey: new SocietyDto(),
  });
  const navigate = useNavigate();
  let societyService = new AddSocietyService();
  const initialValues = {
    societyName: "",
    area: "",
    state: "",
    city: "",
    country: "",
    pincode: "",
    landlordId: 0,
  };

  const [formValues, setFormValues] = useState(initialValues);

  const handleChange = (event) => {
    const { name, value } = event.target;
    setFormValues({ ...formValues, [name]: value });
  };
  const onYes =() =>{
    navigate("/login");
  }

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log("sasi");
    console.log(JSON.stringify(formValues));
    console.log('Bearer '+JSON.parse(sessionStorage.getItem('currentUser')).token);
    setSocietyDto({ societyDtoKey: { ...formValues } });
    societyService
      .addSociety(societyDto.societyDtoKey)
      .then((resultsAxios) => {
        
        console.log(resultsAxios)
        console.log("between");
        console.log(result);
        setResult(resultsAxios) 
      })
      .catch((error) => {
        alert(error.message);
      });
  };
  return (
    <div className="container">
      {result? <center>
        <Box>
        {
                
                result ?(
                                  
                    <Societyinfo key={result.societyId} society={result} />
                   
              
              ):null
            }
            {result?<button onClick={onYes}>ok</button>:null}
        </Box>
      </center>:
      <center>
      <section id="addSociety" style={{border:'2px solid black', width:"500px"}}>
        <form onSubmit={handleSubmit}>
          <div className="ui form ms-auto">
            <div className="input-group">
              <div className="field " style={{ width: "fit-content" }}>
                <label className="" style={{ width: "fit-content" }}>
                  <p
                    style={{ color: "red", width: "fit-content" }}
                    className=""
                  >
                    *
                  </p>
                  Name of the society
                </label>
                <input
                  type="text"
                  name="societyName"
                  placeholder="Society name"
                  onChange={handleChange}
                  required
                />
              </div>
              <div className="field " style={{ width: "fit-content" }}>
                <label className="" style={{ width: "fit-content" }}>
                  <p
                    style={{ color: "red", width: "fit-content" }}
                    className=""
                  >
                    *
                  </p>
                  Your id
                </label>
                <input
                  type="number"
                  name="landlordId"
                  placeholder="Your id"
                  onChange={handleChange}
                  required
                />
              </div>
            </div>
            <div
              className="input-group"
            >
              <div className="field">
                <label className="" style={{ width: "fit-content" }}>
                  <p
                    style={{ color: "red", width: "fit-content" }}
                    className=""
                  >
                    *
                  </p>
                  Area
                </label>
                <input
                  type="text"
                  name="area"
                  placeholder="Society area"
                  onChange={handleChange}
                  required
                />
              </div>
              <div className="field">
                <label className="" style={{ width: "fit-content" }}>
                  <p
                    style={{ color: "red", width: "fit-content" }}
                    className=""
                  >
                    *
                  </p>
                  City
                </label>
                <input
                  type="text"
                  name="city"
                  placeholder="City"
                  onChange={handleChange}
                  required
                />
              </div>
              <div className="field">
                <label className="" style={{ width: "fit-content" }}>
                  <p
                    style={{ color: "red", width: "fit-content" }}
                    className=""
                  >
                    *
                  </p>
                  State
                </label>
                <input
                  type="text"
                  name="state"
                  placeholder="State"
                  onChange={handleChange}
                  required
                />
              </div>
            </div>
            <div className="input-group">
              <div className="field">
                <label className="" style={{ width: "fit-content" }}>
                  <p
                    style={{ color: "red", width: "fit-content" }}
                    className=""
                  >
                    *
                  </p>
                  Country
                </label>
                <input
                  type="text"
                  name="country"
                  placeholder="Country"
                  onChange={handleChange}
                  required
                />
              </div>

              <div
                className="field"
                style={{ width: "fit-content", marginLeft: "8%" }}
              >
                <label className="" style={{ width: "fit-content" }}>
                  <p
                    style={{ color: "red", width: "fit-content" }}
                    className=""
                  >
                    *
                  </p>
                  Pincode
                </label>
                <input
                  type="number"
                  name="pincode"
                  placeholder="pincode"
                  onChange={handleChange}
                  required
                />
              </div>
            </div>

            <div
              className="field ms-auto"
              style={{ width: "fit-content", marginTop: "2%" }}
            >
              <button className="btn btn-warning">Submit</button>
              
            
            </div>
          </div>
        </form>
      </section>
      </center>
}
    </div>
  );
}

export default AddSociety;
