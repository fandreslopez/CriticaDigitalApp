import { useState, useEffect } from "react";
import "./App.css";
import NavBar from "./assets/components/NavBar/NavBar";
import Cards from "./assets/components/Cards/Cards";
import diputado from "./assets/components/DatosJson/diputados";
import Inicio from "./assets/Paginas/Inicio";
import ListaDiputado from "./assets/Paginas/ListaDiputado";
import PerfilDiputado from "./assets/Paginas/PerfilDiputado";
import { Routes, Route } from "react-router-dom";
import Login from "./assets/components/Login/Login";
import axios from "axios";

/* axios.defaults.headers.common["Authorization"] = `Bearer ${
  JSON.parse(localStorage.getItem("user")).token
}`; */

function App() {
  const [user, setUser] = useState(null);

  useEffect(() => {
    const usuario = JSON.parse(localStorage.getItem("user"));
    if (usuario) {
      setUser(usuario);
    } else {
      setUser(null);
    }
  }, []);

  return (
    <>
      <NavBar />
      <Routes>
        <Route path="/" element={<Inicio />}></Route>
        <Route path="/diputados" element={<ListaDiputado />}></Route>
        <Route
          path="/perfil/:idDiputado"
          element={
            <PerfilDiputado diputado={diputado} titulo="PerfilDiputado" />
          }
        ></Route>
      </Routes>
      {!user && <Login setUser={setUser} />}
    </>
  );
}

export default App;
