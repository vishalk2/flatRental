import React, { useState } from 'react';
import './css/LandpageSearchBar.css';

import SearchIcon from '@mui/icons-material/Search';
import LocationOnIcon from '@mui/icons-material/LocationOn';
import { Dropdown } from 'react-bootstrap';
import DropdownToggle from 'react-bootstrap/esm/DropdownToggle';
import HomeIcon from '@mui/icons-material/Home'
import DropdownMenu from 'react-bootstrap/esm/DropdownMenu';
import CurrencyRupeeIcon from '@mui/icons-material/CurrencyRupee';
import { Grid } from '@mui/material';
import FlatService from './FlatService';
import FlatInfo from './FlatInfo';

export default function LandpageSearchBar(){
    let flatService = new FlatService()
    const initialValues = {location : "", flat :false, plot:false, OneBHK:false, TwoBHK:false, Flat: false, budget:""};
    const[flats, setFlats] = useState();
    var [count, setCount] =useState(0);
    const [searchBarValues, setSearchBarValues] = useState(initialValues);

    const getAllFlats = () => {
        flatService.readAllFlats().then((result) => {
            console.log("here");
            setFlats(result);
            console.log(result);
        });

    }

    const searchBar = (searchBarValues) => {
         if( flats.flatAddress?flats.flatAddress.city===searchBarValues.location:null && flats.rentalCost<=searchBarValues.budget){
            
            return(<FlatInfo key={flats.flatId} flat={flats} />) 

         }

    }
    const handleSubmit = (event) => {
        event.preventDefault();
        console.log("submitted");
        console.log(JSON.stringify(searchBarValues));
        getAllFlats();
        searchBar(searchBarValues);
    }
 
    const handleChange =(e) => {
        const {name, value}= e.target;
        console.log(name+" : "+value);
        setSearchBarValues({...searchBarValues,[name]:value});
        console.log(JSON.stringify(searchBarValues));
        
    }
    const handleDropdownClick =(e) => {
        const name = e.target.name;
        const value = searchBarValues[name];
        console.log(value);
        setSearchBarValues({...searchBarValues,[name]:!value});
        console.log(JSON.stringify(searchBarValues));
        setCount((count) => count+1)
        console.log(count); 
    }
   
        return (
            <>
                <center>
                <div className=" " id="search-bar">
                    
                <Grid container>
                    {/* Location block */}
                    <Grid item xs={6} sm={3} md={3} style={{marginTop:'1%'}}>
                        <Grid container>
                            <Grid item xs={2} sm={2} md={2}>
                                <LocationOnIcon style={{ color: "rgb(112, 198, 232)", paddingTop:5 }} />
                            </Grid>
                            <Grid item xs={10} sm={10} md={4}>
                                <input type="text" placeholder="Enter City, Project" id="input" name="location" onChange={handleChange }
                                
                                />
                                
                            </Grid>
                        </Grid>
                    </Grid>
                    {/* Dropdrown Block */}
                    <Grid item xs={6} sm={2} md={2} >
                        
                    <Dropdown >
                            <Dropdown.Toggle id="searchbar-org-dropdown"><HomeIcon />Flat{count}</Dropdown.Toggle>
                            <Dropdown.Menu>
                                <Dropdown.Item >
                                    <Dropdown>
                            <Dropdown.Toggle id="searchbar-dropdown">Residential</Dropdown.Toggle>
                                <Dropdown.Item onClick={handleDropdownClick} href="#/Login" name="flat">Flat</Dropdown.Item>
                                <Dropdown.Item onClick={handleDropdownClick} href="#/Register" name="plot">Plot</Dropdown.Item>
                                <Dropdown.Item onClick={handleDropdownClick} name ="OneBHK"> 1 BHK</Dropdown.Item>
                                <Dropdown.Item onClick={handleDropdownClick} name ="TwoBHK">2 BHK</Dropdown.Item>
                            </Dropdown>

                                </Dropdown.Item>
                                <Dropdown.Item onClick={handleDropdownClick}href="#/Login" name ="Flat">Flat</Dropdown.Item>
                               
                       
                            </Dropdown.Menu>
                        </Dropdown>
                        
                    </Grid>
                    {/* Budget */}
                    <Grid item xs={6} sm={3} md={3} style={{marginTop:'.7%'}}>
                        <Grid container>
                            <Grid item xs={2} sm={2} md={2} >
                            <CurrencyRupeeIcon />
                            </Grid>
                            <Grid item xs={8} sm={10} md={4} >
                            <input type="text" placeholder='Budget' style={{border:'1px solid black'}} name ="budget" onChange={handleChange}/>
                            </Grid>
                        </Grid>
                    </Grid>
                    {/* search button */}
                    <Grid item xs={6} sm={4} md={4} >
                        
                    <button type="submit" id="search-bar-button" onClick={handleSubmit}><SearchIcon style={{ marginRight: "10px" }} />Search</button>
                            
                    </Grid>
                </Grid>
                    </div>

                </center>





            </>
        )
        }
