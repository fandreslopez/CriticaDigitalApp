import React from "react";
import "./ModalCuenta.css";
import { useState, useEffect } from "react";
import axios from "axios";

function ModalComentarios({
  isComentariosOpen,
  onComentarioClose,
  idComentarios,
}) {
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
            <div className="comentarios">
              <h1>Comentarios</h1>
              {comentarios.map((comentariosDiputados, index) => (
                <p key={index}>
                  Usuario: Anónimo
                  <br />
                  Comentario: {comentariosDiputados.comentarios}
                </p>
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
