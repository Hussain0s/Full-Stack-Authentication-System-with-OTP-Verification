import React, { useState, useEffect } from "react";
import { useNavigate, useLocation } from "react-router-dom"; 
import axios from "axios";
import "../styles/VerifyOtp.css";

const VerifyOtp = () => {
  const [email, setEmail] = useState("");
  const [otp, setOtp] = useState("");
  const [message, setMessage] = useState(""); 
  const [isError, setIsError] = useState(false);

  const navigate = useNavigate();
  const location = useLocation();

  // ✅ Load email from URL query parameter (coming from ForgotPassword page)
  useEffect(() => {
    const params = new URLSearchParams(location.search);
    const emailFromQuery = params.get("email");

    if (emailFromQuery) {
      setEmail(emailFromQuery);
    } else {
      setMessage("Invalid access. Please restart the Forgot Password process.");
      setIsError(true);
    }
  }, [location]);

  // ✅ Handle OTP verification
  const handleVerifyOtp = async (e) => {
    e.preventDefault(); // ✅ Prevent form refresh
    setMessage("");
    setIsError(false);

    if (!otp.trim()) {
        setMessage("⚠️ Please enter the OTP.");
        setIsError(true);
        return;
    }

    try {
      const response = await axios.post(
        "http://localhost:8080/api/auth/verify-otp",
        { email, otp },
        { headers: { "Content-Type": "application/json" } }
      );

      setMessage(response.data.message || "✅ OTP verified successfully!");
      setIsError(false);

      // ✅ Save verified email & OTP into sessionStorage
      sessionStorage.setItem("email", email);
      sessionStorage.setItem("otp", otp);

      // ✅ Redirect to Reset Password page
      setTimeout(() => navigate("/reset-password"), 2000);
    } catch (error) {
      console.error("❌ OTP Verification Error:", error);
      setMessage(error.response?.data?.message || "⚠️ Invalid OTP. Please try again.");
      setIsError(true);
    }
  };

  return (
    <div className="verify-otp-container">
      <div className="verify-otp-box">
        <h2>🔑 Verify OTP</h2>
        <form onSubmit={handleVerifyOtp}>
          <input type="email" value={email} readOnly placeholder="📧 Email" />
          <input type="text" placeholder="🔢 Enter OTP" value={otp} onChange={(e) => setOtp(e.target.value)} required />
          <button type="submit">✅ Verify OTP</button>
        </form>

        {message && <p className={`message ${isError ? "error" : "success"}`}>{message}</p>}

        <p className="back-to-forgot" onClick={() => navigate("/forgot-password")}>
          🔄 Back to Forgot Password
        </p>
      </div>
    </div>
  );
};

export default VerifyOtp;
