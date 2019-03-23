<%-- 
    Document   : orderhistory
    Created on : Mar 18, 2019, 2:36:27 PM
    Author     : Rasmus2
--%>

<%@page import="FunctionLayer.Order"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order History</title>
    </head>
    <body>
        <h1>Order History</h1>
        <h2>The history of all your orders</h2>
        <ol>
            <%
                List<Order> orders = (List<Order>) request.getSession().getAttribute("OrderHistory");
                if (orders != null) {
                    for (int i = 0; i < orders.size(); i++) {
                        out.println("<li>" + orders.get(i).toString() + "</li>");

                        out.println("<form action=\"FrontController\" method=\"post\">");
                        out.println("<input type=\"hidden\" name=\"email\" value=\"" + request.getParameter("email") + "\">");
                        out.println("<input type=\"hidden\" name=\"password\" value=\"" + request.getParameter("password") + "\">");
                        out.println("<input type=\"hidden\" name=\"specificorder\" value=\"" + orders.get(i).getOrder_id() + "\">");
                        out.println("<input type=\"hidden\" name=\"command\" value=\"stykliste\">");
                        out.println("<input type=\"submit\" value=\"Order Stykliste\" />");
                        out.println("</form>");

                        out.println("<br>");
                    }
                } else {
                    out.println("<p>You have no orders in your order history!</p>");
                }
            %>
        </ol>
        <form action="FrontController" method="post">
            <input type="hidden" name="email" value="<%=request.getParameter("email")%>">
            <input type="hidden" name="password" value="<%=request.getParameter("password")%>">
            <input type="hidden" name="command" value="main">
            <input type="submit" value="Back to main page" />
        </form>
    </body>
</html>
