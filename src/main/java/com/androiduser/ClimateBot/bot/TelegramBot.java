package com.androiduser.ClimateBot.bot;

import com.androiduser.ClimateBot.service.EmbeddingComponentService;
import com.androiduser.ClimateBot.service.RAGAssistance;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class TelegramBot extends TelegramLongPollingBot {

    private final String botName;

    @Autowired
    private RAGAssistance ragAssistance;

    @Autowired
    private EmbeddingComponentService embeddingComponentService;

    public TelegramBot(String botName, String botToken) {
        super(botToken);
        this.botName = botName;
    }

    @PostConstruct
    public void initializeEmbedding() {
        new Thread(() -> {
            try {
                embeddingComponentService.loadDocument();
                System.out.println("Documents successfully embedded.");
            } catch (Exception e) {
                System.err.println("Error embedding documents: " + e.getMessage());
            }
        }).start();
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            Message message = update.getMessage();
            var chatid = message.getChatId();
            var messageText = message.getText();

            var response = ragAssistance.chat(chatid, messageText);
            try {
                execute(new SendMessage(chatid.toString(), response));
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public String getBotUsername() {
        return "dondooBot";
    }
}
