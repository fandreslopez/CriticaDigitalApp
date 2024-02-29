import React from "react";
import Facebook from "../components/imagenes/Facebook.svg";
import Instagram from "../components/imagenes/Instagram.svg";
import X from "../components/imagenes/X.svg";
import { Link, useLocation } from "react-router-dom";
import "./PerfilDiputado.css";

function PerfilDiputado({ diputado }) {
  const urlDiputado = useLocation();
  const probando = urlDiputado.pathname;
  const prueba1 = probando.match(/[0-9]/g);
  const prueba2 = prueba1.join("");
  const diputadoPerfil = diputado.filter(
    (Dip) => Dip.idDiputado === Number(prueba2)
  )[0];
  let imagen = `https://www.camara.cl/img.aspx?prmID=GRCL${prueba2}`;
  console.log(prueba2);
  console.log(diputadoPerfil);

  return (
    <div>
      <div className="perfilDiputado">
        <div className="seccionDiputado">
          <div className="informacionDiputado">
            <div className="imagenDiputado">
              <img src={imagen} className="img" />
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
          <ul className="perfilBotones">
            <button>RESPUESTAS</button>
            <button>DESTACADO</button>
            <button>ASISTENCIA</button>
            <button>VOTACIONES</button>
          </ul>
        </div>
      </div>
      <div className="perfilDiputado">
        <div className="seccionPreguntas">
          Lorem ipsum dolor, sit amet consectetur adipisicing elit. Dolorem
          facilis tempore doloremque minus ex dolores delectus molestiae
          voluptate eos ad qui, modi quo, libero veniam perspiciatis aspernatur
          aliquam consequatur tempora. Tempore voluptatem earum temporibus
          impedit, ratione provident reiciendis atque nulla fuga ea ad
          cupiditate quam quod laboriosam molestias sequi natus quis illum eos
          praesentium consectetur in non. Harum, iure incidunt!
        </div>
        <div></div>
      </div>
    </div>
  );
}

export default PerfilDiputado;
