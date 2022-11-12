import { Button, ButtonBase, Card, CardContent, Grid } from '@mui/material';
import { Box } from '@mui/system';
import React from 'react';
import carousel1 from './images/carousel1.jpg';
import './css/Tenant.css';
import { Link } from 'react-router-dom';
import CallIcon from '@mui/icons-material/Call';
function BookingRequest() {
    return (
        <div className="" id="flat-card">
            
            <Box >
            <Grid container spacing={1}>
                <Grid item xs={12} sm={12} md={6} lg={5}>
                    
                        <img src={carousel1} className="img-fluid flat-card-image"/>
                    
                </Grid>
                <Grid item xs={12} sm={12} md={5} lg={5} className="container" style={{padding:30}}>
                    
                        <p className=" d-none  d-sm-block">Bootstrap is a free and open-source CSS framework directed at responsive, mobile-first front-end web development. It contains HTML, CSS and JavaScript-based design templates for typography, forms, but…</p>
                        <Grid container >
                            <Grid item xs={12} sm={5} md={5} style={{marginTop:25}} >
                                <label>Check in</label>
                                <input name="check-in" min="2022-05-22" id="check-in-id" type="date" />
                                </Grid>
                                <Grid item xs={12} sm={5} md={5} style={{marginTop:25}}>
                                <label>Check out</label>
                                <input name="check-out" min="2022-05-22" id="check-out-id" type="date" />
                                </Grid>
                                <Grid>
                                    <Grid item xs={12} sm={5}>
                                        <label>No. of persons</label>
                                        <input type="number" name="noOfPersons" />
                                    </Grid>
                                    
                                </Grid>
                            
                        </Grid>
                </Grid>
                <Grid item xs={12} sm={12} md={1} lg={2}>
                    <div style={{padding:'25px 25px 0px 0px'}}>
                    <a  href="tel: +919603217650"><Button color="success" variant="contained"><CallIcon/>Contact owner</Button></a>
                    </div>
                </Grid>
            </Grid>
            <div className='ms-auto' style={{ width:'fit-content', padding:'0px 25px 25px 0px'}}>
            <Button  color="primary" variant="outlined">Submit</Button>
            </div>
            </Box>
        </div>
    );
}

export default BookingRequest;
