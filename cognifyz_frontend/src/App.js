import { BrowserRouter as Router, Routes, Route, Navigate, Link } from "react-router-dom";
import Login from "./pages/Login";
import UserForm from "./components/UserForm";
import UserProfile from "./components/UserProfile";
import ProtectedRoute from "./components/ProtectedRoute";
import TaskList from "./pages/TaskList";

function App() {
    return (
        <Router>
            {/* Simple Navigation Bar */}
            <nav className="navbar navbar-expand-lg navbar-dark bg-dark px-4 mb-4">
                <Link className="navbar-brand" to="/">Cognifyz</Link>
                <div className="navbar-nav ms-auto">
                    <Link className="nav-link" to="/login">Login</Link>
                    <Link className="nav-link" to="/register">Register</Link>
                    <Link className="nav-link" to="/profile">Profile</Link>
                </div>
            </nav>

            <Routes>
                {/* Default route redirects to Login */}
                <Route path="/" element={<Navigate to="/login" replace />} />
                
                {/* Public Routes */}
                <Route path="/login" element={<Login />} />
                <Route path="/register" element={<UserForm />} />

                {/* Protected Route */}
                <Route
  path="/profile"
  element={
    <ProtectedRoute>
      <UserProfile />
    </ProtectedRoute>
  }
/>
<Route
  path="/profile/TaskList"
  element={
    <ProtectedRoute>
      <TaskList />
    </ProtectedRoute>
  }
/>

            </Routes>
        </Router>
    );
}

export default App;