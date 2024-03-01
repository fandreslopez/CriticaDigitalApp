import React from "react";
import "./style.css";
import { useState, useEffect } from "react";
import axios from "axios";

function Login({ setUser }) {
  const [ruta, setRute] = useState("login");
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");

  const handleLogin = (event) => {
    event.preventDefault();
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
      <div className="container-login">
        {ruta === "login" ? (
          <>
            <div className="contenedor">
              <button onClick={() => setRute("crear cuenta")}>
                Crea tu cuenta
              </button>
              <form
                className="formulario"
                onSubmit={(event) => handleLogin(event)}
                method="post"
              >
                <label className="pregunta">
                  Username
                  <input
                    type="text"
                    name="text"
                    required
                    id="text"
                    value={username}
                    onChange={(e) => setUsername(e.target.value)}
                  />
                </label>
                <label className="pregunta">
                  Password
                  <input
                    type="password"
                    name="password"
                    required
                    id="password"
                    value={password}
                    onChange={(e) => setPassword(e.target.value)}
                  />
                </label>
                <button type="submit">Login</button>
              </form>
            </div>
          </>
        ) : (
          <>
            <div className="contenedor">
              <button onClick={() => setRute("login")}>Login</button>
              <h1>CREA TU CUENTA</h1>
              <div className="preguntas">
                <form className="formulario" action="formulario" method="post">
                  <label className="pregunta">
                    Nombre
                    <input type="text" name="Nombre" required />
                  </label>
                  <label className="pregunta">
                    Primer apellido
                    <input type="text" name="primerapellido" required />
                  </label>
                  <label className="pregunta">
                    Segundo apellido
                    <input type="text" name="segundoapellido" required />
                  </label>
                  <label className="pregunta">
                    Correo electrónico
                    <input type="mail" name="correo" required />
                  </label>
                  <label className="pregunta">
                    Indica tu región:
                    <select name="region">
                      <option value="1">
                        Región Metropolitana de Santiago
                      </option>
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
                      <option value="16">
                        Magallanes y de la Antártica Chilena
                      </option>
                    </select>
                  </label>
                  <label className="pregunta">
                    Comuna
                    <input type="text" name="comuna" required />
                  </label>
                </form>
              </div>
              <button>CREAR CUENTA</button>
                 
            </div>
          </>
        )}
      </div>
    </>
  );
}

export default Login;
