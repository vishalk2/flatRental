import { ShoppingCartRounded } from '@mui/icons-material';
import React, { Component, useState } from 'react';
import { Box, Card, CardActions, CardContent, Grid, Modal } from '@mui/material';
import {  Button, Carousel, Nav, Navbar } from 'react-bootstrap';
import { Link } from 'react-router-dom';
import './css/NavbarComp.css'
import './css/Login.css'
import Login from './Login';
import Register from './Register';
import LandpageSearchBar from './LandpageSearchBar';

import carousel1 from './images/carousel1.jpg';
import carousel2 from './images/carousel2.jpg';
import carousel3 from './images/carousel3.jpg';
import carousel4 from './images/carousel4.jpg';
import carousel5 from './images/carousel5.jpg';
import carousel6 from './images/carousel6.jpg';
import carousel7 from './images/carousel7.jpg';
import { Container } from '@mui/system';
import LandpageFooter from './LandpageFooter';
import Tenant from './Tenant';
import FlatInfo from './FlatInfo';
import IndividualFlat from './IndividualFlat';
import FlatListInfo from './FlatListInfo';

import InfoIcon from '@mui/icons-material/Info';


function Home ()  {
        const[modalLoginOpen, setModalLoginOpen] = useState(false);
        const[modalRegisterOpen, setModalRegisterOpen] = useState(false);
        function handleLoginOpen(){
            setModalLoginOpen(true);
        }
        function handleLoginClose(){
            setModalLoginOpen(false);
        }
        function handleRegisterOpen(){
            setModalRegisterOpen(true);
        }
        function handleRegisterClose(){
            setModalRegisterOpen(false);
        }
        return (
            <div>
                 <Navbar  expand="md" id="navbar-main">
    <Navbar.Brand as={Link} to={"/home"} style={{color:"white"}}>Reserva</Navbar.Brand>
    <Navbar.Toggle aria-controls='home-navbar' />
    <Navbar.Collapse id ="home-navbar">
        <Nav className="ms-auto">
            <Nav.Link style={{color:"white"}} onClick={handleLoginOpen} to="/login">Login</Nav.Link>
            <Nav.Link style={{color:"white"}} onClick={handleRegisterOpen}>Register</Nav.Link>
        </Nav>
    </Navbar.Collapse>
    </Navbar>

    <div>

        <div id="info-under-nav" >
            Travelling? Get updates on COVID-19 tarvel guidance and restrictions.
            <div className="btn btn-light learn-more-btn" type="button">Learn more</div>
        </div>

        <LandpageSearchBar />

        <center>
        <div style={{width:'fit-content'}}>
            <Grid >
                <Grid item xs={12}>
        <Carousel className="container carousel">
            <Carousel.Item className="carousel-image">
                <img className="carousel-image" id="u" src={carousel1} alt="carousel 1"/>
            </Carousel.Item>
            <Carousel.Item>
                <img className="carousel-image" src={carousel2} alt="carousel 2" />
            </Carousel.Item>
            <Carousel.Item>
                <img className="carousel-image" src={carousel3} alt="carousel 3"/>
            </Carousel.Item>
            <Carousel.Item>
                <img className="carousel-image" src={carousel4} alt="carousel 4"/>
            </Carousel.Item>
            <Carousel.Item>
                <img className="carousel-image" src={carousel5} alt="carousel 5"/>
            </Carousel.Item>
            <Carousel.Item>
                <img className="carousel-image" src={carousel6} alt="carousel 6"/>
            </Carousel.Item>
            <Carousel.Item>
                <img className="carousel-image" src={carousel7} alt="carousel 7"/>
            </Carousel.Item>
        </Carousel>
        </Grid>
        </Grid>
        </div>
        </center>


        <center>
        <div className="container " >
            <Grid container>
                <Grid item xs={12} md={6} lg={6}>
        <Card style ={{width:350, padding:'10px'}} >
                <img src={carousel1} height='250px' />
                <CardContent className='me-auto'>
                    See all the beautiful socities in your favourite localities

                </CardContent>
                
                <CardActions >
                    <div style={{marginLeft:'25%'}}>
                    <Button style={{padding:"10px", width:'150px'}} size="small" color="primary">Socities</Button>
                    </div>
                </CardActions>
                
            </Card></Grid><Grid item xs={12} md={6} lg={6}><Card style ={{width:350, padding:'10px'}} >
                <img src={carousel1} height='250px' />
                <CardContent className='me-auto'>
                    Find your dream flat with all amenities you required

                </CardContent>
                <CardActions >
                    <div style={{marginLeft:'25%'}}>
                    <Button style={{padding:"10px", width:'150px'}} size="small" color="primary">Flats</Button>
                    </div>
                </CardActions>
            </Card></Grid>
            </Grid>
        </div>
        </center>
        <center>
            <div className='lo'>
                <Button>Home loan EMI calculator</Button>
            </div>
        </center>
        {/* <LandpageFooter /> */}
        
        {/* <center>
        <Tenant />
        <FlatInfo />
        <IndividualFlat/>
        <FlatListInfo />
        </center>
        <Modal
        open={modalLoginOpen}
        onClose={handleLoginClose}
        >
            <Login />
            
        </Modal>

        <Modal
        open={modalRegisterOpen}
        onClose={handleRegisterClose}
        >
            <Register />
            
        </Modal> */}
        </div>
                
            </div>
        );
    }


export default Home;
