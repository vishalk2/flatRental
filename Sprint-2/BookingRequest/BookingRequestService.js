import axios from "axios";

export default class BookingRequestService {
  addBookingRequest(bookingRequestDto) {
    return axios
      .post("http://localhost:8080/bookingrequest", bookingRequestDto, {
        headers: {
          Authorization:
            "Bearer " + JSON.parse(sessionStorage.getItem("currentUser")).token,
        },
      })
      .then((response) => {
        return response.data;
      });
  }

  approveBookingRequest(bookingRequestApprovalDto) {
    return axios
      .post(
        "http://localhost:8080/bookingrequest/approval",
        bookingRequestApprovalDto,
        {
          headers: {
            Authorization:
              "Bearer " +
              JSON.parse(sessionStorage.getItem("currentUser")).token,
          },
        }
      )
      .then((response) => {
        return response.data;
      });
  }

  getAllBookingRequests() {
    return axios
      .get("http://localhost:8080/bookingrequest/all", {
        headers: {
          Authorization:
            "Bearer " + JSON.parse(sessionStorage.getItem("currentUser")).token,
        },
      })
      .then((response) => {
        return response.data;
      });
  }

  getAllApprovedBookingRequests() {
    return axios
      .get("http://localhost:8080/bookingrequest/approved", {
        headers: {
          Authorization:
            "Bearer " + JSON.parse(sessionStorage.getItem("currentUser")).token,
        },
      })
      .then((response) => {
        return response.data;
      });
  }
}
