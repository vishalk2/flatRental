import axios from "axios";

export default class FlatService {
  addFlat(flatDto) {
    return axios
      .post("http://localhost:8080/flat", flatDto, {
        headers: {
          Authorization:
            "Bearer " + JSON.parse(sessionStorage.getItem("currentUser")).token,
        },
      })
      .then((response) => {
        return response.data;
      });
  }

  approveFlat(flatApprovalDto) {
    return axios
      .put("http://localhost:8080/flat/approval", flatApprovalDto, {
        headers: {
          Authorization:
            "Bearer " + JSON.parse(sessionStorage.getItem("currentUser")).token,
        },
      })
      .then((response) => {
        return response.data;
      });
  }

  availableFlat(flatAvailableDto) {
    return axios
      .put("http://localhost:8080/flat/available", flatAvailableDto, {
        headers: {
          Authorization:
            "Bearer " + JSON.parse(sessionStorage.getItem("currentUser")).token,
        },
      })
      .then((response) => {
        return response.data;
      });
  }

  readAllFlats() {
    return axios
      .get("http://localhost:8080/flat", {
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
