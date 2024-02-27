import diputado from "../components/DatosJson/diputados";

function ListaDiputado() {
  return (
    <>
      <Cards data={diputado} titulo="Diputados" />
    </>
  );
}

export default ListaDiputado;
