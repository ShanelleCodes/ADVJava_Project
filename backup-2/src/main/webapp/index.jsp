<%@page import="com.shoppingcart.connection.DbCon" %>
<%@page import="com.shoppingcart.doa.ProductDoa" %>
<%@page import="com.shoppingcart.model.*" %>
<%@page import="java.util.*"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%
User auth = (User)request.getSession().getAttribute("auth");
if(auth != null){
	request.setAttribute("person",auth);
}

ProductDoa pd = new ProductDoa(DbCon.getConnection());
List<Product> products = pd.getAllProducts();

ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
if(cart_list != null){
	request.setAttribute("cart_list", cart_list);
}

%>


    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Shopping Cart Example - evening</title>
<%@include file ="includes/header.jsp" %></head>

</head>
<body class="d-flex flex-column min-vh-100" style="padding-bottom:50px;">

<div class="container">
    <%@include file ="includes/navbar.jsp" %>
    <div class="container">
    
     <img src="Images/welcome.png" class=" mx-auto d-block" alt="start shopping message" style="margin-top:10px; height:75vh ">
     
        <div class="card-header my-3">All Products</div>
        
   
        
        <div class="row">
            <% 
            if (!products.isEmpty()) {
                for (Product p : products) {%>
                    <div class="col-md-3 my-3">
                        <div class="card h-100">
                            <img src="Images/<%= p.getImage() %>" class="card-img-top rounded mx-auto d-block" alt="...">
                            <div class="card-body d-flex flex-column">
                                <div class="mt-auto">
                                    <h5 class="card-title mb-3"><%= p.getName() %></h5>
                                    <h6 class="price mb-3">Price: $<%= p.getPrice() %></h6>
                                    <h6 class="category mb-3">Category: <%= p.getCategory() %></h6>
                                </div>
                                <div class="d-flex justify-content-between mt-3">
                                    <a href="add-to-cart?id=<%= p.getId() %>" class="btn btn-dark">Add to Cart</a>                                    
                                    <a href="order-now?quantity=1&id=<%= p.getId() %>" class="btn btn-primary">Buy Now</a>
                                </div>
                            </div>
                        </div>
                    </div>
                <% }
            } else {
                out.println("There is no products");
            }
            %>
        </div>
    </div>
</div>



<%@include file ="includes/footer.jsp" %>
</body>
</html>
