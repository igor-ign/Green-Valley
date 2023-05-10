import { Routes, Route } from "react-router-dom";
import { ROUTES } from "./app-constants/routes";
import { Login } from "./pages/login";
import "./index.css";

function AppRoutes() {
  return (
    <div className="app-routes">
      <Routes>
        <Route path={ROUTES.LOGIN} element={<Login />} />
        <Route path={ROUTES.DASHBOARD} element={<div>Dashboard page</div>} />
      </Routes>
    </div>
  );
}

function App() {
  return <AppRoutes />;
}

export default App;
