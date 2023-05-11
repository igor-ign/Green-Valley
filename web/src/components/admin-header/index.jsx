import { useState } from "react";
import { OPENED_NAV, CLOSED_NAV } from "../../statics";
import "./style.scss";

export function AdminHeader({ title }) {
  const [isNavOpen, setIsNavOpen] = useState(false);

  return (
    <header className="header">
      <button className="nav__button" onClick={() => setIsNavOpen(!isNavOpen)}>
        <img
          src={isNavOpen ? CLOSED_NAV : OPENED_NAV}
          alt="Open and close navigation"
        />
      </button>
      <nav className={`${isNavOpen ? "nav--open" : "nav--closed"}`}></nav>
      <h1 className="header__title">{title}</h1>
    </header>
  );
}
