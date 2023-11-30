<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Item Exists</title>
<%@include file ="includes/header.jsp" %>
</head>
<body>

<div class="grid text-center" style="margin-top:40px">
<h1 class="text-danger" style="font-weight: bold">Item Already Exists</h1>
<p class="fs-1" style="font-weight: bold; font-size: 24px">Looks like this item already exists in your cart</p>
<a href="cart.jsp" class="btn btn-danger" style="font-size: 18px;">View Cart</a>
<a href="index.jsp" class="btn btn-dark" style="font-size: 18px;">Go Back</a>
</div>
</body>
</html>