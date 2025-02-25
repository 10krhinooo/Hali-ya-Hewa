package com.androiduser.ClimateBot.service;

import com.androiduser.ClimateBot.controller.dto.chatRequest;

public interface OpenAIService {

    String getResponse(chatRequest request);


}
