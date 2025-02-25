package com.androiduser.ClimateBot.bot;

import com.androiduser.ClimateBot.service.RAGAssistance;
import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;

public class TelegramBot extends TelegramLongPollingBot {

    private final String botName;
    @Autowired
    RAGAssistance ragAssistance;


    public TelegramBot(String botName, String botToken) {
        super(botToken);
        this.botName = botName;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() || update.getMessage().hasText()) {
            Message message = update.getMessage();

            var chatid = message.getChatId();
            var messageText = message.getText();

//            System.out.print(messageText);

            var response = ragAssistance.chat(chatid, messageText);
            try {
                execute(new SendMessage(chatid.toString(), response));
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }

        }

    }

    @Override
    public void onUpdatesReceived(List<Update> updates) {

        super.onUpdatesReceived(updates);
    }

    @Override
    public String getBotUsername() {

        return "dondooBot";
    }

    @Override
    public void onRegister() {

        super.onRegister();
    }
}
