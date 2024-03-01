/* import diputado from "../components/DatosJson/diputados"; */
import { useEffect, useState } from "react";
import Cards from "../components/Cards/Cards";
import axios from "axios";

function ListaDiputado() {
  const [diputados, setDiputados] = useState([]);

  useEffect(() => {
    const token = JSON.parse(localStorage.getItem("user"));
    console.log(token.token);
    axios
      .get("http://localhost:8080/api/diputados/lista")
      .then((res) => console.log(res.data))
      .catch((error) => console.log(error));
  }, []);

  return (
    <>
      <Cards data={diputados} titulo="Diputados" />
    </>
  );
}

export default ListaDiputado;
