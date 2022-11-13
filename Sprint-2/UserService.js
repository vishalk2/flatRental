import axios from "axios";

class UserService {
  login(user) {
    // will return the token
    return axios.post("http://localhost:8080/login", user).then((response) => {
      // if (response.data.accessToken) {
      //   localStorage.setItem("user", JSON.stringify(response.data));
      // }
      alert(JSON.stringify(response.data));
      return response.data;
    });
  }

  logout() {
    // localStorage.removeItem("user");
  }

  register(username, email, password) {
    return axios.post("http://localhost:8080/register", {
      username,
      email,
      password,
    });
  }
}

export default UserService;
