package edu.albany.mis.goel.servlets;

import javax.servlet.ServletException;
import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.CachedRowSet;
import java.sql.DriverManager;
import java.sql.SQLException;

public class EditServlet extends HttpServlet {

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException {
        try {
            // Load the driver class
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

            // Define the data source for the driver
            String sourceURL = "jdbc:odbc:inventoryDB";

            // Create a CachedRowSet
            CachedRowSet rs = new CachedRowSet();

            // Set the URL for the CachedRowSet
            rs.setUrl(sourceURL);

            // Set the query with a parameter
            rs.setCommand("select * from item where id = ?");
            rs.setInt(1, Integer.parseInt(req.getParameter("id")));
            rs.execute();

            // Set the row set as an attribute in the request
            req.setAttribute("rs", rs);

            // Forward the request to Edit.jsp
            getServletContext().getRequestDispatcher("/Edit.jsp").forward(req, res);
        } catch (ClassNotFoundException | SQLException ex) {
            throw new ServletException(ex);
        }
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException {
        doGet(req, res);
    }
}
