import "./NavBar.css";
import img from "../imagenes/Image20240227160933.png";
import { Link } from "react-router-dom";

function NavBar({ userper }) {
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
        {userper && (
          <li>
            <Link to="/perfil" onClick={() => setMenu("perfil")}>
              Perfil
            </Link>
          </li>
        )}
      </ul>
    </div>
  );
}

export default NavBar;
