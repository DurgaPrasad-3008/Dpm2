<!DOCTYPE html>
<html>
<head>
    <title>Update Details</title>
    <!-- Add your styling here -->
</head>
<body>
    <h2>Update Your Details</h2>
    <form action="UpdateDetailsServlet1" method="post">
        <label>Name: </label><input type="text" name="name" required><br>
        <label>Surname: </label><input type="text" name="surname" required><br>
        <label>Gender: </label><input type="text" name="gender" required><br>
        <label>Date of Birth: </label><input type="date" name="dob" required><br>
        <label>Age: </label><input type="number" name="age" required><br>
        <label>Phone Number: </label><input type="text" name="phone" required><br>
        <label>Course: </label><input type="text" name="course" required><br>
        <label>Email: </label><input type="email" name="email" required><br>
        <label>Current Address: </label><input type="text" name="current_address"><br>
        <label>Permanent Address: </label><input type="text" name="permanent_address" required><br>
        <label>Date of Joining: </label><input type="date" name="doj"><br>
        <label>Year of Study: </label><input type="number" name="year_of_study" required><br>
        <button type="submit">Update Details</button>
    </form>
</body>
</html>
