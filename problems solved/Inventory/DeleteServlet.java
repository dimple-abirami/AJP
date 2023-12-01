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

public class DeleteServlet extends HttpServlet {

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

            // Create PreparedStatement to delete from item where id = ?
            stmt = con.prepareStatement("delete from item where id = ?");
            stmt.setInt(1, Integer.parseInt(req.getParameter("id")));
            stmt.executeUpdate();

            // Close the statement
            stmt.close();

            // Forward the request to List.jsp
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
