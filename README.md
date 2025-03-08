# React Authentication System with OTP Verification

This project is a **full-stack authentication system** built with **React** for the frontend and a **Node.js/Express** backend (assumed based on the API endpoints). It provides a seamless user authentication experience, including features like user registration, login, password recovery via OTP, and password reset. The UI is designed with modern **Glassmorphism** and **Neon effects** for a visually appealing experience.

---

## Features

1. **User Registration**:
   - Users can create an account by providing their name, phone number, email, and password.
   - Form validation ensures all fields are filled correctly.

2. **User Login**:
   - Registered users can log in using their email and password.
   - Successfully logged-in users are redirected to the dashboard (or another protected route).

3. **Forgot Password**:
   - Users can request an OTP to reset their password if they forget it.
   - The OTP is sent to the user's email.

4. **OTP Verification**:
   - Users can verify the OTP sent to their email to proceed with password reset.
   - The verified email and OTP are stored in `sessionStorage` for security.

5. **Password Reset**:
   - Users can reset their password after OTP verification.
   - The new password is validated to ensure it meets security requirements (e.g., minimum length).

6. **404 Not Found Page**:
   - A custom 404 page with a YouTube video background for a better user experience.

7. **Responsive Design**:
   - The application is fully responsive and works seamlessly on both desktop and mobile devices.

8. **Modern UI**:
   - The UI is designed with **Glassmorphism** and **Neon effects** for a sleek and modern look.

---

## Technologies Used

### Frontend
- **React**: A JavaScript library for building user interfaces.
- **React Router DOM**: For handling routing in the application.
- **Axios**: For making HTTP requests to the backend API.
- **CSS**: Custom styles with Glassmorphism and Neon effects.

### Backend (Assumed)
- **Node.js**: A JavaScript runtime for building the backend.
- **Express**: A web framework for Node.js to handle API requests.
- **MongoDB** (or any other database): For storing user data.

---


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
##Screenshots
   (You can add screenshots of the following pages here:)

   - **Login Page

  - **Register Page

- **Forgot Password Page

- **OTP Verification Page

- **Reset Password Page

- **404 Not Found Page



##Contributing

If you'd like to contribute to this project, feel free to fork the repository and submit a pull request. Please ensure your code follows the project's coding standards.


Acknowledgments
React: For providing a powerful library for building user interfaces.

React Router DOM: For seamless routing in the application.

Axios: For simplifying HTTP requests.

Glassmorphism Design: For inspiring the modern UI design.




