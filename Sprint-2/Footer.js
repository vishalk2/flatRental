import React from "react";
import "./Footer.css";
import { FaDiscord, FaInstagram, FaYoutube ,FaPhoneAlt,} from "react-icons/fa";
import { AiFillMail } from "react-icons/ai";




import { NavLink } from "react-router-dom";

function Footer  () {
  return (
    <div className="Entire-footer">
    
     
      <section className="contact-short">
       
        <div className="grid grid-two-column">
          <div>
            <hr/>
            <h3>Ready to get started?</h3>
            <h3>Talk to us today</h3>
          </div>

          
        </div>
      </section>

      {/* footer section  */}

      <footer>
        <div className="container grid grid-four-column">
          <div className="footer-about">
            <h3>Reserva</h3>
            <p>Where we care about your Dreams</p>
          </div>

          {/* 3rs column  */}
          <div className="footer-social">
            <h3>Follows Us</h3>
            <div className="footer-social--icons">
              <div>
                <FaDiscord className="icons" />
              </div>
              <div>
                <FaInstagram className="icons" />
              </div>
              <div>
                <FaPhoneAlt className="icons"/>
              </div>
              <AiFillMail className="icons"/>
              <div>

              </div>
              <div>
                <a
                  href="https://www.youtube.com"
                  target="_blank">
                  <FaYoutube className="icons" />
                </a>
              </div>
            </div>
          </div>


          

          {/* 4th column  */}
          <div className="footer-contact">
            <h3>Call Us</h3>
            <h3>+91 12345678978</h3>
          </div>
        </div>

        {/* bottom section  */}
        <div className="terms">
          
          <div className="container grid grid-two-column">
            <p>
              @{new Date().getFullYear()} Reserva. All Rights Reserved
            </p>
            <div>
              <p>PRIVACY POLICY</p>
              <p>TERMS & CONDITIONS</p>
            </div>
          </div>
        </div>
    
      </footer>
      
    </div>
  );
};



export default Footer;