import { Routes, Route } from "react-router-dom";
import { ROUTES } from "./app-constants";
import { Login, AdminHouses } from "./pages";
import "./index.css";

function AppRoutes() {
  return (
    <div className="app-routes">
      <Routes>
        <Route path={ROUTES.LOGIN} element={<Login />} />
        <Route path={ROUTES.DASHBOARD} element={<AdminHouses />} />
      </Routes>
    </div>
  );
}

function App() {
  return <AppRoutes />;
}

export default App;
