package com.androiduser.ClimateBot.service;

import com.androiduser.ClimateBot.dto.chatRequest;

public interface OpenAIService {

    String getResponse(chatRequest request);


}
