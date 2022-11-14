import axios from "axios";
import AuthHeader from './../../Authentication/Service/AuthHeader';

class AddSocietyService {
  addSociety(societyDto) {
    // will return the token
    return axios
      .post("http://localhost:8080/society", societyDto, {headers: AuthHeader()})
      .then((response) => {
        // if (response.data.accessToken) {
        //   localStorage.setItem("user", JSON.stringify(response.data));
        // }
        alert(JSON.stringify(response.data));
        return response.data;
      });
  }
}
export default AddSocietyService;
