package com.chat.openai.controller;

import com.chat.openai.entity.Conversation;
import com.chat.openai.service.ConversationService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ConversationController.class)
public class ConversationControllerTest {

    @Mock
    private ConversationService conversationService;

    @InjectMocks
    private ConversationController conversationController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testAskOpenAI() throws Exception {
        String prompt = "What is the meaning of life?";
        String response = "The meaning of life is 42.";

        when(conversationService.createCompletion(prompt)).thenReturn(response);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/prompts")
                        .param("prompt", prompt)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(response));
    }

    @Test
    public void testGetAllConversations() throws Exception {
        List<Conversation> conversations = new ArrayList<>();
        Conversation conversation1 = new Conversation();
        conversation1.setId(1);
        conversation1.setPrompt("Hello");
        conversation1.setResponse("Hi");
        Conversation conversation2 = new Conversation();
        conversation2.setId(2);
        conversation2.setPrompt("How are you?");
        conversation2.setResponse("I'm good, thanks.");
        conversations.add(conversation1);
        conversations.add(conversation2);

        when(conversationService.getAllConversations()).thenReturn(conversations);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/conversations")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1L))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].prompt").value("Hello"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].response").value("Hi"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].id").value(2L))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].prompt").value("How are you?"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].response").value("I'm good, thanks."));
    }
}
