package com.chat.openai.controller;

import com.chat.openai.entity.Conversation;
import com.chat.openai.provider.OpenAIProvider;
import com.chat.openai.service.ConversationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ConversationController {
    private OpenAIProvider openAIProvider;
    private ConversationService conversationService;

    public ConversationController(ConversationService conversationService) {
        this.conversationService = conversationService;
    }
    @PostMapping("/prompts")
    public String askOpenAI(@RequestParam String prompt) {
        return conversationService.createCompletion(prompt);
    }

    @GetMapping("/conversations")
    public List<Conversation> getAllConversations() {
        return conversationService.getAllConversations();
    }
}
