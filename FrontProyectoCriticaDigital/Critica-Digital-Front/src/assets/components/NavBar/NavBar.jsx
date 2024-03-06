import "./NavBar.css";
import img from "../imagenes/Image20240227160933.png";
import { Link } from "react-router-dom";

function NavBar() {
  return (
    <div className="navbar">
      <Link to={"/"}>
        <img src={img} id="logo" />
      </Link>
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
            Diputados
          </Link>
        </li>
        <li>Perfil</li>
      </ul>
    </div>
  );
}

export default NavBar;
