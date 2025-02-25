package com.androiduser.ClimateBot.service;

import com.androiduser.ClimateBot.controller.dto.chatRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AIServiceimpl implements OpenAIService {

    @Value("${langchain4j.open-ai.chat-model.api-key}")
    String APIKey;


    @Autowired
    RAGAssistance ragAssistance;


    @Override


    public String getResponse(chatRequest request) {
        return ragAssistance.chat(request.userId(), request.question());

    }
}

    /*public String getResponseSimple(chatRequest request) {
        List<ChatMessage> messages = new ArrayList<>();
        messages.add(UserMessage.userMessage(request.question()));
       var model= OpenAiChatModel.builder()
               .apiKey(APIKey)
               .modelName(OpenAiChatModelName.GPT_3_5_TURBO)
                .build();

        return model.generate(messages).content().text();
    }
}*/
