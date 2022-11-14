import React, { useState } from "react";
import SocietyDto from "../Model/SocietyDto";
import AddSocietyService from "../Service/AddSocietyService";
import { useNavigate } from "react-router";

function AddSociety(props) {
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
    console.log(JSON.stringify(formValues));
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log("sasi");
    console.log(JSON.stringify(formValues));
    setSocietyDto({ societyDtoKey: { ...formValues } });
    societyService
      .addSociety(societyDto.societyDtoKey)
      .then((result) => {
        console.log(JSON.stringify(result));
        navigate("/societies/ll");
      })
      .catch((error) => {
        alert(error.message);
      });
  };
  return (
    <div>
      <section id="addSociety">
        <form onSubmit={handleSubmit}>
          <div className="ui form ms-auto">
            <div className="input-group">
              <div className="field me-auto" style={{ width: "fit-content" }}>
                <label className="me-auto" style={{ width: "fit-content" }}>
                  <p
                    style={{ color: "red", width: "fit-content" }}
                    className="me-auto"
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
              <div className="field me-auto" style={{ width: "fit-content" }}>
                <label className="me-auto" style={{ width: "fit-content" }}>
                  <p
                    style={{ color: "red", width: "fit-content" }}
                    className="me-auto"
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
              style={{ justifyContent: "space-between" }}
            >
              <div className="field">
                <label className="me-auto" style={{ width: "fit-content" }}>
                  <p
                    style={{ color: "red", width: "fit-content" }}
                    className="me-auto"
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
                <label className="me-auto" style={{ width: "fit-content" }}>
                  <p
                    style={{ color: "red", width: "fit-content" }}
                    className="me-auto"
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
                <label className="me-auto" style={{ width: "fit-content" }}>
                  <p
                    style={{ color: "red", width: "fit-content" }}
                    className="me-auto"
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
                <label className="me-auto" style={{ width: "fit-content" }}>
                  <p
                    style={{ color: "red", width: "fit-content" }}
                    className="me-auto"
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
                <label className="me-auto" style={{ width: "fit-content" }}>
                  <p
                    style={{ color: "red", width: "fit-content" }}
                    className="me-auto"
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
    </div>
  );
}

export default AddSociety;
