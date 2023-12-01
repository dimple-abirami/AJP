package edu.albany.mis.goel.servlets;

import javax.servlet.ServletException;
import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.CachedRowSet;
import javax.sql.DataSource;
import java.sql.DriverManager;

public class ListServlet extends HttpServlet {

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

            // Execute the query
            rs.setCommand("select * from item");
            rs.execute();

            // Set the row set as an attribute in the request
            req.setAttribute("rs", rs);

            // Forward the request to List.jsp
            getServletContext().getRequestDispatcher("/List.jsp").forward(req, res);
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException {
        doGet(req, res);
    }
}
