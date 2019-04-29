<%-- 
    Document   : customerpage
    Created on : Mar 20, 2019, 5:56:37 PM
    Author     : Rasmus2
--%>

<jsp:include page='/WEB-INF/siteheader.jsp'></jsp:include>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

        <h1>Hello <%=request.getParameter("email")%> </h1>
        <h2>You are now logged in as a customer of our wonderful site</h2>
        <form action="FrontController" method="post">
            <input type="hidden" name="email" value="<%=request.getParameter("email")%>">
            <input type="hidden" name="password" value="<%=request.getParameter("password")%>">
            <input type="hidden" name="command" value="order">
            <input type="submit" value="Make an order" />
        </form>
        <br>
        <form action="FrontController" method="post">
            <input type="hidden" name="email" value="<%=request.getParameter("email")%>">
            <input type="hidden" name="password" value="<%=request.getParameter("password")%>">
            <input type="hidden" name="command" value="orderstatus">
            <input type="submit" value="See order status" />
        </form>
        <br>
        <form action="FrontController" method="post">
            <input type="hidden" name="email" value="<%=request.getParameter("email")%>">
            <input type="hidden" name="password" value="<%=request.getParameter("password")%>">
            <input type="hidden" name="command" value="history">
            <input type="submit" value="See order history" />
        </form>
        <br>
        <form action="FrontController" method="post">
            <input type="hidden" name="command" value="logout">
            <input type="submit" value="Logout" />
        </form>

        <jsp:include page='/WEB-INF/sitefooter.jsp'></jsp:include>
