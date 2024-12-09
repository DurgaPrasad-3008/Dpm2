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

@WebServlet("/LoginServlet2")
public class LoginServlet2 extends HttpServlet {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/dpm1_db";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Durga@7744";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                // Save the logged-in username in the session
                request.getSession().setAttribute("loggedInUser", username);

                out.println("<h2>Welcome, " + username + "!</h2>");
                out.println("<form action='ShowUsersServlet2' method='get'>");
                out.println("<button type='submit'>Show Table</button>");
                out.println("</form>");
                out.println("<form action='UpdateDetailsServlet1' method='get'>");
                out.println("<button type='submit'>Update My Details</button>");
                out.println("</form>");
            } else {
                out.println("<h2>Invalid username or password!</h2>");
                out.println("<a href='login2.jsp'>Try Again</a>");
            }

            stmt.close();
            conn.close();
        } catch (Exception e) {
            out.println("<h2>Error: " + e.getMessage() + "</h2>");
        }
    }
}
