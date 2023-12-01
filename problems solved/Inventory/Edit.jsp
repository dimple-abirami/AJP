<%@ page contentType="text/html" %>
<jsp:useBean id="rs" scope="request" type="javax.sql.RowSet" />
<html>
<head>
    <title>Inventory - Edit</title>
</head>
<body style="font-family:verdana;font-size:10pt;">
    <%
    if (rs.next()) {
    %>
    <form action="Update">
        <table cellpadding="5" style="font-family:verdana;font-size:10pt;">
            <input name="id" type="hidden" value="<%= rs.getString(1) %>"/>
            <tr>
                <td><b>Name:</b></td>
                <td><input name="name" type="text" value="<%= rs.getString(2) %>"/></td>
            </tr>
            <tr>
                <td><b>Description:</b></td>
                <td><input name="description" type="text" value="<%= rs.getString(3) %>"/></td>
            </tr>
            <tr>
                <td><b>Price:</b></td>
                <td><input name="price" type="text" value="<%= rs.getString(4) %>"/></td>
            </tr>
            <tr>
                <td><b>Stock:</b></td>
                <td><input name="stock" type="text" value="<%= rs.getString(5) %>"/></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Update"/></td>
            </tr>
        </table>
    </form>
    <%
    }
    %>
</body>
</html>
