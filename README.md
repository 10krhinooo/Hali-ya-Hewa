# Hali ya Hewa

**Hali ya Hewa** is an AI-powered Telegram chatbot that delivers personalized, location-specific climate change data and insights. Built using cutting-edge technologies like Large Language Models (LLMs), Retrieval-Augmented Generation (RAG), and a robust Spring Boot backend, ClimateChat is designed to keep you informed about the local impacts of climate change.

## Features

- **Personalized Local Insights:**  
  Receive tailored information about climate trends and environmental changes based on your location.
  
- **Real-Time Data & Analysis:**  
  Leverages RAG to fetch and generate up-to-date climate data, ensuring context-aware and accurate responses.
  
- **Actionable Information:**  
  Understand how climate change affects your community with forecasts and analysis to support informed decisions.
  
- **Seamless Telegram Integration:**  
  Interact effortlessly via Telegram, making staying informed on the go convenient.
  
- **Scalable Backend:**  
  Powered by Spring Boot, ensuring a reliable and maintainable architecture for future enhancements.

## Tech Stack

- **LLMs:** For natural language understanding and generation i.e OpenAi
- **RAG:** For integrating real-time climate data.
- **Spring Boot:** For building a robust and scalable backend.
- **Telegram Bot API:** For user interaction on Telegram.

## Getting Started

### Prerequisites

- Java 11 or higher
- Maven
- A Telegram account and Bot API token

### Installation

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/10krhinooo/Climate-bot.git
   cd climate-Bot 

2. **Update the application.properties file with your telegram bot.token, bot.name(the username for your bot ) , and the openAI API key:**
   ````bash
   bot.token= {YOUR bOT  token }
   bot.name= {your bot username}
   langchain4j.open-ai.chat-model.api-key= {openai API key }

3. **load the maven dependencies**
   ````bash
   mvn install

   
4. **Load the documents into the documents directory**
5. **Run the app**


   
