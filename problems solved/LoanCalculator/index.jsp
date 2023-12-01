 <!-- Develop a Web application using JSP to design a Loan Calculator to incorporate the page
directive, include directive, forward action directive in necessary cases and to handle the
error -->

<!DOCTYPE html>
<html>
<head>
    <title>Include</title>
</head>
<body style="font-family: verdana; font-size: 10pt;">

    <%@ include file="header.html" %>

    <form action="controller.jsp" method="post">
        <table border="0" style="font-family: verdana; font-size: 10pt;">
            <tr>
                <td colspan="2">Loan Calculator</td>
            </tr>
            <tr>
                <td>Simple:</td>
                <td><input type="radio" name="type" value="S" /></td>
            </tr>
            <tr>
                <td>Period:</td>
                <td><input type="text" name="period"/></td>
            </tr>
            <tr>
                <td>Amount:</td>
                <td><input type="text" name="amount" /></td>
            </tr>
            <tr>
                <td>Interest in %:</td>
                <td><input type="text" name="interest"/></td>
            </tr>
            <tr>
                <td>Compound:</td>
                <td><input type="radio" name="type" value="C" checked/></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Calculate"/></td>
            </tr>
        </table>
    </form>

    <jsp:include page="footer.jsp"/>

</body>
</html>
