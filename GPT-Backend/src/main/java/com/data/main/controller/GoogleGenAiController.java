package com.data.main.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class GoogleGenAiController 
{
	 private final ChatClient chatClient;

	    public GoogleGenAiController(ChatClient.Builder builder) {
	        this.chatClient = builder.build();
	    }

	    @GetMapping("/api/{message}")
	    public String chat(@PathVariable String message) 
	    {
//	    	String message="Tell me a joke!";
	        return chatClient.prompt()
	                .user(message)
	                .call()
	                .content();
	    }
	

}
