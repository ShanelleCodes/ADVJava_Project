package com.shoppingcart.servlet;

import com.shoppingcart.connection.DbCon;
import com.shoppingcart.doa.MessagesDoa;
import com.shoppingcart.model.Messages;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/send-message")
public class ContactUsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve message details from the request parameters
        String senderName = request.getParameter("senderName");
        String senderEmail = request.getParameter("senderEmail");
        String messageText = request.getParameter("messageText");

        // Create a Message object with the retrieved details
        Messages message = new Messages();
        message.setSenderName(senderName);
        message.setSenderEmail(senderEmail);
        message.setMessageText(messageText);

        // Save the message to the database using a MessageDao
        MessagesDoa messagesDoa = null;
		try {
			 messagesDoa = new MessagesDoa(DbCon.getConnection());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        messagesDoa.saveMessage(message);

     // Redirect or forward to a success page
        response.sendRedirect("message-success.jsp");

    }

    // You can also include methods to retrieve messages, update messages, or perform other operations.
}
