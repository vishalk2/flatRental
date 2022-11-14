import { Box, Button, Grid } from '@mui/material';
import React, { useState } from 'react';
import { json, Link } from 'react-router-dom';
import carousel1 from './images/carousel1.jpg';
import PoolIcon from '@mui/icons-material/Pool'
import CarIcon from '@mui/icons-material/DirectionsCar'
import ParkingIcon from '@mui/icons-material/LocalParking'
import ParkIcon from '@mui/icons-material/Park'
import FlatService from './FlatService';
import FlatInfo from './FlatInfo';


function FlatListInfo(props) {
    const user = sessionStorage.getItem("username");
    console.log(user)
    console.log("hello");
    const amenities = {carparking:true, swimmingPool:true, garden:true, flat:"Villa",OneBhk:"", TwoBhk:"3BHK"};
    const [flats, setFlats] = useState();
    let flatService = new FlatService();
    const getAllFlats = () =>{
        flatService.readAllFlats().then((result) => {
            console.log("here");
            setFlats(result);
            console.log(result);
        });
        
    }
    return (
        <div className="container">
            
                        <button onClick={getAllFlats}>Get</button>
                        {
                            flats && flats.map(
                                ( flat) => {return(<FlatInfo key={flat.flatId} flat={flat}/>) }
                            )
                        }

            
        </div>
    );
}

export default FlatListInfo;
