import { useNavigate } from "react-router-dom";
import { useDispatch } from "react-redux";
import { ExitToApp } from "@material-ui/icons";
import { ROUTES } from "../../../../app-constants";
import { NavbarItems } from "../navbar-items";
import { logout } from "../../../../slices/userSlice";
import "./style.scss";

export function AdminNavbar({ isOpen }) {
  const dispatch = useDispatch();
  const navigate = useNavigate();

  function handleLogout() {
    dispatch(logout());
    navigate(ROUTES.LOGIN);
  }

  return (
    <nav className={`${isOpen ? "nav--open" : "nav--closed"}`}>
      <ul className="nav__items">
        <NavbarItems />
      </ul>
      <button className="nav__logout" onClick={handleLogout}>
        <div className="logout__icon">
          <ExitToApp />
        </div>
        <h3 className="logout__text">Logout</h3>
      </button>
    </nav>
  );
}
