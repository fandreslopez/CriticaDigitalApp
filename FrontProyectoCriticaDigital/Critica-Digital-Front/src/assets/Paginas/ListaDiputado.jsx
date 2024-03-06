import { useEffect, useState } from "react";
import Cards from "../components/Cards/Cards";
import axios from "axios";

function ListaDiputado({ diputados }) {
  return (
    <>
      <Cards data={diputados} />
    </>
  );
}

export default ListaDiputado;
