import "./NavBar.css";
import img from "../imagenes/Logo temporal.png";
function NavBar() {
  return (
    <div className="navbar">
      <div className="nav-logo">
        <img src="logo" alt="logo" />
      </div>
      <ul className="nav-menu">
        <li>Home </li>
        <li>Diputado </li>
        <li>Contacto</li>
        <li>Registro</li>
      </ul>
    </div>
  );
}

export default NavBar;
