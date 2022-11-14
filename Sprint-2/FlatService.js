import axios from "axios";


export default class FlatService{
    addFlat(flatDto){
        return axios
      .post("http://localhost:9000/flat", flatDto, {headers:{'Authorization':'Bearer '+JSON.parse(sessionStorage.getItem('currentUser')).token}})
      .then((response) => {
        alert(JSON.stringify(response.data));
        return response.data;
      });
    }
}
