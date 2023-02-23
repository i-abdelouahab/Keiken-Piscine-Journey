package com.chat.openai;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class OpenaiCompletionIoApplication {

    public static void main(String[] args) {

        SpringApplication.run(OpenaiCompletionIoApplication.class, args);

    }

}
