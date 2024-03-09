import { useState } from "react";
import Perfil from "./assets/components/Perfil/Perfil";
import Preferencias from "./assets/components/Preferencias/Preferencias";
import Privacidad from "./assets/components/Privacidad/Privacidad";

import profile from "./assets/components/imagenes/Image20240307164419.png";
import "./UserProfile.css";

function UserProfile() {
  const [vista, setVista] = useState("perfil");

  const cambiarVista = (nuevaVista) => {
    setVista(nuevaVista);
  };

  return (
    <>
      <div className="data">
        <img src={profile} />
        <h4>User Name</h4>
      </div>
      <div className="profile">
        <ul className="profileButtons">
          <button onClick={() => cambiarVista("perfil")}>Perfil</button>
          <button onClick={() => cambiarVista("preferencias")}>
            Preferencias
          </button>
          <button onClick={() => cambiarVista("privacidad")}>Privacidad</button>
        </ul>
      </div>

      {vista === "perfil" && <Perfil />}
      {vista === "preferencias" && <Preferencias />}
      {vista === "privacidad" && <Privacidad />}
    </>
  );
}

export default UserProfile;
