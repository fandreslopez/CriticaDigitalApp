import React from "react";
import "./ModalCuenta.css";
import axios from "axios";
import { useState, useEffect } from "react";
function ModalAsistencia({ isAsistencia, idAsistenciaDiputado }) {
  // const [nombredeestado, setNombredeestado] =  useState(<valor inicial>)
  const [data, setData] = useState({
    nombreDiputado: "",
    asistencias: 0,
    inasistencia: 0,
  });
  useEffect(() => {
    axios
      .get(
        `http://localhost:8080/api/asistencias/asistencia/${idAsistenciaDiputado}`
      )
      .then((response) => {
        setData(response.data);
      })
      .catch((error) => {
        console.log(error);
      });
  }, []);
  const asistenciaTotal = data.asistencias + data.inasistencia;
  const porcentajeInasistencia = (data.inasistencia * 100) / asistenciaTotal; //obtengo el porcentaje de la inasistencia
  const cantidadQuesito1 = (porcentajeInasistencia * 360) / 100; //obtengo el valor de cuanto tiene que cubrir el grafico que son 360 grados
  return (
    <>
      {isAsistencia && (
        <div className="perfilDiputado">
          <div className="seccionGrafico">
            <div className="informacionDiputado">
              <div className="asistencia">
                <h1>Asistencia</h1>
                <p>
                  Asistencia: {"  "} {data.asistencias} (
                  {Math.round((porcentajeInasistencia - 100) * -10) / 10}%)|
                  Inasistencia:{"  "}
                  {data.inasistencia} (
                  {Math.round(porcentajeInasistencia * 10) / 10}%)| Asistencia
                  Total:{"  "} {asistenciaTotal}
                </p>
                <div className="grafico">
                  <div className="sombra"></div>
                  <div id="porcion1" className="recorte">
                    <div
                      className="quesito"
                      style={{ transform: `rotate(${cantidadQuesito1}deg)` }}
                    ></div>
                  </div>
                  <div
                    id="porcion2"
                    className="recorte"
                    style={{ transform: `rotate(${cantidadQuesito1}deg)` }}
                  >
                    <div
                      className="quesito"
                      style={{ transform: `rotate(170deg)` }}
                    ></div>
                  </div>
                  <div id="porcion3" className="recorte">
                    <div className="quesito" data-rel="25"></div>
                  </div>
                  <div id="porcionFin" className="recorte">
                    <div className="quesito" data-rel="145"></div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      )}
    </>
  );
}
export default ModalAsistencia;
