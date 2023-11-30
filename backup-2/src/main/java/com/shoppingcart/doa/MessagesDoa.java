package com.shoppingcart.doa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shoppingcart.model.Messages;

public class MessagesDoa {
    private Connection connection;

    public MessagesDoa(Connection connection) {
        this.connection = connection;
    }

    // Method to add a new message to the Messages table
    public void addMessage(String senderName, String senderEmail, String messageText) {
        String query = "INSERT INTO Messages (senderName, senderEmail, messageText) VALUES (?, ?, ?)";

        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setString(1, senderName);
            pst.setString(2, senderEmail);
            pst.setString(3, messageText);

            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception (log it or throw a custom exception)
        }
    }

    // Method to retrieve all messages from the Messages table
    public List<Messages> getAllMessages() {
        List<Messages> messages = new ArrayList<>();
        String query = "SELECT * FROM Messages";

        try (PreparedStatement pst = connection.prepareStatement(query);
             ResultSet resultSet = pst.executeQuery()) {

            while (resultSet.next()) {
                int messageId = resultSet.getInt("messageId");
                String senderName = resultSet.getString("senderName");
                String senderEmail = resultSet.getString("senderEmail");
                String messageText = resultSet.getString("messageText");

                Messages message = new Messages(messageId, senderName, senderEmail, messageText);
                messages.add(message);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception (log it or throw a custom exception)
        }

        return messages;
    }

	
    public void saveMessage(Messages message) {
        try {
            // Insert the message into the database
            String query = "INSERT INTO messages (MessageID, SenderName, SenderEmail, MessageText) VALUES (?, ?, ?, ?)";
            PreparedStatement pst = this.connection.prepareStatement(query);
            pst.setInt(1, message.getMessageID());
            pst.setString(2, message.getSenderName());
            pst.setString(3, message.getSenderEmail());
            pst.setString(4, message.getMessageText());

            // Execute the update
            pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        } 
    }
	 
}
