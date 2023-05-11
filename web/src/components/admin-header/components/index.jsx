import { useNavigate } from "react-router-dom";
import { useDispatch } from "react-redux";
import { ExitToApp } from "@material-ui/icons";
import { ADMIN_NAVBAR_ITEMS, ROUTES } from "../../../app-constants";
import { logout } from "../../../slices/userSlice";
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
        {ADMIN_NAVBAR_ITEMS.map((item) => {
          return (
            <li key={item.id} className="nav__item">
              <button
                className="item__button"
                onClick={() => navigate(item.path)}
              >
                <div className="item__icon">{item.icon}</div>
                <h3 className="item__name">{item.name}</h3>
              </button>
            </li>
          );
        })}
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
