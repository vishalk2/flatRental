import React, { useState } from "react";
import SocietyApprovalDto from "../Model/SocietyApprovalDto";
import SocietyService from "../Service/SocietyService";
import { useNavigate } from "react-router";

function ApproveSociety(props) {
  const [societyApprovalDto, setSocietyApprovalDto] = useState({
    societyApprovalDtoKey: new SocietyApprovalDto(),
  });
  const navigate = useNavigate();
  let societyService = new SocietyService();

  const initialValues = {
    societyId: "",
    approved: false,
  };

  const [formValues, setFormValues] = useState(initialValues);

  const handleChange = (event) => {
    const { name, value } = event.target;
    setFormValues({ ...formValues, [name]: value });
    console.log(JSON.stringify(formValues));
  };

  const handleBooleanChange = (event) => {
    const { name, value } = event.target;
    setFormValues({ ...formValues, [name]: formValues[name]===true?false:true });
    console.log(JSON.stringify(formValues));
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log("Done");
    console.log(JSON.stringify(formValues));
    setSocietyApprovalDto({ societyApprovalDtoKey: { ...formValues } });
    societyService
      .approveSociety(societyApprovalDto.societyApprovalDtoKey)
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
      <section id="approveSociety">
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
                  Society Id
                </label>
                <input
                  type="text"
                  name="societyId"
                  placeholder="Society Id"
                  onChange={handleChange}
                  required
                />
              </div>
            </div>
            <div className="input-group">
              <div className="field me-auto" style={{ width: "fit-content" }}>
                <label className="me-auto" style={{ width: "fit-content" }}>
                  <p
                    style={{ color: "red", width: "fit-content" }}
                    className="me-auto"
                  >
                    *
                  </p>
                  Approve
                </label>
                <input
                  type="checkbox"
                  name="approved"
                  onChange={handleBooleanChange}
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

export default ApproveSociety;
