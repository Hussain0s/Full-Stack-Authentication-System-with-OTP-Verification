import React from "react";
import { Link } from "react-router-dom";
import "../styles/NotFound.css";

function NotFound() {
  return (
    <div className="not-found-container">
      {/* Full-Screen Background YouTube Video */}
      <div className="video-container">
        <iframe 
          src="https://www.youtube.com/embed/GWNrPJyRTcA?autoplay=1&controls=0&loop=1&playlist=GWNrPJyRTcA" 
          title="404 Background Video"
          frameBorder="0"
          allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; fullscreen"
          allowFullScreen
        ></iframe>
      </div>

      <p>The page you are looking for doesn't exist.</p>
      <Link to="/">Go to Login</Link>
    </div>
  );
}

export default NotFound;
