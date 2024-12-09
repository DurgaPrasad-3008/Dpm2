<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            height: 100%;
            background-image: url('https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEjaCv_CVD0fFmJhT6vb9pJWpwBId03JWiR7psYMu9eKdRktNADHty4dBnAydS5ZnGtH_TK3ta7JqG6RweE3bDvezUINEtKx1siRKc81udh92k4pMnsP57pSH8tE8J_TqFfF4GvTSLosUSU/s1600-rw/king%2Bfahd%2Buniversity%2Bof%2Bpetroleum%2Band%2Bminerals%2Bkfupm%2Bfull%2Bmasters%2Bphd%2Bscholarship.jpg');
            background-size: cover;
            background-position: center;
            background-attachment: fixed;
            font-family: Arial, sans-serif;
            color: white;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .register-container {
            width: 400px;
            padding: 30px;
            background-color: rgba(0, 0, 0, 0.6);
            color: white;
            border-radius: 10px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.5);
            text-align: center;
        }

        .register-container h2 {
            margin-bottom: 20px;
        }

        .register-container input {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border: none;
            border-radius: 5px;
        }

        .register-container button {
            width: 100%;
            padding: 10px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        .register-container button:hover {
            background-color: #45a049;
        }

        .register-container a {
            color: #f1f1f1;
            text-decoration: none;
            display: block;
            margin-top: 10px;
        }
    </style>
</head>
<body>
    <div class="register-container">
        <h2>Register</h2>
        <form action="RegisterServlet2" method="POST">
            <input type="text" name="username" placeholder="Username" required><br>
            <input type="password" name="password" placeholder="Password" required><br>
            <input type="email" name="email" placeholder="Email" required><br>
            <input type="text" name="gender" placeholder="Gender" required><br>
            <input type="text" name="course" placeholder="Course" required><br>
            <button type="submit">Register</button>
        </form>
        <a href="login2.jsp">Already have an account? Login</a>
    </div>
</body>
</html>
