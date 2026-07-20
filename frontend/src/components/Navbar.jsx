import { Link, useLocation } from "react-router-dom";
import { Zap } from "lucide-react";

function Navbar() {
  const location = useLocation();

  const isActive = (path) =>
    location.pathname === path
      ? "text-blue-600 font-semibold"
      : "text-gray-600 hover:text-blue-600";

  return (
    <nav className="sticky top-0 z-50 bg-white/90 backdrop-blur-md shadow-md">
      <div className="max-w-7xl mx-auto px-6 py-4 flex justify-between items-center">

        <Link
          to="/"
          className="flex items-center gap-2 text-3xl font-extrabold text-blue-600"
        >
          <Zap size={32} />
          BillWise
        </Link>

        <div className="flex gap-8 text-lg">
          <Link className={isActive("/")} to="/">
            Home
          </Link>

          <Link className={isActive("/upload")} to="/upload">
            Upload
          </Link>

          <Link className={isActive("/dashboard")} to="/dashboard">
            Dashboard
          </Link>
        </div>

      </div>
    </nav>
  );
}

export default Navbar;