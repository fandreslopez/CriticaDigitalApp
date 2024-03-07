import React from "react";
import "./ModalCuenta.css";
import { useState, useEffect } from "react";
import axios from "axios";
function ModalVotaciones({ isVotaciones, idVotacionesDiputado }) {
  const [data, setData] = useState({
    votacionAfirmativa: 0,
    votacionEnContra: 0,
    votacionAbstecion: 0,
    votacionDispensado: 0,
    boletinDescripcion: "",
    nombreDiputado: "",
  });
  useEffect(() => {
    axios
      .get(
        `http://localhost:8080/api/votaciones/votacion/${idVotacionesDiputado}`
      )
      .then((response) => {
        setData(response.data);
      })
      .catch((error) => {
        console.log(error);
      });
    console.log("eee");
  }, []);
  const TotalVotaciones =
    data.votacionDispensado +
    data.votacionAfirmativa +
    data.votacionEnContra +
    data.votacionAbstecion;
  const porcentajeDispensado =
    (data.votacionDispensado * 100) / TotalVotaciones; //obtengo el porcentaje de la inasistencia
  const cantidadQuesito1 = (porcentajeDispensado * 360) / 100; //obtengo el valor de cuanto tiene que cubrir el grafico que son 360 grados
  const porcentajeAbstencion = (data.votacionAbstecion * 100) / TotalVotaciones;
  const cantidadQuesito2 = (porcentajeAbstencion * 360) / 100;
  const porcentajeEncontra = (data.votacionEnContra * 100) / TotalVotaciones;
  const cantidadQuesito3 = (porcentajeEncontra * 360) / 100;
  const porcentajeAfavor = (data.votacionAfirmativa * 100) / TotalVotaciones;
  const cantidadQuesito4 = (porcentajeAfavor * 360) / 100;

  const [votaciones, setVotaciones] = useState();
  useEffect(() => {
    axios
      .get(
        `http://localhost:8080/api/votaciones/detalles/${idVotacionesDiputado}`
      )
      .then((response) => {
        setVotaciones(response.data);
      })
      .catch((error) => {
        console.log(error);
      });
  }, []);

  return (
    <>
      {isVotaciones && (
        <div className="perfilDiputado">
          <div className="seccionGrafico">
            <div className="informacionDiputado">
              <div className="votaciones">
                <h1>Votaciones</h1>
                <p>
                  A favor:{data.votacionAfirmativa}{" "}
                  <span className="Afavor">
                    ({Math.round(porcentajeAfavor * 10) / 10}%){" "}
                  </span>{" "}
                  | En Contra: {data.votacionEnContra}{" "}
                  <span className="Encontra">
                    ({Math.round(porcentajeEncontra * 10) / 10}%){" "}
                  </span>{" "}
                  | Abstencion:
                  {data.votacionAbstecion}{" "}
                  <span className="Abstencion">
                    {" "}
                    ({Math.round(porcentajeAbstencion * 10) / 10}%){" "}
                  </span>
                  | Dispensado:
                  {data.votacionDispensado}
                  <span className="Dispensado">
                    {" "}
                    ({Math.round(porcentajeDispensado * 10) / 10}%){" "}
                  </span>{" "}
                  | Total Votaciones: {TotalVotaciones}
                </p>
                <div className="graficoVotacion">
                  <div className="sombraVotacion"></div>
                  <div id="porcion1Votacion" className="recorteVotacion">
                    <div
                      className="quesitoVotacion"
                      style={{ transform: `rotate(${cantidadQuesito1}deg)` }}
                    ></div>
                  </div>
                  <div
                    id="porcion2Votacion"
                    className="recorteVotacion"
                    style={{ transform: `rotate(${cantidadQuesito1}deg)` }}
                  >
                    <div
                      className="quesitoVotacion"
                      style={{
                        transform: `rotate(${
                          cantidadQuesito2 + cantidadQuesito1
                        }deg)`,
                      }}
                    ></div>
                  </div>
                  <div
                    id="porcion3Votacion"
                    className="recorteVotacion"
                    style={{
                      transform: `rotate(${
                        cantidadQuesito2 + cantidadQuesito1
                      }deg)`,
                    }}
                  >
                    <div
                      className="quesitoVotacion"
                      style={{
                        transform: `rotate(${
                          cantidadQuesito2 + cantidadQuesito1 + cantidadQuesito3
                        }deg)`,
                      }}
                    ></div>
                  </div>
                  <div
                    style={{
                      transform: `rotate(${
                        cantidadQuesito2 + cantidadQuesito1 + cantidadQuesito3
                      }deg)`,
                    }}
                    id="porcionFinVotacion"
                    className="recorteVotacion"
                  >
                    <div
                      className="quesitoVotacion"
                      style={{
                        transform: `rotate(180deg)`,
                      }}
                    ></div>
                  </div>
                  <div
                    style={{
                      transform: `rotate(180deg)`,
                    }}
                    id="porcionFinVotacion"
                    className="recorteVotacion"
                  >
                    <div
                      className="quesitoVotacion"
                      style={{
                        transform: `rotate(180deg)`,
                      }}
                    ></div>
                  </div>
                </div>
                <div className="divTabla">
                  <table>
                    <thead>
                      <tr>
                        <th>Boletin</th>
                        <th>Descripción </th>
                        <th>Situación</th>
                      </tr>
                    </thead>
                    <tbody>
                      {votaciones.map((VotacionDiputado, index) => (
                        <tr key={index}>
                          <td>{VotacionDiputado.boletin}</td>
                          <td>{VotacionDiputado.descripcion}</td>
                          <td>{VotacionDiputado.situacion}</td>
                        </tr>
                      ))}
                    </tbody>
                  </table>
                </div>
              </div>
            </div>
          </div>
        </div>
      )}
    </>
  );
}
export default ModalVotaciones;
