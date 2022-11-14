import React, { useState } from "react";
import BookingRequestApprovalDto from "../Model/BookingRequestApprovalDto";
import BookingRequestService from "../Service/BookingRequestService";
import { useNavigate } from "react-router";

function BookingRequestApproval(props) {
  const [bookingRequestApprovalDto, setBookingRequestApprovalDto] = useState({
    bookingRequestApprovalDtoKey: new BookingRequestApprovalDto(),
  });
  const navigate = useNavigate();
  let bookingRequestService = new BookingRequestService();

  const initialValues = {
    reqId: 0,
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
    setBookingRequestApprovalDto({ bookingRequestApprovalDtoKey: { ...formValues } });
    bookingRequestService
      .approveBookingRequest(bookingRequestApprovalDto.bookingRequestApprovalDtoKey)
      .then((result) => {
        console.log(JSON.stringify(result));
        navigate("/bookingrequest/ll");
      })
      .catch((error) => {
        alert(error.message);
      });
  };

  return (
    <div>
      <section id="approveBookingRequest">
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
                  Request Id
                </label>
                <input
                  type="number"
                  name="reqId"
                  placeholder="Request Id"
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

export default BookingRequestApproval;
