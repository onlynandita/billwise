import { BrowserRouter, Routes, Route } from "react-router-dom";

import Home from "../pages/Home";
import Upload from "../pages/Upload";
import Dashboard from "../pages/Dashboard";
import NotFound from "../pages/NotFound";

function AppRouter() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/upload" element={<Upload />} />
        <Route path="/dashboard" element={<Dashboard />} />
        <Route path="*" element={<NotFound />} />
      </Routes>
    </BrowserRouter>
  );
}

export default AppRouter;