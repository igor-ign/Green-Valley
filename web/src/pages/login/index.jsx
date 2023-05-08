import "./style.scss";

export function Login() {
  return (
    <form className="login-form">
      <div className="input-container">
        <label htmlFor="login">Login</label>
        <input type="text" id="login" placeholder="admin@gmail.com" />
      </div>
      <div className="input-container">
        <label htmlFor="login">Password</label>
        <input type="text" id="password" placeholder="Your password" />
      </div>

      <button className="submit-button">Log in</button>
    </form>
  );
}
