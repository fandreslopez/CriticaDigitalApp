import React, { useEffect, useState } from "react";
import "./Cards.css";
import axios from "axios";
import { Link } from "react-router-dom";

function Cards({ data }) {
  let imagen = "https://www.camara.cl/img.aspx?prmID=GRCL";
  return (
    <div className="contenedor">
      {/*       <h1>DIPUTADOS PERIODO ACTUAL</h1>
       */}{" "}
      <div className="container">
        {data.map((diputado) => (
          <div className="card" key={diputado.idDiputado}>
            <img
              src={imagen + diputado.idDiputado}
              className="profile-picture"
            />
            <div className="profile-info">
              <h2>{diputado.nombres}</h2>
              <h2>{diputado.apellidos.split(" ", 2).join(" ")}</h2>
              <button className="follow-button">
                <Link to={`/perfil/${diputado.idDiputado}`}>Ver Diputado</Link>
              </button>
            </div>
          </div>
        ))}
      </div>
      <footer>
        <p>© 2024 CriticaDigital. Todos los derechos reservados.</p>
      </footer>
    </div>
  );
}
export default Cards;
