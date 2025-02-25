package com.androiduser.ClimateBot.controller;


import com.androiduser.ClimateBot.service.EmbeddingComponentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LoadController {

    @Autowired
    EmbeddingComponentService embeddingComponentService;


    @GetMapping("/loadDocument")
    public void loadSingle() {
        embeddingComponentService.loadSingleDocument();
    }
}
