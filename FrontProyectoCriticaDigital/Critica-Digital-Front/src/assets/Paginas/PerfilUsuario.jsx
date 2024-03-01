import React from "react";
import "./PerfilUsuario.css";

export default function PerfilUsuario() {
  return (
    <div className="contenedor">
      <h1>CREA TU CUENTA</h1>
      <div className="preguntas">
        <form class="formulario" action="formulario" method="post">
          <label class="pregunta">
            Nombre
            <input type="text" name="Nombre" required />
          </label>
          <label class="pregunta">
            Primer apellido
            <input type="text" name="primerapellido" required />
          </label>
          <label class="pregunta">
            Segundo apellido
            <input type="text" name="segundoapellido" required />
          </label>
          <label class="pregunta">
            Correo electrónico
            <input type="mail" name="correo" required />
          </label>
          <label class="pregunta">
            Indica tu región:
            <select name="region">
              <option value="1">Región Metropolitana de Santiago</option>
              <option value="2">Arica y Parinacota</option>
              <option value="3">Tarapacá</option>
              <option value="4">Antofagasta</option>
              <option value="5">Atacama</option>
              <option value="6">Coquimbo</option>
              <option value="7">Valparaíso</option>
              <option value="8">O'Higgins</option>
              <option value="9">Maule</option>
              <option value="10">Ñuble</option>
              <option value="11">Biobío</option>
              <option value="12">La Araucanía</option>
              <option value="13">Los Ríos</option>
              <option value="14">Los Lagos</option>
              <option value="15">
                Aysén del General Carlos Ibáñez del Campo
              </option>
              <option value="16">Magallanes y de la Antártica Chilena</option>
            </select>
          </label>
          <label class="pregunta">
            Comuna
            <input type="text" name="comuna" required />
          </label>
        </form>
      </div>
      <button>CREAR CUENTA</button>
    </div>
  );
}
