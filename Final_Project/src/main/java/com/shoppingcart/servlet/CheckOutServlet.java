package com.shoppingcart.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;

import com.shoppingcart.connection.DbCon;
import com.shoppingcart.doa.OrderDoa;
import com.shoppingcart.model.Cart;
import com.shoppingcart.model.Order;
import com.shoppingcart.model.User;

@WebServlet("/cart-check-out")
public class CheckOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
			// user authentication note we need to fix this to work 
			User auth = (User) request.getSession().getAttribute("auth");
			// is will get all the cart products
			ArrayList<Cart> cart_list = (ArrayList<Cart>)request.getSession().getAttribute("cart-list");
						
			//check auth and cartlist 
			if(cart_list !=null && auth !=null) {
				try {
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
					Date date = new Date();	
					
				for(Cart c:cart_list) {
					//prepared the order object
					Order order = new Order();
					order.setId(c.getId());
					order.setUid(auth.getId());
					order.setQuantity(c.getQuantity());
					order.setDate(formatter.format(date));
					// instantiate the DOA/DAO class
					OrderDoa oDao = new OrderDoa(DbCon.getConnection());
					//call the insert method
					boolean result = oDao.insertOrder(order);
					if(!result) {
						break;
					}
				}
				cart_list.clear();
				
				//response.sendRedirect("order.jsp");
				
				request.getSession().setAttribute("orderProcessed", true);
				
			}catch(ClassNotFoundException|SQLException e){
				e.printStackTrace();
				// Handle exceptions as needed
	            // For example, forward to an error page
	            request.getRequestDispatcher("error.jsp").forward(request, response);
	            return;
			}
			
			}else {
				if(auth == null) {
					response.sendRedirect("login.jsp");
					return;
				}else {
				response.sendRedirect("cart.jsp");
				return;
				}
			}
			
			response.sendRedirect("order.jsp");
		}
	


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Check if the user is logged in
        if (!isLoggedIn(request)) {
            // If not logged in, redirect to the login page
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return; // Stop further processing
        }

        // Continue with the checkout process
        // ...

        // Redirect or forward to a success page
        response.sendRedirect(request.getContextPath() + "/checkout-success.jsp");
    }

    // You can also include methods to check the login status, retrieve user information, etc.

    private boolean isLoggedIn(HttpServletRequest request) {
        // Your logic to check if the user is logged in
        // For example, you might check for a session attribute that indicates the user is logged in
        HttpSession session = request.getSession(false); // Do not create a new session if it doesn't exist
        return session != null && session.getAttribute("user") != null;
    }


}
