
<%@page import="com.shoppingcart.connection.DbCon" %>
<%@page import="com.shoppingcart.doa.ProductDoa" %>
<%@page import="com.shoppingcart.model.*" %>
<%@page import="java.util.*"%>

<%
User auth = (User)request.getSession().getAttribute("auth");
if(auth != null){
	response.sendRedirect("index.jsp");
}
ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
if(cart_list != null){
	request.setAttribute("cart_list", cart_list);
}%>



<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shopping Cart - Login</title>
<%@include file ="includes/header.jsp" %>
</head>
<body style="padding-bottom:50px;">
<div class="container">
<%@include file ="includes/navbar.jsp" %>
<div class="container">


<div class ="card w-50 mx-auto my-5">
<div class ="card-header text-center">User Login</div>
<div class = "card-body">
<form action="user-login" method="post">

<div class="form-group">
<label>Email Address</label>
<input type="email" class="form-control" name ="login-email" placeholder="Enter your Email" required>
</div>
<div class="form-group">
<label>Password</label>
<input type="password" class="form-control" name ="login-password" placeholder="*********" required>
</div>
<div class="text-center">
<button type="submit" class="btn btn-primary">Login</button>
</div>
<p class="text-center" style="margin-top:10px">Don't have an account? <a href="register.jsp"> Create One Here</a></p>

</form>



</div>

</div>



</div>


</div>
<%@include file ="includes/footer.jsp" %>

</body>
</html>