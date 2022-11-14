import axios from "axios";

class SocietyService {
  addSociety(societyDto) {
    return axios
      .post("http://localhost:8080/society", societyDto, {
        headers: {
          Authorization:
            "Bearer " + JSON.parse(sessionStorage.getItem("currentUser")).token,
        },
      })
      .then((response) => {
        return response.data;
      });
  }

  approveSociety(societyApprovalDto) {
    return axios
      .put("http://localhost:8080/society/approval", societyApprovalDto, {
        headers: {
          Authorization:
            "Bearer " + JSON.parse(sessionStorage.getItem("currentUser")).token,
        },
      })
      .then((response) => {
        return response.data;
      });
  }

  updateSocietyAddress(societyAddressDto) {
    return axios
      .put(
        "http://localhost:8080/society/updation/address",
        societyAddressDto,
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

  updateSocietyName(societyNameDto) {
    return axios
      .put("http://localhost:8080/society/updation/name", societyNameDto, {
        headers: {
          Authorization:
            "Bearer " + JSON.parse(sessionStorage.getItem("currentUser")).token,
        },
      })
      .then((response) => {
        return response.data;
      });
  }

  readAllSocieties() {
    return axios
      .get("http://localhost:8080/society", {
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
export default SocietyService;
