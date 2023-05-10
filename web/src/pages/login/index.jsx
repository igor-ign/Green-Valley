import { useState } from "react";
import { useDispatch } from "react-redux";
import { useNavigate } from "react-router-dom";
import { addToken } from "../../slices/userSlice";
import { ROUTES } from "../../app-constants";
import { INITIAL_FORM } from "./constants";
import { useLogin } from "../../hooks";
import { OPENED_EYE, CLOSED_EYE } from "../../statics";
import "./style.scss";

export function Login() {
  const [form, setForm] = useState(INITIAL_FORM);
  const [isPasswordVisible, setIsPasswordVisible] = useState(false);
  const [showHideIcon, setShowHideIcon] = useState(OPENED_EYE);
  const [hasErrors, setHasErrors] = useState(false);
  const { login } = useLogin();
  const dispatch = useDispatch();
  const navigate = useNavigate();

  async function handleSubmit(e) {
    e.preventDefault();

    if (handleFormErrors()) return;
    try {
      const { data } = await login(form);
      dispatch(addToken({ token: data }));
      navigate(ROUTES.DASHBOARD);
    } catch (err) {
      console.error(err);
    }
  }

  function handleFormErrors() {
    const hasAnyEmptyField =
      form.email.length === 0 || form.password.length === 0;

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
    if (hasErrors) {
      return (
        <div className="error">
          <div className="error__message">
            Please, fill all fields correctly!
          </div>
          <button className="error__close" onClick={() => setHasErrors(false)}>
            X
          </button>
        </div>
      );
    }
  }

  return (
    <form className="form" onSubmit={handleSubmit}>
      <div className="form__container">
        <label htmlFor="email" className="input__label">
          E-mail
        </label>
        <input
          type="text"
          id="email"
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
