import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";
import "../styles/Login.css";


const Login = () => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [errorMessage, setErrorMessage] = useState(""); 
  const navigate = useNavigate();

  const handleLogin = async (e) => {
    e.preventDefault();
    setErrorMessage("");

    if (!email.trim() || !password.trim()) {
      setErrorMessage("⚠️ Please enter both email and password.");
      return;
    }

    try {
      const response = await axios.post("http://localhost:8080/api/auth/login", {
        email: email.trim(),
        password: password.trim(),
      });

      if (response.data.success) { 
        document.querySelector(".book-container").classList.add("open-book"); // Open Book Animation
        setTimeout(() => {
          navigate("/dashboard");
        }, 1200); // Delay to complete animation
      } else {
        setErrorMessage(response.data.message || "❌ Invalid credentials. Try again.");
      }
    } catch (error) {
      setErrorMessage(error.response?.data?.message || "⚠️ Server error. Try again later.");
    }
  };

  return (
    <div className="book-container">
      <div className="book">
        <div className="login-content">
          <h2>🔑 Login</h2>
          <form onSubmit={handleLogin}>
            <input
              type="email"
              placeholder="📧 Email"
              value={email}
              onChange={(e) => setEmail(e.target.value)}
              required
            />
            <input
              type="password"
              placeholder="🔒 Password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
              required
            />
            <button type="submit">🚀 Login</button>
            {errorMessage && <p className="error-message">{errorMessage}</p>} 
            <p><a href="/forgot-password"> Forgot Password❓</a></p>
            <p>🆕 New user? <a href="/register">Register</a></p>
          </form>
        </div>
      </div>
    </div>
  );
};

export default Login;
