import React, { useEffect } from "react";
import "./Cards.css";
import axios from "axios";
import PerfilDiputado from "../../Paginas/PerfilDiputado";
import { Link } from "react-router-dom";

function Cards({ data, titulo }) {
  let imagen = "https://www.camara.cl/img.aspx?prmID=GRCL";
  return (
    <div className="contenedor">
      <div className="container">
        {data.map((diputado, index) => (
          <div className="card" key={index}>
            <img
              src={imagen + diputado.idDiputado}
              className="profile-picture"
            />
            <div className="profile-info">
              <h2>{diputado.nombres}</h2>
              <h2>{diputado.apellidos}</h2>
              <button className="follow-button">
                <Link to={`/perfil/${diputado.idDiputado}`}>Ver Diputado</Link>
              </button>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
}
export default Cards;

/*<div className="card" key={index}>
<img src={imagen + diputado.idDiputado} className="img" />
<div className="card-container">
  <h4>
    <b>
      {diputado.nombres} {diputado.apellidos}
    </b>
  </h4>
</div>
</div>*/
