<%-- 
    Document   : index
    Created on : Mar 20, 2019, 5:56:37 PM
    Author     : Rasmus2
--%>

<jsp:include page='/WEB-INF/siteheader.jsp'></jsp:include>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1>Welcome to the Lego House Builder</h1>
<table>
    <tr><td>Login</td>
        <td>
            <form name="login" action="FrontController" method="POST">
                <input type="hidden" name="command" value="login">
                Email:<br>
                <input type="text" name="email" value="jens@somewhere.com">
                <br>
                Password:<br>
                <input type="password" name="password" value="jensen">
                <br>
                <input type="submit" value="Submit">
            </form>
        </td>
        <td>Register</td>
        <td>
            <form name="register" action="FrontController" method="POST">
                <input type="hidden" name="command" value="register">
                Email:<br>
                <input type="text" name="email" value="">
                <br>
                Password:<br>
                <input type="password" name="password1" value="">
                <br>
                Retype Password:<br>
                <input type="password" name="password2" value="">
                <br>
                <input type="submit" value="Submit">
            </form>
        </td>
    </tr>
</table>
<% String error = (String) request.getAttribute("error");
    if (error != null) {
        out.println("<H2>Error!!</h2>");
        out.println(error);
    }
%>

<jsp:include page='/WEB-INF/sitefooter.jsp'></jsp:include>
