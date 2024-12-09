package com.dpm2;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateDetailsServlet1")
public class UpdateDetailsServlet1 extends HttpServlet {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/dpm1_db";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Durga@7744";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<h2>Update Details for " + username + "</h2>");
        out.println("<form action='UpdateDetailsServlet1' method='post'>");
        out.println("<input type='hidden' name='username' value='" + username + "'>");
        out.println("<table border='1' style='border-collapse:collapse; width:50%; margin:auto;'>");
        out.println("<tr><td>Name:</td><td><input type='text' name='name' required></td></tr>");
        out.println("<tr><td>Surname:</td><td><input type='text' name='surname' required></td></tr>");
        out.println("<tr><td>Gender:</td><td><input type='text' name='gender' required></td></tr>");
        out.println("<tr><td>Date of Birth:</td><td><input type='date' name='dob' required></td></tr>");
        out.println("<tr><td>Age:</td><td><input type='number' name='age' required></td></tr>");
        out.println("<tr><td>Phone:</td><td><input type='text' name='phone' required></td></tr>");
        out.println("<tr><td>Course:</td><td><input type='text' name='course' required></td></tr>");
        out.println("<tr><td>Email:</td><td><input type='email' name='email' required></td></tr>");
        out.println("<tr><td>Current Address:</td><td><input type='text' name='currentAddress'></td></tr>");
        out.println("<tr><td>Permanent Address:</td><td><input type='text' name='permanentAddress' required></td></tr>");
        out.println("<tr><td>Date of Joining:</td><td><input type='date' name='dateOfJoining' required></td></tr>");
        out.println("<tr><td>Year of Study:</td><td><input type='number' name='yearOfStudy' required></td></tr>");
        out.println("<tr><td colspan='2' style='text-align:center;'><button type='submit'>Update</button></td></tr>");
        out.println("</table>");
        out.println("</form>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String gender = request.getParameter("gender");
        String dob = request.getParameter("dob");
        String age = request.getParameter("age");
        String phone = request.getParameter("phone");
        String course = request.getParameter("course");
        String email = request.getParameter("email");
        String currentAddress = request.getParameter("currentAddress");
        String permanentAddress = request.getParameter("permanentAddress");
        String dateOfJoining = request.getParameter("dateOfJoining");
        String yearOfStudy = request.getParameter("yearOfStudy");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            String sql = "UPDATE users SET name = ?, surname = ?, gender = ?, dob = ?, age = ?, phone = ?, course = ?, email = ?, current_address = ?, permanent_address = ?, date_of_joining = ?, year_of_study = ? WHERE username = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, surname);
            stmt.setString(3, gender);
            stmt.setString(4, dob);
            stmt.setString(5, age);
            stmt.setString(6, phone);
            stmt.setString(7, course);
            stmt.setString(8, email);
            stmt.setString(9, currentAddress);
            stmt.setString(10, permanentAddress);
            stmt.setString(11, dateOfJoining);
            stmt.setString(12, yearOfStudy);
            stmt.setString(13, username);

            int result = stmt.executeUpdate();

            if (result > 0) {
                response.sendRedirect("login2.jsp"); // Redirect to login page after update
            } else {
                response.getWriter().println("<h2>Update Failed!</h2>");
            }

            stmt.close();
            conn.close();
        } catch (Exception e) {
            response.getWriter().println("<h2>Error: " + e.getMessage() + "</h2>");
        }
    }
}
