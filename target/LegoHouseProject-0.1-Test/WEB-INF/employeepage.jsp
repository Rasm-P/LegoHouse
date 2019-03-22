<%-- 
    Document   : employeepage.jsp
    Created on : Mar 20, 2019, 5:56:37 PM
    Author     : Rasmus2
--%>

<%@page import="java.util.List"%>
<%@page import="FunctionLayer.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee home page</title>
    </head>
    <body>
        <h1>Hello <%=request.getParameter("email")%> </h1>
        <h2>You are now logged in as a EMPLOYEE of our wonderful site.</h2>
        <h3>The history of all user orders</h3>
        <ol>
            <%
                List<Order> orders = (List<Order>) request.getSession().getAttribute("AllOrders");
                if (orders != null) {
                    for (int i = 0; i < orders.size(); i++) {
                        out.println("<li>" + "User_id: " + orders.get(i).getUser_id() + orders.get(i).toString() + "</li>");

                        out.println("<form action=\"FrontController\" method=\"post\">");
                        out.println("<input type=\"hidden\" name=\"email\" value=\"" + request.getParameter("email") + "\">");
                        out.println("<input type=\"hidden\" name=\"password\" value=\"" + request.getParameter("password") + "\">");

                        out.println("<select name=\"status\">");
                        out.println("<option value=\"-1\">Change order status</option>");
                        out.println("<option value=\"1\">Sent</option><option value=\"0\">Not Sent</option>");
                        out.println("</select>");

                        out.println("<input type=\"hidden\" name=\"specificorder\" value=\"" + orders.get(i).getOrder_id() + "\">");
                        out.println("<input type=\"hidden\" name=\"command\" value=\"main\">");
                        out.println("<input type=\"submit\" value=\"Change order status\" />");
                        out.println("</form>");

                        out.println("<form action=\"FrontController\" method=\"post\">");
                        out.println("<input type=\"hidden\" name=\"email\" value=\"" + request.getParameter("email") + "\">");
                        out.println("<input type=\"hidden\" name=\"password\" value=\"" + request.getParameter("password") + "\">");
                        out.println("<input type=\"hidden\" name=\"specificorder\" value=\"" + orders.get(i).getOrder_id() + "\">");
                        out.println("<input type=\"hidden\" name=\"command\" value=\"stykliste\">");
                        out.println("<input type=\"submit\" value=\"Stykliste\" />");
                        out.println("</form>");

                        out.println("<br>");
                    }
                } else {
                    out.println("<p>You have no orders in your order history!</p>");
                }
            %>
        </ol>
        <br>
        <form action="FrontController" method="post">
            <input type="hidden" name="command" value="logout">
            <input type="submit" value="Logout" />
        </form>
    </body>
</html>
