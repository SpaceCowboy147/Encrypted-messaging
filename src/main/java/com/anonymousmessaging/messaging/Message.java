package com.anonymousmessaging.messaging;

import java.sql.Date;

public class Message {
    private String content;
    private String sender;
    private Date dateAndTime;

    public int getSentToUserId() {
        return sentToUserId;
    }

    public void setSentToUserId(int sentToUserId) {
        this.sentToUserId = sentToUserId;
    }

    private int sentToUserId;
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public Date getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(Date dateAndTime) {
        this.dateAndTime = dateAndTime;
    }



}
