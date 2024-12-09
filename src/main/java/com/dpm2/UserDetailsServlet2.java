package com.dpm2;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UserDetailsServlet2")
public class UserDetailsServlet2 extends HttpServlet {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/dpm1_db";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Durga@7744";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            String sql = "SELECT * FROM users WHERE username = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                out.println("<h2>User Details</h2>");
                out.println("<table border='1' style='border-collapse: collapse; width: 50%;'>");
                out.println("<tr><th>Field</th><th>Value</th></tr>");

                out.println("<tr><td>Username</td><td>" + rs.getString("username") + "</td></tr>");
                out.println("<tr><td>Name</td><td>" + rs.getString("name") + "</td></tr>");
                out.println("<tr><td>Surname</td><td>" + rs.getString("surname") + "</td></tr>");
                out.println("<tr><td>Gender</td><td>" + rs.getString("gender") + "</td></tr>");
                out.println("<tr><td>Date of Birth</td><td>" + rs.getString("dob") + "</td></tr>");
                out.println("<tr><td>Age</td><td>" + rs.getString("age") + "</td></tr>");
                out.println("<tr><td>Phone</td><td>" + rs.getString("phone") + "</td></tr>");
                out.println("<tr><td>Course</td><td>" + rs.getString("course") + "</td></tr>");
                out.println("<tr><td>Email</td><td>" + rs.getString("email") + "</td></tr>");
                out.println("<tr><td>Current Address</td><td>" + rs.getString("current_address") + "</td></tr>");
                out.println("<tr><td>Permanent Address</td><td>" + rs.getString("permanent_address") + "</td></tr>");
                out.println("<tr><td>Date of Joining</td><td>" + rs.getString("date_of_joining") + "</td></tr>");
                out.println("<tr><td>Year of Study</td><td>" + rs.getString("year_of_study") + "</td></tr>");

                out.println("</table>");
            } else {
                out.println("<h3>No details found for this user</h3>");
            }

            stmt.close();
            conn.close();
        } catch (Exception e) {
            out.println("<h2>Error: " + e.getMessage() + "</h2>");
        }
    }
}
