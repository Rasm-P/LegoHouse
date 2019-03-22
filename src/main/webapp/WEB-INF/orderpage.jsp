<%-- 
    Document   : orderpage
    Created on : Mar 18, 2019, 10:43:01 AM
    Author     : Rasmus2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order Page</title>
    </head>
    <body>
        <h1>Make an order</h1>
        <h2>Write your references inf number of bricks for you verry own lego house by filling out the scene.</h2>
        <form name="OrderPage" action="FrontController" method="POST">
            <input type="hidden" name="email" value="<%=request.getParameter("email")%>">
            <input type="hidden" name="password" value="<%=request.getParameter("password")%>">
            <input type="hidden" name="command" value="finalizeorder">
            Width<br>
            <input type="text" name="width" value="">
            <br>
            length<br>
            <input type="text" name="length" value="">
            <br>
            Height<br>
            <input type="text" name="height" value="">
            <br>
            <br>
            <input type="submit" value="Finalize order!">
        </form>
        <br>
        <form action="FrontController" method="post">
            <input type="hidden" name="email" value="<%=request.getParameter("email")%>">
            <input type="hidden" name="password" value="<%=request.getParameter("password")%>">
            <input type="hidden" name="command" value="main">
            <input type="submit" value="Back to main page" />
        </form>
    </body>
</html>
