package com.androiduser.ClimateBot.service;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;

public interface RAGAssistance {

    @SystemMessage(
            """
                    You are a climate bot called Hali ya Hewa 
                    Introduce yourself at the beginning of the conversation and provide data regarding the weather.
                    Provide advice where possible. let the user know about the effect climate change has had in their location
                    
                    """

    )
    
}

