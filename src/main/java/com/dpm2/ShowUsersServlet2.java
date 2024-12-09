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

@WebServlet("/ShowUsersServlet2")
public class ShowUsersServlet2 extends HttpServlet {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/dpm1_db";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Durga@7744";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            String sql = "SELECT username FROM users";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            out.println("<h2>Registered Users</h2>");
            out.println("<table border='1'>");
            out.println("<tr><th>Username</th><th>Action</th><th>Update</th></tr>");

            while (rs.next()) {
                String username = rs.getString("username");
                out.println("<tr>");
                out.println("<td>" + username + "</td>");
                out.println("<td>");
                out.println("<form action='UserDetailsServlet2' method='get' style='display:inline;'>");
                out.println("<input type='hidden' name='username' value='" + username + "'>");
                out.println("<button type='submit'>View Details</button>");
                out.println("</form>");
                out.println("</td>");
                // Add Update button
                out.println("<td>");
                out.println("<form action='UpdateDetailsServlet1' method='get' style='display:inline;'>");
                out.println("<input type='hidden' name='username' value='" + username + "'>");
                out.println("<button type='submit'>Update My Details</button>");
                out.println("</form>");
                out.println("</td>");
                out.println("</tr>");
            }

            out.println("</table>");
            stmt.close();
            conn.close();
        } catch (Exception e) {
            out.println("<h2>Error: " + e.getMessage() + "</h2>");
        }
    }
}
