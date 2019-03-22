<%-- 
    Document   : styklistpage
    Created on : Mar 20, 2019, 5:56:37 PM
    Author     : Rasmus2
--%>

<%@page import="FunctionLayer.Styklist"%>
<%@page import="FunctionLayer.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Styklist Page</title>
    </head>
    <body>
        <h1>Styklist Page</h1>
        <h2>This is the Lego House Styklist for your order</h2>
        <%
            Order order = (Order) request.getSession().getAttribute("Specificorder");
            out.println("<p>" + order.toString() + "</p>");
        
            Styklist styklist = (Styklist) request.getSession().getAttribute("styklist");
            out.println("<table>");
            out.println("<thead>");
            out.println("<tr>");
            out.println("<th>Lego type</th>");
            out.println("<th>In all x height</th>");
            out.println("</tr>");
            out.println("</thead>");
            out.println("<tbody>");

            out.println("<tr>");
            out.println("<td>2x4</td>");
            out.println("<td>" + styklist.getTotalWithHeigth2x4() + "</td>");
            out.println("</tr>");

            out.println("<tr>");
            out.println("<td>2x2</td>");
            out.println("<td>" + styklist.getTotalWithHeigth2x2() + "</td>");
            out.println("</tr>");

            out.println("<tr>");
            out.println("<td>1x2</td>");
            out.println("<td>" + styklist.getTotalWithHeigth1x2() + "</td>");
            out.println("</tr>");

            out.println("<tr>");
            out.println("<td>Windows2x2</td>");
            out.println("<td>" + styklist.getTotalWindows2x2() + "</td>");
            out.println("</tr>");

            out.println("<tr>");
            out.println("<td>Doors3x2</td>");
            out.println("<td>" + styklist.getTotalDoors3x2() + "</td>");
            out.println("</tr>");
            out.println("</tbody>");
            out.println("</table>");
        %>
        <br>
        <form action="FrontController" method="post">
            <input type="hidden" name="email" value="<%=request.getParameter("email")%>">
            <input type="hidden" name="password" value="<%=request.getParameter("password")%>">
            <input type="hidden" name="command" value="main">
            <input type="submit" value="Back to main page" />
        </form>
    </body>
</html>
