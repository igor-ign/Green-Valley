import { useState } from "react";
import { OPENED_NAV, CLOSED_NAV } from "../../statics";
import { AdminNavbar } from "./components/admin-navbar";
import "./style.scss";

export function AdminHeader({ title }) {
  const [isNavOpen, setIsNavOpen] = useState(false);

  return (
    <header className="header">
      <button
        className={`nav__button ${isNavOpen ? "open" : "closed"}`}
        onClick={() => setIsNavOpen(!isNavOpen)}
      >
        <img
          src={isNavOpen ? CLOSED_NAV : OPENED_NAV}
          alt="Open and close navigation"
        />
      </button>
      <AdminNavbar isOpen={isNavOpen} />
      <h1 className="header__title">{title}</h1>
    </header>
  );
}
