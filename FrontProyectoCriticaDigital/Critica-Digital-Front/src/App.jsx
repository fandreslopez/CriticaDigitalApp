import { useState } from "react";
import "./App.css";
import NavBar from "./assets/components/NavBar/NavBar";
import Cards from "./assets/components/Cards/Cards";
import diputado from "./assets/components/DatosJson/diputados";
import Inicio from "./assets/Paginas/Inicio";
import ListaDiputado from "./assets/Paginas/ListaDiputado";
import PerfilDiputado from "./assets/Paginas/PerfilDiputado";
import { Routes, Route } from "react-router-dom";

function App() {
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
    </>
  );
}

export default App;
