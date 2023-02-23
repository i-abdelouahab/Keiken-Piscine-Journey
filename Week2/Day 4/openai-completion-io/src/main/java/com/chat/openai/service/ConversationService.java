package com.chat.openai.service;

import com.chat.openai.entity.Conversation;
import com.chat.openai.provider.OpenAIProvider;
import com.chat.openai.repository.ConversationRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class ConversationService {

    private ConversationRepository conversationRepository;

    public ConversationService(ConversationRepository conversationRepository) {
        this.conversationRepository = conversationRepository;
    }

    public String createCompletion(String prompt) {
        OpenAIProvider openAIProvider = new OpenAIProvider();
        String completed = openAIProvider.askOpenAI(prompt);
        Conversation conversation = Conversation.builder()
                .prompt(prompt)
                .response(completed)
                .createdAt(LocalDateTime.now())
                .build();
        conversationRepository.save(conversation);
        return completed;
    }

    public List<Conversation> getAllConversations() {
        return conversationRepository.findAll();
    }
}
