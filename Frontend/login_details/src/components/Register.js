import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";
import "../styles/Register.css";

const Register = () => {
  const [formData, setFormData] = useState({
    name: "",
    phone: "",
    email: "",
    password: "",
  });

  const [loading, setLoading] = useState(false);
  const [errorMessage, setErrorMessage] = useState("");
  const navigate = useNavigate();

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleRegister = async (e) => {
    e.preventDefault();
    setLoading(true);
    setErrorMessage("");

    try {
      console.log("Registration Data:", formData);

      const response = await axios.post(
        "http://localhost:8080/api/auth/register",
        formData,
        { headers: { "Content-Type": "application/json" } }
      );

      alert(response.data.message || "✅ Registration successful!");
      navigate("/");
    } catch (error) {
      console.error("Registration Error:", error);
      setErrorMessage(error.response?.data?.message || "⚠️ Registration failed. Try again.");
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="register-wrapper">
      <div className="register-box">
        <h2>📝 Register</h2>
        <form onSubmit={handleRegister}>
          <div className="input-group">
            <input
              type="text"
              name="name"
              placeholder="👤 Full Name"
              value={formData.name}
              onChange={handleChange}
              required
            />
          </div>

          <div className="input-group">
            <input
              type="tel"
              name="phone"
              placeholder="📞 Phone Number"
              value={formData.phone}
              onChange={handleChange}
              required
            />
          </div>

          <div className="input-group">
            <input
              type="email"
              name="email"
              placeholder="📧 Email"
              value={formData.email}
              onChange={handleChange}
              required
            />
          </div>

          <div className="input-group">
            <input
              type="password"
              name="password"
              placeholder="🔒 Password"
              value={formData.password}
              onChange={handleChange}
              required
            />
          </div>

          {errorMessage && <p className="error-message">{errorMessage}</p>}

          <button type="submit" className="register-btn" disabled={loading}>
            {loading ? "⏳ Registering..." : "🚀 Register"}
          </button>

          <p className="login-link">
            Already have an account? <a href="/">Login</a>
          </p>
        </form>
      </div>
    </div>
  );
};

export default Register;
