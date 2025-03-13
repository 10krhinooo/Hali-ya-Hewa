package com.androiduser.ClimateBot.service;

import com.androiduser.ClimateBot.dto.chatRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AIServiceimpl implements OpenAIService {

    @Value("${OPENAI_API_KEY}")
    String APIKey;


    @Autowired
    RAGAssistance ragAssistance;


    @Override
    public String getResponse(chatRequest request) {
        return ragAssistance.chat(request.userId(), request.question());

    }
}


