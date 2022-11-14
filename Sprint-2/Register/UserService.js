import axios from "axios";

class UserService {
  login(user) {
    // will return the token
    return axios.post("http://localhost:8080/login", user).then((response) => {
      return response.data;
    });
  }

  logout() {
    sessionStorage.removeItem("currentUser");
  }

  register(data) {
    return axios.post("http://localhost:8080/register", data).then((res) => {
      console.log("UserService: " + JSON.stringify(res));
    });
  }
}

export default UserService;
