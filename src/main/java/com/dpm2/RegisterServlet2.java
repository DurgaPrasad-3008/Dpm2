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

@WebServlet("/RegisterServlet2")
public class RegisterServlet2 extends HttpServlet {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/dpm1_db";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Durga@7744";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String course = request.getParameter("course");
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            String sql = "INSERT INTO users (username, password, email, gender, course) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.setString(3, email);
            stmt.setString(4, gender);
            stmt.setString(5, course);


            int result = stmt.executeUpdate();

            if (result > 0) {
                out.println("<h2>Registration Successful!</h2>");
                out.println("<a href='login2.jsp'>Go to Login Page</a>");
            } else {
                out.println("<h2>Registration Failed!</h2>");
            }

            stmt.close();
            conn.close();
        } catch (Exception e) {
            out.println("<h2>Error: " + e.getMessage() + "</h2>");
        }
    }
}
  