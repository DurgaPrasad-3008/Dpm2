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

@WebServlet("/UserDetailsAPI")
public class UserDetailsAPI extends HttpServlet {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/dpm1_db";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Durga@7744";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = request.getParameter("id");

        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            if (userId == null) {
                // Fetch all IDs if no ID is provided
                String sql = "SELECT id FROM users";
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();

                out.print("[");
                boolean first = true;
                while (rs.next()) {
                    if (!first) out.print(",");
                    out.print("{\"id\": \"" + rs.getInt("id") + "\"}");
                    first = false;
                }
                out.print("]");

                stmt.close();
            } else {
                // Fetch specific user details if ID is provided
                String sql = "SELECT * FROM users WHERE id = ?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, userId);
                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    out.println("{");
                    out.println("\"id\": \"" + rs.getInt("id") + "\",");
                    out.println("\"username\": \"" + rs.getString("username") + "\",");
                    out.println("\"name\": \"" + rs.getString("name") + "\",");
                    out.println("\"surname\": \"" + rs.getString("surname") + "\",");
                    out.println("\"gender\": \"" + rs.getString("gender") + "\",");
                    out.println("\"dob\": \"" + rs.getString("dob") + "\",");
                    out.println("\"age\": \"" + rs.getString("age") + "\",");
                    out.println("\"phone\": \"" + rs.getString("phone") + "\",");
                    out.println("\"course\": \"" + rs.getString("course") + "\",");
                    out.println("\"email\": \"" + rs.getString("email") + "\",");
                    out.println("\"current_address\": \"" + rs.getString("current_address") + "\",");
                    out.println("\"permanent_address\": \"" + rs.getString("permanent_address") + "\",");
                    out.println("\"date_of_joining\": \"" + rs.getString("date_of_joining") + "\",");
                    out.println("\"year_of_study\": \"" + rs.getString("year_of_study") + "\"");
                    out.println("}");
                } else {
                    out.println("{\"error\": \"User not found\"}");
                }
                stmt.close();
            }
            conn.close();
        } catch (Exception e) {
            out.println("{\"error\": \"Error: " + e.getMessage() + "\"}");
        }
    }
}