import React from "react";
import "./ModalCuenta.css";

function ModalComentarios({ isComentariosOpen, onComentarioClose }) {
  if (!isComentariosOpen) return null;

  return (
    <div className="perfilDiputado">
      <div className="seccionDiputado">
        <div className="informacionDiputado">
          <div className="InfoDip">
            <h1>Comentarios</h1>
            <p>Región: </p>
            <p>Partido:</p>
            <p>Fecha de Nacimiento:</p>
          </div>
        </div>
        <div className="RedesDiputado"></div>
      </div>
    </div>
  );
}

export default ModalComentarios;
