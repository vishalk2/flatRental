import { Carousel } from "react-bootstrap";
import React from "react";
import './CSS/Carousel.css'



function DemoCarousel () {
    
        return (
           <div className="emi-carousel"> <Carousel className="container carousel">
            <Carousel.Item>
                <ul>
                <li>
                    <h4>There are many Benefits in taking loans </h4>
                     <h4>   And paying  in EMI </h4>
                   
                    <p> Enhances one's Credit Scores</p>
                    <p>  an emi option allows you to buy expensive items right off the shelf</p>
                    <p> even though you might not have the funds to pay for it at that very moment </p>
                </li>
                </ul>
                </Carousel.Item>
                <Carousel.Item>
             <ul>
             <li>
                 <h4>Affordability
                 </h4>
                 <p> Expensive Items like House can be brought with little to No money upfront </p>
                 <p> your lender divides the total amount in monthly instalments, and you pay it off in manageable chunks.</p>
             </li>
             </ul>
             </Carousel.Item>
             <Carousel.Item>

             <ul>
             <li>
                 <h4>Easy on wallet
                 </h4>
                 <p> Since monthly payment is known it is easy to plan the budget for other things</p>
                 <p>It will not burn a hole in your pocket and can make other investments</p>
             </li>
             </ul>
             </Carousel.Item>
             <Carousel.Item>
             <ul>
             <li>
                 <h4>No mediators
                 </h4>
                 <p> The EMI is paid directly to the lenders </p>
                 <p> No nvolments of multiple parties</p>
                 <p> Also several banks and financial institutions now offer flexible emi schemes </p>
             </li>
             </ul>
             </Carousel.Item>
         </Carousel>
         </div>
         
        );
    
}



export default  DemoCarousel;
