package com.chat.openai.controller;

import com.chat.openai.entity.Conversation;
import com.chat.openai.provider.OpenAIProvider;
import com.chat.openai.service.ConversationService;
import io.swagger.annotations.*;
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
    @ApiOperation(value = "Take your coffee and ask Open AI", response = String.class)
    @ApiResponses(value = {
            @ApiResponse(
                    code = 400,
                    message = "Bad Request"),
            @ApiResponse(code = 500, message = "Internal Server Error")

    })
    public String askOpenAI(@ApiParam(value = "Enter your question here") @RequestParam String prompt) {
        return conversationService.createCompletion(prompt);
    }

    @GetMapping("/conversations")
    @ApiOperation(value = "Get your conversations history", response = List.class)
    public List<Conversation> getAllConversations() {
        return conversationService.getAllConversations();
    }
}
