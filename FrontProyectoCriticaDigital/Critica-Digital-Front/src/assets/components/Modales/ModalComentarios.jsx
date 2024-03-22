import React from "react";
import "./ModalCuenta.css";
import { useState, useEffect } from "react";
import axios from "axios";

function ModalComentarios({ isComentariosOpen, idComentarios }) {
  const [comentarios, setComentarios] = useState([]);
  useEffect(() => {
    if (isComentariosOpen) {
      axios(
        `http://localhost:8080/api/comentarios/comentarios/${idComentarios}`
      )
        .then((resp) => setComentarios(resp.data))
        .catch((error) => console.log(error));
    }
  }, [isComentariosOpen]);

  return (
    <>
      {isComentariosOpen && (
        <div className="perfilDiputado">
          <div className="informacionDiputado">
            <div className="containerPostit">
              {comentarios.map((comentariosDiputados, index) => (
                <div key={index} className="post-it">
                  <h1>Usuario: Anónimo </h1>
                  <p>{comentariosDiputados.comentarios}</p>
                  <div className="botonreporte">
                    <button className="reporte">!</button>
                  </div>
                </div>
              ))}
            </div>
          </div>
          <div className="RedesDiputado"></div>
        </div>
      )}
    </>
  );
}

export default ModalComentarios;
