import React from "react";
import "./ModalCuenta.css";
import { useState } from "react";
import axios from "axios";

function ModalLogin({ isAbierto, onCerrado, setUser, setIsModalAbierto }) {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");

  const handleLogin = (e) => {
    setIsModalAbierto(false);
    e.preventDefault();
    console.log(username);
    console.log(password);
    axios
      .post("http://localhost:8080/api/auth/login", {
        username: username,
        password: password,
      })
      .then((resp) => {
        setUser(resp.data);
        localStorage.setItem("user", JSON.stringify(resp.data));
      })
      .catch((error) => console.log(error));
  };

  return (
    <>
      {isAbierto && (
        <div className="modal-overlay" onClick={onCerrado} role="button">
          <form
            className="form-register"
            onSubmit={(e) => handleLogin(e)}
            onClick={(e) => e.stopPropagation()}
            method="post"
          >
            <label className="etiquetas-ingreso">Nombre de usuario</label>
            <input
              className="controls"
              type="text"
              name="text"
              required
              id="text"
              value={username}
              onChange={(e) => setUsername(e.target.value)}
            />

            <label className="etiquetas-ingreso">Contraseña</label>
            <input
              className="controls"
              type="password"
              name="password"
              required
              id="password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
            />

            <button type="submit" className="boton-crear">
              Ingresar
            </button>
          </form>
        </div>
      )}
    </>
  );
}

export default ModalLogin;
