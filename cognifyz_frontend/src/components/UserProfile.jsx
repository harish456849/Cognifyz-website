import { useNavigate } from "react-router-dom";

function UserProfile() {
    const navigate = useNavigate();

    const handleLogout = () => {
        localStorage.removeItem("token");
        navigate("/login");
    };

    return (
        <div className="container mt-4">
            <h2>User Profile</h2>
            {/* Display profile details here */}
            <button onClick={handleLogout} className="btn btn-danger mt-3">
                Logout
            </button>
        </div>
    );
}

export default UserProfile;