import { useNavigate } from "react-router-dom";
import "./style.scss";

export function NavbarItem({ itemKey, path, name, icon }) {
  const navigate = useNavigate();

  return (
    <li key={itemKey} className="nav__item">
      <button className="item__button" onClick={() => navigate(path)}>
        <div className="item__icon">{icon}</div>
        <h3 className="item__name">{name}</h3>
      </button>
    </li>
  );
}
