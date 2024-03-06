import React from "react";
import Facebook from "../components/imagenes/Facebook.svg";
import Instagram from "../components/imagenes/Instagram.svg";
import X from "../components/imagenes/X.svg";
import { Link, useLocation } from "react-router-dom";
import "./PerfilDiputado.css";
import { useState, useEffect } from "react";
import ModalComentario from "../components/Modales/ModalComentarios";
import ModalAsistencia from "../components/Modales/ModalAsistencia";
import ModalVotaciones from "../components/Modales/ModalVotaciones";

function PerfilDiputado({ diputado }) {
  const [isComentariosOpen, setIsComentariosOpen] = useState(false);
  const [isAsistenciaOpen, setIsAsistenciaOpen] = useState(false);
  const [isVotacionesOpen, setIsVotacionesOpen] = useState(false);

  const urlDiputado = useLocation();
  const data = urlDiputado.pathname;
  const _id = data.match(/[0-9]/g);
  const idDiputado = _id.join("");
  const diputadoPerfil = diputado.filter(
    (Dip) => Dip.idDiputado === Number(idDiputado)
  )[0];
  let imagen = `https://www.camara.cl/img.aspx?prmID=GRCL${idDiputado}`;
  {
    /* Modal Comentarios */
  }

  function openComentarios() {
    setIsComentariosOpen(true);
    setIsVotacionesOpen(false);
    setIsAsistenciaOpen(false);
  }

  function closeComentarios() {
    setIsComentariosOpen(false);
  }
  {
    /* Modal Asistencia */
  }

  function openAsistencia() {
    setIsAsistenciaOpen(true);
    setIsComentariosOpen(false);
    setIsVotacionesOpen(false);
  }

  function closeAsistencia() {
    setIsAsistenciaOpen(false);
  }
  {
    /* Modal Votaciones */
  }

  function openVotaciones() {
    setIsVotacionesOpen(true);
    setIsAsistenciaOpen(false);
    setIsComentariosOpen(false);
  }

  function closeVotaciones() {
    setIsVotacionesOpen(false);
  }

  return (
    <div>
      <div className="perfilDiputado">
        <div className="seccionDiputado">
          <div className="informacionDiputado">
            <div className="imagenDiputado">
              <img src={imagen} className="imgPerfil" />
            </div>
            <div className="InfoDip">
              <h1>
                {diputadoPerfil.nombres} {diputadoPerfil.apellidos}
              </h1>
              <p>Región: {diputadoPerfil.idRegion.nombreRegion}</p>
              <p>Partido: {diputadoPerfil.alias}</p>
              <p>
                Fecha de Nacimiento:{" "}
                {diputadoPerfil.fechaDeNacimiento.slice(0, 10)}
              </p>
            </div>
          </div>
          <div className="RedesDiputado">
            <div className="redSocial">
              <img src={Facebook} alt="Face" />
              <p>Facebook</p>
            </div>
            <div className="redSocial">
              <img src={Instagram} alt="Insta" />
              <p>Instagram</p>
            </div>
            <div className="redSocial">
              <img src={X} alt="X" />
              <p>X</p>
            </div>
          </div>
        </div>
        <div>
          <div className="likes">
            <button>🌟FAVORITO</button>
          </div>
          <ul className="perfilBotones">
            <button onClick={openComentarios}>RESPUESTAS</button>
            <button onClick={openAsistencia}>ASISTENCIA</button>
            <button onClick={openVotaciones}>VOTACIONES</button>
          </ul>
        </div>
      </div>
      <div className="Comentarios">
        <form className="Box">
          <textarea rows="5" cols="100"></textarea>
          <input
            className="inputperfil"
            type="submit"
            value="Enviar comentario"
          />
        </form>
      </div>
      <ModalComentario
        asistencia={idDiputado}
        isComentariosOpen={isComentariosOpen}
        onComentarioClose={closeComentarios}
      />
      <ModalAsistencia
        isAsistencia={isAsistenciaOpen}
        onAsistencia={closeAsistencia}
        idAsistenciaDiputado={idDiputado}
      />
      <ModalVotaciones
        isVotaciones={isVotacionesOpen}
        onVotaciones={closeVotaciones}
        idVotacionesDiputado={idDiputado}
      />
    </div>
  );
}

export default PerfilDiputado;
