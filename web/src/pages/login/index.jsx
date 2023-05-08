import { useState } from "react";
import { INITIAL_FORM, INITIAL_FORM_ERROR } from "./constants";
import { useLogin } from "../../hooks";
import { OPENED_EYE, CLOSED_EYE } from "../../statics";
import "./style.scss";

export function Login() {
  const [form, setForm] = useState(INITIAL_FORM);
  const [isPasswordVisible, setIsPasswordVisible] = useState(false);
  const [showHideIcon, setShowHideIcon] = useState(OPENED_EYE);
  const [formErrors, setFormErrors] = useState(INITIAL_FORM_ERROR);
  const [, setHasErrors] = useState(false);
  const { login } = useLogin();

  async function handleSubmit(e) {
    e.preventDefault();

    if (handleFormErrors()) return;
    try {
      await login(form);
    } catch (err) {
      console.error(err);
    }
  }

  function handleFormErrors() {
    const hasAnyEmptyField =
      form.login.length === 0 || form.password.length === 0;

    setFormErrors({
      LOGIN: form.login.length === 0,
      PASSWORD: form.password.length === 0,
    });
    setHasErrors(hasAnyEmptyField);

    return hasAnyEmptyField;
  }

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

  function renderErrorMessage() {
    const hasErrors = formErrors.LOGIN || formErrors.PASSWORD;

    if (hasErrors) {
      return (
        <div className="error">
          <div className="error__message">
            Please, fill all fields correctly!
          </div>
          <button className="error__close" onClick={() => setFormErrors(false)}>
            X
          </button>
        </div>
      );
    }
  }

  return (
    <form className="form" onSubmit={handleSubmit}>
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

      {renderErrorMessage()}
    </form>
  );
}
