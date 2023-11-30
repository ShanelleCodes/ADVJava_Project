<%@ page import="com.shoppingcart.connection.DbCon" %>
<%@ page import="com.shoppingcart.doa.UserDoa" %>
<%@ page import="com.shoppingcart.model.User" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
<%@ include file="includes/header.jsp" %>
</head>
<body class="d-flex flex-column min-vh-100" style="padding-bottom:50px;">

<div class="container">
    <%@ include file="includes/navbar.jsp" %>
    
    <div class="container">
        <div class="card w-50 mx-auto my-5">
            <div class="card-header text-center">Create an Account</div>
            <div class="card-body">
                <form action="register" method="post">
                 	<div class="form-group">
                    <label for="username">Name</label>
                    <input type="text" class="form-control" id="username" name="name" required>
                    </div>
                    <div class="form-group">
                    <label for="email">Email</label>
                    <input type="email" class="form-control" id="email" name="email" required>
                    </div>
                    <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" class="form-control" id="password" name="password" required>
                     </div>
                     <div class="text-center">
                    <button type="submit" class="btn btn-primary">Register</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div> 








<%@ include file="includes/footer.jsp" %>
</body>
</html>