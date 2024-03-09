import { useState, useEffect } from "react";
import "./App.css";
import NavBar from "./assets/components/NavBar/NavBar";
import Inicio from "./assets/Paginas/Inicio";
import ListaDiputado from "./assets/Paginas/ListaDiputado";
import PerfilDiputado from "./assets/Paginas/PerfilDiputado";
import { Routes, Route, useLocation } from "react-router-dom";
import axios from "axios";
import UserProfile from "./index";

/* axios.defaults.headers.common["Authorization"] = `Bearer ${
  JSON.parse(localStorage.getItem("user")).token
}`; */

function App() {
  const [diputados, setDiputados] = useState([]);
  const [user, setUser] = useState(null);

  useEffect(() => {
    const usuario = JSON.parse(localStorage.getItem("user"));
    if (usuario) {
      setUser(usuario);
    } else setUser(null);
  }, []);

  useEffect(() => {
    axios
      .get("http://localhost:8080/api/diputados/lista")
      .then((res) => setDiputados(res.data))
      .catch((error) => console.log(error));
  }, []);

  return (
    <>
      <NavBar userper={user} />
      <Routes>
        <Route path="/" element={<Inicio setUser={setUser} />}></Route>
        <Route
          path="/diputados"
          element={<ListaDiputado diputados={diputados} />}
        ></Route>
        <Route
          path="/perfil/:idDiputado"
          element={
            <PerfilDiputado
              diputado={diputados}
              user={user}
              titulo="PerfilDiputado"
            />
          }
        ></Route>
        {user && <Route path="/perfil" element={<UserProfile />}></Route>}
      </Routes>
    </>
  );
}

export default App;
