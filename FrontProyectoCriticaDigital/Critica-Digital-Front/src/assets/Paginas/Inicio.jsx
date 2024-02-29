import React from "react";
import "./Inicio.css";
import img from "../components/imagenes/104490_apple_icon.svg";
import imggoogle from "../components/imagenes/7123025_logo_google_g_icon.svg";

export default function Inicio() {
  return (
    <div className="esquema">
      <h1>DONDE TU OPINIÓN RESUENA, DONDE TU IMPACTO CUENTA.</h1>
      <aside>
        <div className="registro">
          <p>ACTÚA AHORA</p>
          <button>
            <img className="img" src={imggoogle}></img>
            REGISTRATE CON GOOGLE
          </button>
          <button>
            <img className="img" src={img}></img> REGISTRATE CON APPLE
          </button>
          <p>O</p>
          <button>CREAR CUENTA</button>
          <p>¿YA TIENES UNA CUENTA?</p>
          <button id="btn-inicio">INICIAR SESIÓN</button>
        </div>
      </aside>
    </div>
  );
}
