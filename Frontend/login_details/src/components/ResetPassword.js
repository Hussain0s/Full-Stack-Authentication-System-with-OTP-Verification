import React, { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";
import "../styles/ResetPassword.css";

const ResetPassword = () => {
  const [email, setEmail] = useState("");
  const [otp, setOtp] = useState("");
  const [newPassword, setNewPassword] = useState("");
  const [message, setMessage] = useState("");
  const [isError, setIsError] = useState(false);
  const [isSubmitting, setIsSubmitting] = useState(false);
  const navigate = useNavigate();

  // ✅ Load email & OTP from sessionStorage (set by VerifyOtp page)
  useEffect(() => {
    const storedEmail = sessionStorage.getItem("email");
    const storedOtp = sessionStorage.getItem("otp");

    if (!storedEmail || !storedOtp) {
      setMessage("Invalid access. Please restart the Forgot Password process.");
      setIsError(true);
    } else {
      setEmail(storedEmail);
      setOtp(storedOtp);
    }
  }, []);

  const handleResetPassword = async (e) => {
    e.preventDefault();
    setMessage("");
    setIsError(false);
    setIsSubmitting(true);

    if (!email || !otp) {
      setMessage("Missing email or OTP. Please restart the Forgot Password process.");
      setIsError(true);
      setIsSubmitting(false);
      return;
    }

    if (newPassword.length < 6) {
      setMessage("Password must be at least 6 characters long.");
      setIsError(true);
      setIsSubmitting(false);
      return;
    }

    const payload = { email, otp, newPassword };

    try {
      const response = await axios.post(
        "http://localhost:8080/api/auth/reset-password",
        payload,
        { headers: { "Content-Type": "application/json" } }
      );

      setMessage(response.data.message || "✅ Password reset successful!");
      setIsError(false);

      // ✅ Clear session storage & redirect after success
      setTimeout(() => {
        sessionStorage.clear();
        navigate("/");
      }, 2000);
    } catch (error) {
      const errorMessage =
        error.response?.data?.message ||
        "⚠️ Failed to reset password. Please try again.";

      setMessage(errorMessage);
      setIsError(true);
    } finally {
      setIsSubmitting(false);
    }
  };

  return (
    <div className="reset-password-container">
      <div className="reset-password-box">
        <h2>🔒 Reset Password</h2>
        <form onSubmit={handleResetPassword}>
          <input type="email" placeholder="📧 Email" value={email} readOnly />
          <input type="text" placeholder="🔢 OTP" value={otp} readOnly />
          <input
            type="password"
            placeholder="🔑 New Password"
            value={newPassword}
            onChange={(e) => setNewPassword(e.target.value)}
            required
          />
          <button type="submit" disabled={isSubmitting}>
            {isSubmitting ? "⏳ Resetting..." : "🔄 Reset Password"}
          </button>
        </form>

        {message && <p className={`message ${isError ? "error" : "success"}`}>{message}</p>}

        <p className="back-to-login" onClick={() => navigate("/")}>
          🔙 Back to Login
        </p>
      </div>
    </div>
  );
};

export default ResetPassword;
