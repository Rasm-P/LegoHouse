<%-- 
    Document   : orderpage
    Created on : Mar 18, 2019, 10:43:01 AM
    Author     : Rasmus2
--%>

<jsp:include page='/WEB-INF/siteheader.jsp'></jsp:include>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1>Make an order</h1>
<h2>Write your references in number of Lego brick dots for you verry own lego house by filling out the scheme</h2>
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

<jsp:include page='/WEB-INF/sitefooter.jsp'></jsp:include>
