<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>About Us</title>
<%@include file="includes/header.jsp" %>

<style>
  .container2 {
    display: flex;
    flex-direction: column;
    align-items: center;
  }

  .section {
    display: flex;
    justify-content: center;
    align-items: center;
    margin-bottom: 50px;
  }

  img {
    height: 250px;
    width: auto;
    box-shadow: 2px 2px 4px #000000;
    padding: 5px;
  }

  p {
    text-align: justify;
    letter-spacing: 2px;
    margin: 20px;
  }
</style>

</head>
<body style="padding-bottom:50px;">
<div class="container">
  <%@include file="includes/navbar.jsp" %>
  <h1 class="text-center" style="margin-top:30px; margin-bottom: 30px;">About Us</h1>

<div class="container2">

  <div class="section">
    <img id="img1" src="Images/image2.jpg" class="g-col-6 g-col-md-4" alt="..." style="margin-right: 20px;">
    <p> Welcome to our digital haven, where convenience meets variety in the heart of Toronto! Established in 2022, 
      our headquarters in this bustling city embody our commitment to transforming your online shopping experience. 
      As a comprehensive one-stop-shop, we take pride in offering a diverse range of products, from cutting-edge 
      electronics to the latest fashion trends. Our mission is clear: to provide you with a seamless and enjoyable 
      journey as you explore our curated selection of must-have items.</p>
  </div>

  <div class="section">
    <p> At the core of our ethos is a dedication to simplicity. Our user-friendly website and intuitive design ensure 
      that navigating through our vast inventory is a pleasure, saving you time and effort. As Torontonians, we draw 
      inspiration from the vibrant energy of our city, infusing our platform with the same dynamic spirit. Join us as 
      we continue to evolve, always aiming to be your trusted destination for everything you need.</p>
    <img id="img2" src="Images/image1.jpg" class="g-col-6 g-col-md-4" alt="..." style="margin-left: 20px;">
  </div>

</div>
</div>
<%@include file="includes/footer.jsp" %>
</body>
</html>
