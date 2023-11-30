<%@page import="com.shoppingcart.connection.DbCon" %>
<%@page import="com.shoppingcart.doa.ProductDoa" %>
<%@page import="com.shoppingcart.model.*" %>
<%@page import="java.util.*"%>




<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Contact Us</title> 
<%@include file ="includes/header.jsp" %>
</head>
<body style="padding-bottom:50px;">
<div class="container">
<%@include file ="includes/navbar.jsp" %>
<div class="container">
<div class="d-flex justify-content-between">
<div class ="card w-50  my-5 p-10" style="margin-left:10px; margin-right:10px; padding:20px;" id="info"> 


<p style="font-weight:bold; font-size:20px;"><i class="fas fa-solid fa-compass fa-2x" style="color: #000000;"></i> ADDRESS</p>
<p>123 Maple Street <br> Toronto, ON <br> N1N 2N2 CA</p>


<p style="font-weight:bold; font-size:20px;"class="fs-3 fw-bold"><i class="fas fa-solid fa-phone fa-2x" style="color: #000000;"></i> CONTACT US</p>
<P>1-888-123-4567</P>

<p style="font-weight:bold; font-size:20px;"class="fs-3 fw-bold"><i class="fas fa-solid fa-envelope fa-2x" style="color: #000000;"></i> ELECTRONIC SUPPORT</p>
<P>INFO@SHOPPINGCART.CA <br> CUSTOMERSUPPORT@SHOPPINGCART.CA</P>

</div>


    <div class ="card w-50  my-5" style="margin-left:10px; margin-right:10px;"> 
    <div class ="card-header text-center">Contact Us</div>
    <div class = "card-body">
    <div>
    <form class="row g-3" action="send-message" method="post">
	      
	    <div class="col-md-6">
		    <label for="inputFirstName" class="form-label">First Name</label>
		    <input type="text" class="form-control" id="inputFirstName" name="senderName" >
	  	</div>
	  	
		<div class="col-md-6">
			<label for="inputLastName" class="form-label">Last Name</label>
			<input type="text" class="form-control" id="inputLastName">
		</div>
		
	    <div class="col-md-12">
		    <label for="inputEmail4" class="form-label">Email</label>
		    <input type="email" class="form-control" id="inputEmail4" name="senderEmail">
	    </div>
	
	    <div class="col-md-12">
		    <label for="inputEmail4" class="form-label">Your Message</label>
		    <textarea class="form-control" name="messageText" aria-label="With textarea"></textarea>
	    </div>
	      
	    <div class="text-center col-12">
	    	<button type="submit" class="btn btn-primary" style="margin-top: 20px;" >Send Message</button>
	    </div>
	    
	    
	    
    </form>
    
</div>
</div>
</div>

</div>


</div>
</div>




<%@include file ="includes/footer.jsp" %>
</body>
</html>