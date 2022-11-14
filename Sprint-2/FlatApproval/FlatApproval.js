import React, { useState } from "react";
import FlatApprovalDto from "../Model/FlatApprovalDto";
import FlatService from "../Service/FlatService";
import { useNavigate } from "react-router";

function FlatApproval(props) {
  const [flatApprovalDto, setFlatApprovalDto] = useState({
    flatApprovalDtoKey: new FlatApprovalDto(),
  });
  const navigate = useNavigate();
  let flatService = new FlatService();

  const initialValues = {
    flatId: 0,
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
    setFlatApprovalDto({ flatApprovalDtoKey: { ...formValues } });
    flatService
      .approveFlat(flatApprovalDto.flatApprovalDtoKey)
      .then((result) => {
        console.log(JSON.stringify(result));
        navigate("/flats/admin");
      })
      .catch((error) => {
        alert(error.message);
      });
  };

  return (
    <div>
      <section id="approveFlat">
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
                  Flat Id
                </label>
                <input
                  type="text"
                  name="flatId"
                  placeholder="Flat Id"
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

export default FlatApproval;
