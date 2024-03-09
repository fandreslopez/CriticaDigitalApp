import { useState } from "react";
import "./Perfil.css";

import EditarPerfil from "./components/EditarPerfil/EditarPerfil";
import Datos from "./components/Datos/Datos";
import CambiarContrasena from "./components/CambiarContrasena/CambiarContrasena";
import EliminarCuenta from "./components/EliminarCuenta/EliminarCuenta";

const Perfil = () => {
  const [vista, setVista] = useState("datos");

  const [datos, setDatos] = useState({
    nombre: "",
    primerApellido: "",
    segundoApellido: "",
    fechaNacimiento: "",
    genero: "",
    email: "",
    region: "",
    comuna: "",
    distrito: "",
  });

  const cambiarVista = (nuevaVista) => {
    setVista(nuevaVista);
  };

  const actualizarDatos = (nuevosDatos) => {
    setDatos(nuevosDatos);
  };

  return (
    <>
      {vista === "datos" && (
        <>
          <Datos datos={datos} />

          <div>
            <ul className="changeButtons">
              <button onClick={() => cambiarVista("cambiar-contrasena")}>
                Cambiar Contraseña
              </button>
              <button onClick={() => cambiarVista("eliminar-cuenta")}>
                Eliminar Cuenta
              </button>
              <button onClick={() => cambiarVista("editar-perfil")}>
                Editar Perfil
              </button>
            </ul>
          </div>
        </>
      )}

      {vista === "cambiar-contrasena" && <CambiarContrasena />}
      {vista === "eliminar-cuenta" && <EliminarCuenta />}
      {vista === "editar-perfil" && (
        <EditarPerfil
          actualizarDatos={actualizarDatos}
          cambiarVista={cambiarVista}
        />
      )}
    </>
  );
};

export default Perfil;
