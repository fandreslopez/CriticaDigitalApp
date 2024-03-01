import "./NavBar.css";
import img from "../imagenes/Image20240227160933.png";
import { Link } from "react-router-dom";

function NavBar() {
  return (
    <div className="navbar">
      <div className="nav-logo">
        <img src={img} />
      </div>
      <ul className="nav-menu">
        <li>
          <Link
            style={{ textDecoration: "none", color: "inherit" }}
            to="/"
            onClick={() => setMenu("inicio")}
          >
            Inicio
          </Link>
        </li>
        <li>
          <Link
            style={{ textDecoration: "none", color: "inherit" }}
            to="/diputados"
            onClick={() => setMenu("diputados")}
          >
            Diputado
          </Link>
        </li>
        <li>Actividad</li>
        <li>Perfil</li>
      </ul>
    </div>
  );
}

export default NavBar;
