React Authentication System with OTP Verification

This project is a React-based authentication system that includes features like user registration, login, password recovery (via OTP), and password reset. It is designed to be a simple yet secure way to handle user authentication in a web application.

Features

User Registration: Users can create an account by providing their name, phone number, email, and password.

User Login: Registered users can log in using their email and password.

Forgot Password: Users can request an OTP to reset their password if they forget it.

OTP Verification: Users can verify the OTP sent to their email to proceed with password reset.

Password Reset: Users can reset their password after OTP verification.

404 Not Found Page: A custom 404 page with a YouTube video background for a better user experience.

Technologies Used

Frontend: React, React Router, Axios

Styling: CSS with Glassmorphism and Neon effects

Backend: (Assumed to be a Node.js/Express server based on API endpoints)

Other Libraries: React Router DOM for routing, Axios for API calls

Installation

To run this project locally, follow these steps:

Clone the repository:

git clone https://github.com/your-username/your-repo-name.git
cd your-repo-name

Install dependencies:

npm install

Run the development server:

npm start

Open the app:

The app will be running at http://localhost:3000

Project Structure

/src
  /components
    - Login.js
    - Register.js
    - ForgotPassword.js
    - OTPVerification.js
    - ResetPassword.js
  /styles
    - Login.css
    - Register.css
    - ForgotPassword.css
    - OTPVerification.css
    - ResetPassword.css
  App.js
  index.js

API Endpoints

The frontend interacts with a backend server for authentication. Here are the assumed API endpoints:

Login: POST /api/auth/login

Register: POST /api/auth/register

Forgot Password: POST /api/auth/forgot-password

Verify OTP: POST /api/auth/verify-otp

Reset Password: POST /api/auth/reset-password

Screenshots

(Add screenshots of the login, register, forgot password, and other pages here.)

Contributing

If you'd like to contribute to this project, feel free to fork the repository and submit a pull request. Please ensure your code follows the project's coding standards.

License

This project is licensed under the MIT License. See the LICENSE file for more details.

Suggested Project Name

React Auth System

Secure React Authentication

React OTP-Based Authentication

Glassmorphism Auth UI
