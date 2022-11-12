import React from "react";
import "./Footer.css";
import "bootstrap/dist/css/bootstrap.min.css";
import { AiFillMail, AiFillPhone } from "react-icons/ai";
import { FaFacebook, FaInstagram, FaYoutube ,FaTwitter } from "react-icons/fa";

function Footer() {
  return (
    <div class="">
      <footer class="text-white text-center text-lg-start bg-dark">
        <div class="container p-2">
          <div class="row mt-2">
            <div class="col-lg-4 col-md-8 mb-3 mb-md-0">
              <h5 class="text-uppercase mb-2">About RESERVA</h5>

              <p id="p-footer">
                Reserva is an online flat rental application which acts as a
                third party tool connecting Tenants and Landlords.
              </p>

              <p id="p-footer">
                This application is built upon Java, Springboot REST and
                ReactJS.
              </p>

              <div class="mt-2 footer-social--icons">
                <a
                  type="button"
                  href="https://www.facebook.com/"
                >
                  <FaFacebook className="icons" />
                </a>
                <a
                  type="button"
                  href="https://www.instagram.com/"
                >
                  <FaInstagram className="icons" />
                </a>
                <a
                  type="button"
                  href="https://www.twitter.com/"
                >
                  <FaTwitter className="icons" />
                </a>
                <a
                  type="button"
                  href="https://www.youtube.com/"
                >
                  <FaYoutube className="icons" />
                </a>
              </div>
            </div>

            <div class="col-lg-4 col-md-12 mb-4 mb-md-0">
              <h5 class="text-uppercase mb-4" id="div-contact">Contact</h5>
              <div id="div-contact">
                <span class="fa-li">
                  <AiFillMail className="icons" />
                </span>
                <span class="ms-2">contact@reserva.com</span>
              </div>
              <div id="div-contact">
                <span class="fa-li">
                <AiFillPhone className="icons" />
                </span>
                <span class="ms-2">+040 234 567 89</span>
              </div>
            </div>

            <div class="col-lg-4 col-md-7 mb-4 mb-md-0">
              <h5 class="text-uppercase mb-3">Operating hours</h5>

              <table class="table text-center text-white">
                <tbody class="fw-normal">
                  <tr>
                    <td>Mon - Fri:</td>
                    <td>9am - 6pm</td>
                  </tr>
                  <tr>
                    <td>Sat - Sun</td>
                    <td>10am - 10pm</td>
                  </tr>
                </tbody>
              </table>
            </div>
          </div>
        </div>

        <div
          class="text-center p-3"
          style={{ backgroundColor: "rgba(0, 0, 0, 0.2)" }}
        >
          © 2022 Copyright | RESERVA
        </div>
      </footer>
    </div>
  );
}

export default Footer;
