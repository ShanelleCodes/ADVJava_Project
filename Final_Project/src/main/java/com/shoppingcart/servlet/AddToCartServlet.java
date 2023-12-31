package com.shoppingcart.servlet;

import java.util.ArrayList;

import com.shoppingcart.model.Cart;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/add-to-cart")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF=8");
		try(PrintWriter out = response.getWriter()){
			
			ArrayList<Cart> cartList = new ArrayList<>();
			
			int id = Integer.parseInt(request.getParameter("id"));
			Cart cm = new Cart();
			cm.setId(id);
			cm.setImage("/Images");
			cm.setQuantity(1);
			
			HttpSession session = request.getSession();
			ArrayList<Cart> cart_list = (ArrayList<Cart>)session.getAttribute("cart-list");
			
			if(cart_list == null) {
				cartList.add(cm);
			session.setAttribute("cart-list", cartList);
			response.sendRedirect("index.jsp");
			//out.println("session created and added the list");
			}else {
				//out.print("cart list exist");
				cartList = cart_list;
				boolean exist = false;
				
				//cartList.contains(cm);this for each loop is c: for our session id
				for(Cart c : cart_list) {
					if(c.getId()== id) {
						exist = true;
						//out.println("<h3 style='color:crimson, text-align:center'> Item already exist on the Cart.<a href='cart.jsp'> Go to Cart Page</a></h3>");
						// Set a flag in the session to indicate that the item already exists
                        session.setAttribute("itemExists", true);
                        response.sendRedirect("item-exits.jsp");
                        return; // Stop further processing

				}
			}
				if(!exist) {
					cartList.add(cm);
					//out.println("product added");
					response.sendRedirect("index.jsp");
					
				}
			}
		
			//for(Cart c:cart_list) {
			//	out.println(c.getId());
			}
		}
	}



