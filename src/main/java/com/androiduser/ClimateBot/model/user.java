package com.androiduser.ClimateBot.model;


import org.springframework.data.annotation.Id;

public class user {


    @Id
    Long chatId;
    String From;

    public Long getChatId() {
        return chatId;
    }

    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }

    public String getFrom() {
        return From;
    }

    public void setFrom(String from) {
        From = from;
    }
}