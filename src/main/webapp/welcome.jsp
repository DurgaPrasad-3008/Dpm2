<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            height: 100vh;
            font-family: Arial, sans-serif;
            text-align: center;
            background-image: url('https://theginnews.com/wp-content/uploads/2023/12/king-fahad.jpg');
            background-size: cover;
            background-position: center;
            background-attachment: fixed;
            color: white;
            display: flex;
            justify-content: center;
            align-items: center;
        }
        .container {
            padding: 40px;
            border: 2px solid #4CAF50;
            border-radius: 10px;
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.3);
            background: rgba(0, 0, 0, 0.5); /* Semi-transparent background */
            text-align: center;
        }
        h1 {
            font-size: 2.5em;
            margin-bottom: 20px;
        }
        p {
            font-size: 1.2em;
            margin-bottom: 30px;
        }
        .btn {
            background-color: #4CAF50;
            color: white;
            padding: 12px 25px;
            text-decoration: none;
            border-radius: 5px;
            font-size: 1.1em;
            margin: 10px;
            display: inline-block;
        }
        .btn:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Welcome to the Application</h1>
        <p>Please choose one of the options below:</p>
        <a href="login2.jsp" class="btn">Login</a>
        <a href="register2.jsp" class="btn">Register</a>
    </div>
</body>
</html>
