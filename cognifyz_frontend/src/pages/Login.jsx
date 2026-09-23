import { useState } from "react";
import { useNavigate } from "react-router-dom";
import  TaskList from "./TaskList";

function Login() {

    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [message, setMessage] = useState("");
    const [error, setError] = useState("");
    const navigate = useNavigate();

    const handleLogin = async (e) => {
        e.preventDefault();

        setMessage("");
        setError("");

        if (!email || !password) {
            setError("Email and password are required");
            return;
        }

        try {

            const response = await fetch(
                "http://localhost:7070/api/auth/login",
                {
                    method: "POST",
                    headers: {
                        "Content-Type": "application/json"
                    },

                    body: JSON.stringify({
                        email: email,
                        password: password
                    })
                }
            );

            const data = await response.text();

            if (response.ok) {
                localStorage.setItem("token", data);
                setMessage("Login successful! Token saved.");
                navigate("/profile/TaskList");
            } else {
                setError(data);
            }

        } catch (error) {
            console.log(error);
            setError("Unable to connect to server");
        }
    };

    return (
        <div className="container py-5">

            <div className="row justify-content-center">

                <div className="col-12 col-md-6 col-lg-5">

                    <div className="card shadow-lg">

                        <div className="card-body p-4">

                            <h2 className="text-center mb-2">
                                Sign In
                            </h2>

                            <p className="text-center text-muted mb-4">
                                Login to your Cognifyz account
                            </p>

                            {error && (
                                <div className="alert alert-danger">
                                    {error}
                                </div>
                            )}

                            {message && (
                                <div className="alert alert-success">
                                    {message}
                                </div>
                            )}

                            <form onSubmit={handleLogin}>

                                <div className="mb-3">

                                    <label className="form-label">
                                        Email
                                    </label>

                                    <input
                                        type="email"
                                        className="form-control"
                                        placeholder="Enter your email"
                                        value={email}
                                        onChange={(e) =>
                                            setEmail(e.target.value)
                                        }
                                    />

                                </div>

                                <div className="mb-4">

                                    <label className="form-label">
                                        Password
                                    </label>

                                    <input
                                        type="password"
                                        className="form-control"
                                        placeholder="Enter your password"
                                        value={password}
                                        onChange={(e) =>
                                            setPassword(e.target.value)
                                        }
                                    />

                                </div>

                                <button
                                    type="submit"
                                    className="btn btn-dark w-100"
                                >
                                    Sign In
                                </button>

                            </form>

                        </div>

                    </div>

                </div>

            </div>

        </div>
    );
}

export default Login;