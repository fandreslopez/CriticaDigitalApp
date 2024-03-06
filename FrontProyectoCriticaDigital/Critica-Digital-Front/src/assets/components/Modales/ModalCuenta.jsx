import React, { useState } from "react";
import "./ModalCuenta.css";
import { useNavigate } from "react-router-dom";
import axios from "axios";

function Modal({ isOpen, onClose }) {
  let navegacion = useNavigate();

  const [user, setUser] = useState({
    username: "",
    email: "",
    password: "",
  });

  const { username, email, password } = user;

  const onInputChange = (e) => {
    setUser({ ...user, [e.target.name]: e.target.value });
  };

  const onSubmit = (e) => {
    console.log(username);
    console.log(password);
    console.log(email);
    console.log("no funciona");
    axios.post("http://localhost:8080/api/auth/registro", {
      username: username,
      email: email,
      password: password,
    });
    navegacion("/");
  };

  return (
    <>
      {isOpen && (
        <div className="modal-overlay" onClick={onClose} role="button">
          <form
            className="form-register"
            onClick={(e) => e.stopPropagation()}
            onSubmit={(e) => onSubmit(e)}
            role="button"
          >
            <h4>Crea tu cuenta</h4>
            <input
              className="controls"
              type="email"
              name="email"
              id="email"
              placeholder="Ingresa tu correo electronico"
              required
              onChange={(e) => onInputChange(e)}
            />
            <input
              className="controls"
              type="text"
              name="username"
              id="username"
              placeholder="Ingresa tu nonmbre de usuario"
              required
              onChange={(e) => onInputChange(e)}
            />
            <input
              className="controls"
              type="password"
              name="password"
              id="password"
              placeholder="Ingresa una contraseña..."
              required
              onChange={(e) => onInputChange(e)}
            />
            <button type="submit" className="boton-crear">
              Crear
            </button>
          </form>
        </div>
      )}
    </>
  );
}

export default Modal;
