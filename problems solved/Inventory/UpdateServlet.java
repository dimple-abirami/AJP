package edu.albany.mis.goel.servlets;

import javax.servlet.ServletException;
import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateServlet extends HttpServlet {

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException {
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            // Load the driver class
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

            // Define the data source for the driver
            String sourceURL = "jdbc:odbc:inventoryDB";

            // Create a connection through the DriverManager class
            con = DriverManager.getConnection(sourceURL);
            System.out.println("Connected Connection");

            stmt = con.prepareStatement("update item set name = ?, description = ?, price = ?, stock = ? where id = ?");
            stmt.setString(1, req.getParameter("name"));
            stmt.setString(2, req.getParameter("description"));
            stmt.setDouble(3, Double.parseDouble(req.getParameter("price")));
            stmt.setInt(4, Integer.parseInt(req.getParameter("stock")));
            stmt.setInt(5, Integer.parseInt(req.getParameter("id")));
            stmt.executeUpdate();

            getServletContext().getRequestDispatcher("/List").forward(req, res);
        } catch (ClassNotFoundException | SQLException ex) {
            throw new ServletException(ex);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                throw new ServletException(ex);
            }
        }
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException {
        doGet(req, res);
    }
}
