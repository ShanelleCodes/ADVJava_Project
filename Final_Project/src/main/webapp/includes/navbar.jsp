<%@ page import="com.shoppingcart.model.User" %>
<%@ page import="jakarta.servlet.http.HttpSession" %>

 <%
    User user = (User) session.getAttribute("auth");
%>  

<nav class="navbar navbar-expand-lg" style="background-color: black; border-radius: 50px;">

  <a class="navbar-brand" href="index.jsp" style="color: white;">The Shopping Experience</a>
 
  
  
  <ul class="navbar-nav ml-auto nav nav-pills nav-fill">
    <li class="nav-item">
      <a class="nav-link" aria-current="page" href="index.jsp" style="color: white;">Home</a>
    </li>
    <% if (user == null) { %>
      <li class="nav-item">
        <a class="nav-link" href="login.jsp" style="color: white;">Login</a>
      </li>
    <% } else { %>
      <li class="nav-item">
        <a class="nav-link" href="log-out" style="color: white;">Logout</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="order.jsp" style="color: white;">Orders</a>
      </li>
    <% } %>
    <li class="nav-item">
      <a class="nav-link" href="cart.jsp" style="color: white;">Cart<span class="badge badge-danger px-1">${cart_list.size() }</span></a>
    </li>
  </ul>
  
  <style>
  .nav-pills .nav-link.active {
    background-color: white;
    color: black !important;
    font-weight: bold;
    border-radius: 20px;
  }
</style>
  
  
  <script>
  $(document).ready(function() {
    // Get the current URL
    var url = window.location.href;

    // Iterate over each navbar link
    $(".nav-link").each(function() {
      // Check if the link's href matches the current URL
      if (url.includes($(this).attr("href"))) {
        // Add the "active" class to the matching link
        $(this).addClass("active");
      }
    });
  });
</script>
</nav>
