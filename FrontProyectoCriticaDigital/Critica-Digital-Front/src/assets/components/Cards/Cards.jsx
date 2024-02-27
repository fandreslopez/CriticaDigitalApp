import React from "react";
import "./Cards.css";

function Cards({ data, titulo }) {
  let imagen = "https://www.camara.cl/img.aspx?prmID=GRCL";
  return (
    <div className="contenedor">
      <div className="container">
        {data.map((diputado, index) => (
          <div className="card" key={index}>
            <img src={imagen + diputado.idDiputado} className="img" />
            <div className="card-container">
              <h4>
                <b>
                  {diputado.nombres} {diputado.apellidos}
                </b>
              </h4>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
}
export default Cards;
