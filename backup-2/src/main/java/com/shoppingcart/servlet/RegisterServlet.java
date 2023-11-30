// RegisterServlet.java

package com.shoppingcart.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import com.shoppingcart.connection.DbCon;
import com.shoppingcart.doa.UserDoa;
import com.shoppingcart.model.User;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            User newUser = new User();
            newUser.setName(name);
            newUser.setEmail(email);
            newUser.setPassword(password);
            

            UserDoa userDoa = new UserDoa(DbCon.getConnection());
            boolean registrationStatus = userDoa.registerUser(newUser);

            if (registrationStatus) {
                response.sendRedirect("login.jsp"); // Redirect to login page after successful registration
            } else {
                out.println("Registration failed. Please try again.");
            }
        } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
