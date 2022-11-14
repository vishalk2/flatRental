import { CardActions, CardContent, CardMedia, IconButton } from '@mui/material';
import React, { useState } from 'react';
import { Button, Card } from 'react-bootstrap';
import carousel1 from './images/carousel1.jpg';
import ShareIcon from '@mui/icons-material/Share';
import InfoIcon from '@mui/icons-material/Info';
import FlatService from './FlatService';
import FlatListInfo from './FlatListInfo';

import { Box, Grid } from '@mui/material';
import { json, Link } from 'react-router-dom';
import PoolIcon from '@mui/icons-material/Pool'
import CarIcon from '@mui/icons-material/DirectionsCar'
import ParkingIcon from '@mui/icons-material/LocalParking'
import ParkIcon from '@mui/icons-material/Park'

function FlatInfo({flat}) {
    return (
        <div>
            
            <Box id="flat-card">
            <Grid container className="l">
                <Grid item xs={12} sm={12} md={5} lg={7}>
                    
                        <img src={carousel1} className="img-fluid flat-card-image"/>
                    
                </Grid>
                <Grid item xs={12} sm={12} md={6} lg={5} className=" d-none d-sm-none d-md-block flat-desc">
                    

                    <Box>
                        <p></p>
                        <p>Flat no : {flat.flatNo}</p>
                        <p>Flat Type : {flat.flatType}</p>
                        <p>Address {flat.flatAddress.city}</p>
                        <p></p>
                    </Box>
{flat.flatAmenities.garden?(<p>hell0</p>):(<p>hi</p>)}

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



                    // Object.keys(amenities).map(
                    //     (key,index) => {
                    //         return(
                    //             <div key={index} > 
                    //                 <h2>
                    //                     { typeof amenities[key] === 'boolean' ? 
                    //                     amenities[key] ? 
                    //                     (
                    //                         <div   style={{}}>{
                    //                         key === "swimmingPool" ? (<div className="me-auto" style={{width:'fit-content', fontSize:'16px'}}><PoolIcon  />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Swimming is available through out the day</div>):
                    //                         key === "carparking" ? (<div className="me-auto" style={{width:'fit-content', fontSize:'16px'}}><CarIcon /><ParkingIcon/>&nbsp;&nbsp;A spaceous car parking is available</div>):
                    //                         key === "garden" ? (<div className="me-auto" style={{width:'fit-content', fontSize:'16px'}}><ParkIcon />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Park is available, it has all children games</div> ):null}
                    //                         </div>
                    //                     ):null
                    //                     :(<div style={{ width:'fit-content', fontSize:'24px',marginTop:10}} className="me-auto"><p >{amenities[key]}</p></div>)}
                    //                 </h2>
                    //             </div>
                    //         )
                    //     }
                    // )
                    }
                
            </div>
            <div className="ms-auto" style={{width:'fit-content'}}>
                <Link to={{pathname:`flat/booking/${flat.flatId}`,
                           
                            
                           
            }}>
                <Button variant='contained'>Book the flat</Button>
                </Link>
            </div>

                
            
            </Box>
            

        </div>
        
    );
}

export default FlatInfo;
