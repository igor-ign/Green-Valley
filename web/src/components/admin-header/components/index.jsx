import { ExitToApp } from "@material-ui/icons";
import { ADMIN_NAVBAR_ITEMS } from "../../../app-constants";
import "./style.scss";

export function AdminNavbar({ isOpen }) {
  return (
    <nav className={`${isOpen ? "nav--open" : "nav--closed"}`}>
      <ul className="nav__items">
        {ADMIN_NAVBAR_ITEMS.map((item) => {
          return (
            <li key={item.id} className="nav__item">
              <button className="item__button">
                <div className="item__icon">{item.icon}</div>
                <h3 className="item__name">{item.name}</h3>
              </button>
            </li>
          );
        })}
      </ul>
      <button className="nav__logout">
        <div className="logout__icon">
          <ExitToApp />
        </div>
        <h3 className="logout__text">Logout</h3>
      </button>
    </nav>
  );
}
