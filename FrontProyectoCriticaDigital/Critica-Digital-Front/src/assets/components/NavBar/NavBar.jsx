import "./NavBar.css";

function NavBar() {
  return (
    <div className="navbar">
      <div className="nav-logo">
        <img src={logo} alt="logo" />
        <p>EnLinea</p>
      </div>
      <ul className="nav-menu">
        <li>
          <Link
            to="/"
            style={{ textDecoration: "none", color: "inherit", height: "50%" }}
            onClick={() => setMenu("tienda")}
          >
            Tienda {menu === "tienda" ? <hr /> : <></>}
          </Link>
        </li>
        <li>Hombre {menu === "hombre" ? <hr /> : <></>}</li>
        <li onClick={() => setMenu("mujer")}>
          Mujer {menu === "mujer" ? <hr /> : <></>}
        </li>
        <li onClick={() => setMenu("niños")}>
          Niños {menu === "niños" ? <hr /> : <></>}
        </li>
      </ul>
    </div>
  );
}

export default NavBar;
