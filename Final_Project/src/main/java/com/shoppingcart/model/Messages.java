package com.shoppingcart.model;

public class Messages {
    private int messageID;
    private String senderName;
    private String senderEmail;
    private String messageText;

    // Constructors, getters, and setters

    public Messages() {
    }

    public Messages(int messageID, String senderName, String senderEmail, String messageText) {
        this.messageID = messageID;
        this.senderName = senderName;
        this.senderEmail = senderEmail;
        this.messageText = messageText;
    }

    public int getMessageID() {
        return messageID;
    }

    public void setMessageId(int messageID) {
        this.messageID = messageID;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getSenderEmail() {
        return senderEmail;
    }

    public void setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }
}
