import { useState } from "react";
import "./App.css";
import NavBar from "./assets/components/NavBar/NavBar";
import Cards from "./assets/components/Cards/Cards";
import diputado from "./assets/components/DatosJson/diputados";

function App() {
  return (
    <>
      <NavBar />
      <Cards data={diputado} titulo="Diputados" />
    </>
  );
}

export default App;
