import { useState } from "react";
import { useNavigate } from "react-router-dom";

function UserForm() {
    const navigate = useNavigate();

    const [name, setName] = useState("");
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [confirmPassword, setConfirmPassword] = useState("");
    const [error, setError] = useState("");
    
    const handleSubmit = async (event) => {

        event.preventDefault();
        setError("");
        if(!name.trim()){
            setError("Name is required");
            return;
        }
        if(!email.trim()){
            setError("Email is required");
            return;
        }
        if (password !== confirmPassword) {
            setError("Passwords do not match");
            return;
        }
        if(password.length < 6) {
            setError("Password must be at least 6 characters long");
            return;
        }

        const user = {
            name,
            email,
            password
        };
        //const credentials = btoa(`Harish:hari@123`);    // Encode the username and password in Base64
    // Encode the username and password in Base64

        try {

            const response = await fetch(
                "http://localhost:7070/api/create",
                {
                    method: "POST",
                    headers: {
                        "Content-Type": "application/json",
                       // "Authorization": `Basic ${credentials}`
                         //"Authorization": `Bearer ${token}`
                    },
                    
                    body: JSON.stringify(user)
                }
            );
            if(!response.ok) {
                throw new Error("Registration failed");
            }

            const data = await response.json();

            console.log(data);
            localStorage.setItem("token", data.token);

            alert("User registered successfully!");
            navigate("/Login");
            setName("");
            setEmail("");
            setPassword("");
            setConfirmPassword("");

        } catch (error) {

            console.error(error);
            alert("Something went wrong");

        }
    };

   return (
  <div className="container py-5">
    <div className="row justify-content-center">

      <h2 className="text-center mb-2">
        Create Account
      </h2>

      <p className="text-center text-muted mb-4">
        Register for the Cognifyz application
      </p>

      {error && (
        <div className="alert alert-danger">
          {error}
        </div>
      )}

      <form onSubmit={handleSubmit}>

        <div className="mb-3">
          <label className="form-label">
            Full Name
          </label>

          <input
            type="text"
            className="form-control"
            value={name}
            onChange={(e) => setName(e.target.value)}
            placeholder="Enter your name"
          />
        </div>

        <div className="mb-3">
          <label className="form-label">
            Email
          </label>

          <input
            type="email"
            className="form-control"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            placeholder="Enter your email"
          />
        </div>

        <div className="mb-3">
          <label className="form-label">
            Password
          </label>

          <input
            type="password"
            className="form-control"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            placeholder="Enter password"
          />
        </div>

        <div className="mb-4">
          <label className="form-label">
            Confirm Password
          </label>

          <input
            type="password"
            className="form-control"
            value={confirmPassword}
            onChange={(e) => setConfirmPassword(e.target.value)}
            placeholder="Confirm password"
          />
        </div>

        <button
          type="submit"
          className="btn btn-dark w-100 register-btn"
        >
          Register
        </button>

      </form>
    </div>
  </div>
);
}

export default UserForm;