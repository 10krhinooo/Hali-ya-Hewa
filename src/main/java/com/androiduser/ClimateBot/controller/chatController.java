package com.androiduser.ClimateBot.controller;


import com.androiduser.ClimateBot.controller.dto.chatRequest;
import com.androiduser.ClimateBot.controller.dto.chatResponse;
import com.androiduser.ClimateBot.service.OpenAIService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/chat")
public class chatController {

    @Autowired
    OpenAIService OpenAIService;

    @PostMapping("/create")
    public chatResponse getChatResponse(@RequestBody chatRequest request) {
        return new chatResponse(OpenAIService.getResponse(request));

    }


}
