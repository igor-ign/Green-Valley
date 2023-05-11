import { ADMIN_NAVBAR_ITEMS } from "../../../app-constants";
import "./style.scss";

export function AdminNavbar({ isOpen }) {
  return (
    <nav className={`${isOpen ? "nav--open" : "nav--closed"}`}>
      <ul className="nav__items">
        {ADMIN_NAVBAR_ITEMS.map((item) => {
          return <div key={item.id}>{item.name}</div>;
        })}
      </ul>
      <div className="nav__logout">Logout</div>
    </nav>
  );
}
