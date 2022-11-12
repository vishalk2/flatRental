import { Button, Card, CardContent, Grid } from '@mui/material';
import { Box } from '@mui/system';
import React from 'react';
import carousel1 from './images/carousel1.jpg';
import './css/Tenant.css';
import { Link } from 'react-router-dom';
function Tenant() {
    return (
        <div className="container" id="flat-card">
            
            <Box >
            <Grid container spacing={1}>
                <Grid item xs={12} sm={12} md={6} lg={5}>
                    
                        <img src={carousel1} className="img-fluid flat-card-image"/>
                    
                </Grid>
                <Grid item xs={12} sm={12} md={6} lg={5} className="container" style={{padding:30}}>
                    
                        <p className=" d-none  d-sm-block">Bootstrap is a free and open-source CSS framework directed at responsive, mobile-first front-end web development. It contains HTML, CSS and JavaScript-based design templates for typography, forms, but…</p>
                        <Grid container >
                            <Grid item xs={12} sm={5} md={5} style={{marginTop:25}} >
                                <Link to ="flat/{flatId}">
                                    <Button variant="outlined" style={{textDecoration:'none'}}>More info</Button>
                                </Link>
                                </Grid>
                                <Grid item xs={12} sm={5} md={6} style={{marginTop:25}}>
                                <Link to ="flat/bookingRequest/{flatId}">
                                    <Button variant="contained"  >Rent flat</Button>
                                </Link>
                                </Grid>
                            
                        </Grid>
                </Grid>

            </Grid>
            
            </Box>
        </div>
    );
}

export default Tenant;
