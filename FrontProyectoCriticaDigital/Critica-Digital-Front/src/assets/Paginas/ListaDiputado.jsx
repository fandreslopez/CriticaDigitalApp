import diputado from "../components/DatosJson/diputados";
import Cards from "../components/Cards/Cards";

function ListaDiputado() {
  return (
    <>
      <Cards data={diputado} titulo="Diputados" />
    </>
  );
}

export default ListaDiputado;
