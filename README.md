# Full Stack Authentication System with OTP Verification

This project is a comprehensive **full-stack authentication system** featuring a React frontend and a Spring Boot backend. It incorporates secure authentication with OTP verification, user registration, password recovery, and an enhanced UI with glassmorphism effects.

## 🚀 Features

### Frontend (React)
✅ User Registration  
✅ User Login  
✅ Forgot Password (OTP-based recovery)  
✅ Password Reset  
✅ 404 Not Found Page with creative video backgrounds  
✅ Glassmorphism UI with modern animations and effects  

### Backend (Spring Boot)
✅ User Authentication with JWT  
✅ OTP Generation and Verification  
✅ BCrypt Encryption for Passwords  
✅ Global Exception Handling  
✅ Secure CORS Configuration  

## 🛠️ Technologies Used

- **Frontend**: React, Axios, React Router DOM
- **Backend**: Spring Boot, Spring Security, BCrypt, JavaMailSender
- **Database**: MySQL / H2 Database
- **Styling**: CSS with Glassmorphism and Neon effects

## 📂 Project Structure
```
/src
  /controller
    - AuthController.java
  /config
    - SecurityConfig.java
  /dto
    - ForgotPasswordRequest.java
    - LoginRequest.java
    - RegisterRequest.java
    - ResetPasswordRequest.java
    - UserResponse.java
    - VerifyOtpRequest.java
  /entity
    - Login.java
    - OtpDetails.java
  /repository
    - LoginRepository.java
    - OtpRepository.java
  /service
    - AuthService.java
    - OtpService.java
    - EmailService.java
  /exception
    - CustomException.java
    - GlobalExceptionHandler.java
```

## 🔗 API Endpoints

- **Login**: `POST /api/auth/login`
- **Register**: `POST /api/auth/register`
- **Forgot Password**: `POST /api/auth/forgot-password`
- **Verify OTP**: `POST /api/auth/verify-otp`
- **Reset Password**: `POST /api/auth/reset-password`

## ⚙️ Installation Guide

### Frontend Setup

1. Clone the Repository
    ```sh
    git clone https://github.com/your-username/your-repo-name.git
    cd frontend-folder
    ```
2. Install Dependencies
    ```sh
    npm install
    ```
3. Run the Development Server
    ```sh
    npm start
    ```

### Backend Setup

1. Navigate to Backend Folder
    ```sh
    cd backend-folder
    ```
2. Configure Database
    Add these properties in `application.properties`:
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/your_database
    spring.datasource.username=your_username
    spring.datasource.password=your_password
    ```
3. Install Dependencies
    ```sh
    mvn install
    ```
4. Run the Application
    ```sh
    mvn spring-boot:run
    ```

## 🛠 API Testing

You can use tools like Postman or Swagger to test the endpoints.

## 📬 Sample Requests

### Login Request
```json
{
  "email": "user@example.com",
  "password": "password123"
}
```

### Register Request
```json
{
  "email": "user@example.com",
  "name": "John Doe",
  "phone": "1234567890",
  "password": "password123"
}
```

### Forgot Password Request
```json
{
  "email": "user@example.com"
}
```
## 📸 Screenshots
  1.Registration
  
  ![Registration Page](https://github.com/Hussain0s/Mail/blob/3cc484464d9841290bb14acc8f25a951f7d0cde5/Screenshot%202025-03-10%20123305.png)

  2.Registration Successfully 

   ![Registration Successfully ](https://github.com/Hussain0s/Mail/blob/hero/Screenshot%202025-03-10%20123325.png?raw=true)

  3.Login 

  ![Login Page ](https://github.com/Hussain0s/Mail/blob/e8b8c29b4125d927cfba2c01d0162336d42fdc42/Screenshot%202025-03-10%20123354.png)


## 👨‍💻 Contributing

Feel free to fork the repository and submit a pull request. Ensure your code follows the project's coding standards and maintains the design aesthetics.

## 📜 License

This project is licensed under the MIT License. See the `LICENSE` file for more details.

## 📬 Contact

For issues, feature requests, or collaboration, feel free to open an issue or reach out directly.


Axios: For simplifying HTTP requests.

Glassmorphism Design: For inspiring the modern UI design.




