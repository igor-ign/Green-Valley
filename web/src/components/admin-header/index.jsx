import { useState } from "react";
import "./style.scss";

export function AdminHeader({ title }) {
  const [isNavOpen, setIsNavOpen] = useState(false);
  const [openCloseButton, setOpenCloseButton] = useState("");

  function handleOpenCloseModal() {
    setIsNavOpen(!isNavOpen);
    setOpenCloseButton("");
  }
  return (
    <header>
      <button
        className={`${isNavOpen ? "nav__button--open" : "nav__button--closed"}`}
        onClick={handleOpenCloseModal}
      >
        {openCloseButton}
      </button>
      <h1 className="header__title">{title}</h1>
    </header>
  );
}
