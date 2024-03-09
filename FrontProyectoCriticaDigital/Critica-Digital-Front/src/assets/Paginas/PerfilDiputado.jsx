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
import axios from "axios";

function PerfilDiputado({ diputado, user }) {
  const [isComentariosOpen, setIsComentariosOpen] = useState(false);
  const [isAsistenciaOpen, setIsAsistenciaOpen] = useState(false);
  const [isVotacionesOpen, setIsVotacionesOpen] = useState(false);

  const [comentario, setComentario] = useState("");

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

  const handleLogin = (e) => {
    e.preventDefault();
    axios.post("http://localhost:8080/api/comentarios/nuevo", {
      comentarios: comentario,
      diputadoComentario: { idDiputado: idDiputado },
      fechaPublicacion: Date.now(),
      usuarioComentario: { usuarioId: user.usuario_id },
    });
  };

  return (
    <div>
      <div className="perfilDiputado">
        <div className="seccionDiputado">
          <div className="imagenDiputado">
            <img src={imagen} className="imgPerfil" />
            <div className="likes">
              <button>
                <img
                  className="Star"
                  src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAB4AAAAeCAYAAAA7MK6iAAAAAXNSR0IArs4c6QAAAsRJREFUSEvF1k9IFFEcB/Dvb95okN4Ks1PRLSJ32sRAsOgQOjsLRQsS/SGMILrYrcJTJ80gKOhUQV0iSry57tohpcCD6P7xUNQh8WSrRIFY2/re+8VYbq7urjuj4t7m/fl9fr/33uwbwjb9aJtc+IbN6ORxN2npNLzzk7wvuCqaaGQyXrggaeP8YrhhwivuCxax5BNiWqqYgREVsq5tPRxL7jeZhlZALAXZaA1MecE9V2wOpnoBnClAiPqlHejaOngoXWcqPQKQKERYyWyuBWePfasU91SxOZi6BeBKieCPZci6v/nwULrGVPweQE2J4Asy870ZHSezleAFFVcPTBxUMA7AoD1EqAPTHgbqCFwPoA5A9TpBcwBmGZgh0ByIM6yRgcEZofRULnz04/L8PCwGJ22CflBJtr7HEDqlbS29EXnYjKdboPmp76DrT2RifXHRCY4XwO6DGEg6ZJB7QDwduvVN5KDRKcPW8JqlXm7YAnyBDLq62BZIrEywaGWbhjN+CODSb8f6vHpVSi7pxnGakawuwwlOF9uKsnu5AXxaQl9AKDhXav/LH6LXLMzadBLAjgoO0P8hTM+lE+gpN6csXB2baNAs+jyhf9+VL9K2bN+wiKY6iHDbM+x+mXDuBJymr76WWsRSj4hxyg/MRHeUHXjpCzZj6VEw7yox+ee/9p3F+hl4q0LWde9w9MM+k3JvigZljCkhby792ynzHhGa1owj/JLzVU1oP+ReHEW6S6Qk4ukIae5e1b3AQK8KWa9WtotY4hyx4SZSeGVq7pDhI6OeYDOW7gZzZHkSE0YVyS60Nc4UzTU+vlew2U2M5nw/4Zm0rbve4GjqIQhtIJpnrXqUE+yv5JCJaCJCZLjfX7VgxKVj3fAEY/jTbiObbdc5ox+nD2cqQfNjomP1hqiKaDL60BqY9QZ7krwP3ux7t+IM/gBg+PQfbRzXDAAAAABJRU5ErkJggg=="
                />
              </button>
              <button>
                <img src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAB4AAAAeCAYAAAA7MK6iAAAAAXNSR0IArs4c6QAAAhdJREFUSEvl1jFo1GAUB/D/y5dcHcTFURClooKnvVzTQ+hURaioCELrokuhmy5OFVfB4iII3exUpyuFLg6iQhFK0eS8nLoIUtHFTQenXr7vnkRz1bskl+R6oYI3HeHj/d5735eXj7BLP9olF/8wXJ0SOPLlWMHw9GbxzTsQOLJLDK3wvlxseobEx4MfML2senUztmLx1jrPLdwl4CQAIwiyBcYrYm1Oll9v+M/0ujXOhHkAFQCFYJ0HQoMU3ZZl+3lUAmHYGTV0neYZuJWQ8QP+ndCNhHX35fe9dzCxJv9eF4KFa60AuDLYQ8dVVapdjYWFO3YN4KXBokE05mll1pbbsf9UXJ0S4ujmZ4AO5AIDm6rkDIdgvVE+w6y9yAn9FVZjqnimbfv/tyvW3NGbBHqYJwzQdVWyH3fDcwS6lytMPKtGao86YOFaMwAWc4WZLyqz9qQDRv30IUHyU46wp/YM7cfx9R+dMADRsFbBuJwTvqBKzvaw6RwgjcphwS0XwL4B41+VYRRxYuNb+D0OngSv1VN/DA8Il6TRWXnKftlzZAaD/xwT/EPQ/jj0m4NHjAvSdJ51B4j9Oul1a6d4LBo6XN1Z7QDviSbCfbY9EU0FZ8S3iHEpak9T73EfbU+Npq64nUSPPffRSWk6a2mPf+ZbZgSeGc1ccUTlrayVxk6utK3yb6HE1JQjdl+Xh8ytTptY0rr/D/4JCozHHxT1duYAAAAASUVORK5CYII=" />
              </button>
              <button>
                <img src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAB4AAAAeCAYAAAA7MK6iAAAAAXNSR0IArs4c6QAAAfpJREFUSEvl1j2LE1EUh/HnDGbOFUEzCVYiCDbaWdiIhdlOl0UFrQQbG7WzV3RX9APYKBZ2whZu4xsiCKYUBLESBK3cBYvNTCRF5kaSI1ktdmNediabrODtBub+f3MO3DlX2KYl2+Tyb8J11YMmsj9zV9L0YwT1BIo4dyQwW97j/Zf1OQMrNpBE9RNwKCssIjNRmlYT5ypm9ra7X+BN0ftZgZ9/nvvHxqpzwPOs6FpoH3gtR+RiKU0fj4KrwImthMXsVtRq3R4I1wuFo50geJ8HHVaxiSyU03R+IJyoLhmcmyqcOHfAzL4CwVThWPUBcCUvmqvVdYg6qt+BcKpwzbkFMbs5Dpq54m+wc5dzK5hFU4Vrzl0Ss0fjopkrrjk33z3g/w8ch+F1RO5MsmLMbpRarbsb/lyJ6mmDp5OEBc5E3j/bABsEddWHBqeAfeN8QJ/ptCLwquj9ZYHO0Ok0DI5VrwL3B71jQXCs3Gy+G5aR6+oTq3aHe6VfsMG9svfXRnUsM/wDSm3V1d+Xip4lslhK0wuj0FytjlW7A6Q7SHrXi8j7swLticCJ6hOD8z3h1cj7kwJ+M2jeil8Cs+uAD23vK3uhsVk0F5w4N2Nmr4EC8HlHGB7f3WjUsqC54O6m1TA8HIjMWRAslpvN5axobjgP9NcB2IqQPBm/AGzUNy5GvcT1AAAAAElFTkSuQmCC" />
              </button>
            </div>
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
          <div className="RedesDiputado">
            {diputadoPerfil.facebook && ( // Verifica si hay un enlace de Facebook disponible
              <div className="redSocial">
                <a
                  href={diputadoPerfil.facebook}
                  target="_blank"
                  rel="noopener noreferrer"
                >
                  <img src={Facebook} alt="Face" />
                </a>
              </div>
            )}
            {diputadoPerfil.instagram && ( // Verifica si hay un enlace de Instagram disponible
              <div className="redSocial">
                <a
                  href={diputadoPerfil.instagram}
                  target="_blank"
                  rel="noopener noreferrer"
                >
                  <img src={Instagram} alt="Insta" />
                </a>
              </div>
            )}
            {diputadoPerfil.twitter && ( // Verifica si hay otro enlace disponible
              <div className="redSocial">
                <a
                  href={diputadoPerfil.twitter}
                  target="_blank"
                  rel="noopener noreferrer"
                >
                  <img src={X} alt="X" />
                </a>
              </div>
            )}
          </div>
        </div>
        <div>
          <ul className="perfilBotones">
            <button onClick={openComentarios}>COMENTARIOS</button>
            <button onClick={openAsistencia}>ASISTENCIA</button>
            <button onClick={openVotaciones}>VOTACIONES</button>
          </ul>
        </div>
      </div>
      {user ? (
        <div className="Comentarios">
          <form className="Box" onSubmit={(e) => handleLogin(e)} method="post">
            <textarea
              rows="5"
              cols="150"
              className="inputperfil"
              type="text"
              value={comentario}
              onChange={(e) => setComentario(e.target.value)}
            ></textarea>
            <button className="enviar-comentario" type="submit">
              Enviar
            </button>
          </form>
        </div>
      ) : (
        <p className="comentario-condicional">
          Inicia sesión para agregar un comentario
        </p>
      )}

      <ModalComentario
        idComentarios={idDiputado}
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
