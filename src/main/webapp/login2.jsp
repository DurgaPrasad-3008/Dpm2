<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            height: 100vh;
            font-family: Arial, sans-serif;
            background-image: url('https://live.staticflickr.com/4142/4827442825_6ebc39e45c_c.jpg');
            background-size: cover;
            background-position: center;
            background-attachment: fixed;
            color: white;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        h2 {
            font-size: 2em;
            margin-bottom: 20px;
        }

        form {
            width: 300px;
            padding: 30px;
            background: rgba(0, 0, 0, 0.7); /* Semi-transparent background */
            border-radius: 10px;
            box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.5);
            text-align: center;
        }

        label {
            display: block;
            margin-bottom: 10px;
            font-weight: bold;
        }

        input {
            width: 100%;
            padding: 8px;
            margin-bottom: 15px;
            border: none;
            border-radius: 5px;
        }

        button {
            width: 100%;
            padding: 10px;
            border: none;
            border-radius: 5px;
            background-color: #28a745;
            color: white;
            font-size: 16px;
            cursor: pointer;
        }

        button:hover {
            background-color: #218838;
        }
    </style>
</head>
<body>
    <div>
        <h2>Login Here</h2>
        <form action="LoginServlet2" method="post">
            <label>Username:</label>
            <input type="text" name="username" required>
            <label>Password:</label>
            <input type="password" name="password" required>
            <button type="submit">Login</button>
        </form>
    </div>
</body>
</html>
