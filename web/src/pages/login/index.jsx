import { useState } from "react";
import { INITIAL_FORM } from "./constants";
import { OPENED_EYE, CLOSED_EYE } from "../../statics";
import "./style.scss";

export function Login() {
  const [form, setForm] = useState(INITIAL_FORM);
  const [isPasswordVisible, setIsPasswordVisible] = useState(false);
  const [showHideIcon, setShowHideIcon] = useState(OPENED_EYE);

  function handleChange(event) {
    const { id, value } = event.target;

    setForm({ ...form, [id]: value });
  }

  function handlePasswordVisibility() {
    setIsPasswordVisible(!isPasswordVisible);

    isPasswordVisible
      ? setShowHideIcon(OPENED_EYE)
      : setShowHideIcon(CLOSED_EYE);
  }

  return (
    <form className="form">
      <div className="form__container">
        <label htmlFor="login" className="input__label">
          Login
        </label>
        <input
          type="text"
          id="login"
          placeholder="admin@gmail.com"
          onChange={handleChange}
          className="form__input"
        />
      </div>
      <div className="form__container">
        <label htmlFor="password" className="input__label">
          Password
        </label>
        <input
          type={isPasswordVisible ? "text" : "password"}
          id="password"
          placeholder="Your password"
          onChange={handleChange}
          className="form__input"
        />
        <img
          src={showHideIcon}
          alt="show or hide password"
          className="password__visibility"
          onClick={handlePasswordVisibility}
        />
      </div>

      <button className="form__button">Log in</button>
    </form>
  );
}
