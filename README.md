# React Authentication System with OTP Verification

This project is a React-based authentication system that includes features like user registration, login, password recovery (via OTP), and password reset. It is designed to provide a secure and visually appealing authentication solution with modern UI elements like glassmorphism and neon effects.

## 🚀 Features

✅ **User Registration**: Users can create an account by providing their name, phone number, email, and password.  
✅ **User Login**: Registered users can log in using their email and password.  
✅ **Forgot Password**: Users can request an OTP to reset their password if they forget it.  
✅ **OTP Verification**: Users can verify the OTP sent to their email for password reset.  
✅ **Password Reset**: Users can reset their password after OTP verification.  
✅ **404 Not Found Page**: A custom 404 page featuring a YouTube video background for enhanced user experience.  

## 🛠️ Technologies Used

**Frontend:**
- React
- React Router DOM (for routing)
- Axios (for API calls)
- CSS (featuring Glassmorphism, Neon effects, and creative UI animations)


---

## 📂 Project Structure
/components ├── Login.js ├── Register.js ├── ForgotPassword.js ├── OTPVerification.js ├── ResetPassword.js └── NotFound.js /styles ├── login.css ├── register.css ├── forgotPassword.css ├── otpVerification.css ├── resetPassword.css └── notFound.css App.js index.js


---

## 🔗 API Endpoints

The frontend interacts with a backend server for authentication via the following API endpoints:

- **Login:** `POST /api/auth/login`  
- **Register:** `POST /api/auth/register`  
- **Forgot Password:** `POST /api/auth/forgot-password`  
- **Verify OTP:** `POST /api/auth/verify-otp`  
- **Reset Password:** `POST /api/auth/reset-password`  

---

## 🖥️ Installation

Follow these steps to run the project locally:

1. **Clone the Repository**
   ```bash
   git clone https://github.com/your-username/your-repo-name.git
   cd your-repo-name
2. **Install Dependencies**
   npm install
3.**Run the Development Server**
   npm start
4.**Open the App**
  The app will be running at http://localhost:3000.
