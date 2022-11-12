import { Box, Button, Grid } from '@mui/material';
import React from 'react';
import { json } from 'react-router-dom';
import carousel1 from './images/carousel1.jpg';
import PoolIcon from '@mui/icons-material/Pool'
import CarIcon from '@mui/icons-material/DirectionsCar'
import ParkingIcon from '@mui/icons-material/LocalParking'
import ParkIcon from '@mui/icons-material/Park'

function BookingRequest() {
    console.log("hello");
    const amenities = {carparking:true, swimmingPool:true, garden:true, flat:"Villa",OneBhk:"", TwoBhk:"3BHK"};
    return (
        <div className="container">
            <Box id="flat-card">
            <Grid container className="l">
                <Grid item xs={12} sm={12} md={5} lg={7}>
                    
                        <img src={carousel1} className="img-fluid flat-card-image"/>
                    
                </Grid>
                <Grid item xs={12} sm={12} md={6} lg={5} className=" d-none d-sm-none d-md-block flat-desc">
                    

                    <Box>
                        <p>Society :</p>
                        <p>Flat no :</p>
                        <p>Flat Type :</p>
                        <p>Address</p>
                        <p></p>
                    </Box>
{amenities.garden?(<p>hell0</p>):(<p>hi</p>)}

                </Grid>
            </Grid>
            <div>
                {
                    // Object.values(amenities).map(
                    //     (value,index) => {
                    //         return(
                    //             <div key={index}> 
                    //                 <h2>
                    //                     {typeof value === 'boolean' ? (<p>hello</p>) : (<p>hi</p>)}
                    //                     {console.log(amenities[value])}
                    //                 </h2>
                    //             </div>
                    //         )
                    //     }
                    // )



                    Object.keys(amenities).map(
                        (key,index) => {
                            return(
                                <div key={index} > 
                                    <h2>
                                        { typeof amenities[key] === 'boolean' ? 
                                        amenities[key] ? 
                                        (
                                            <div   style={{}}>{
                                            key === "swimmingPool" ? (<div className="me-auto" style={{width:'fit-content', fontSize:'16px'}}><PoolIcon  />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Swimming is available through out the day</div>):
                                            key === "carparking" ? (<div className="me-auto" style={{width:'fit-content', fontSize:'16px'}}><CarIcon /><ParkingIcon/>&nbsp;&nbsp;A spaceous car parking is available</div>):
                                            key === "garden" ? (<div className="me-auto" style={{width:'fit-content', fontSize:'16px'}}><ParkIcon />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Park is available, it has all children games</div> ):null}
                                            </div>
                                        ):null
                                        :(<div style={{ width:'fit-content', fontSize:'24px',marginTop:10}} className="me-auto"><p >{amenities[key]}</p></div>)}
                                    </h2>
                                </div>
                            )
                        }
                    )
                    }
                
            </div>
            <div className="ms-auto" style={{width:'fit-content'}}>
                <Link to="/flat/booking/{flatId}">
                <Button variant='contained'>Book the flat</Button>
                </Link>
            </div>

                
            
            </Box>
            
        </div>
    );
}

export default BookingRequest;
