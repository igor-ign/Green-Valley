import { Routes, Route } from "react-router-dom";
import { ROUTES } from "./app-constants/routes";
import "./index.css";

function AppRoutes() {
  return (
    <div className="app-routes">
      <Routes>
        <Route path={ROUTES.LOGIN} />
      </Routes>
    </div>
  );
}

function App() {
  return <AppRoutes />;
}

export default App;
