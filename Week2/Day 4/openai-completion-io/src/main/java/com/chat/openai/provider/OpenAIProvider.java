package com.chat.openai.provider;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;
import org.springframework.stereotype.Service;

@Service
public class OpenAIProvider {
    public String askOpenAI(String prompt) {
        //SpringApplication.run(OpenaiCompletionIoApplication.class, args);
        String token = System.getenv("OPENAI_API_KEY");
        if (token == null) {
            System.err.println("OPENAI_API_KEY environment variable not set");
            System.exit(1);
        }

        OpenAiService service = new OpenAiService(token);

        System.out.println("\nCreating completion...");
        CompletionRequest completionRequest = CompletionRequest.builder()
                .model("text-davinci-003")
                .prompt(prompt)
                .maxTokens(1000)
                .echo(false)
                .user("testing")
                .n(1)
                .build();
        String response = service.createCompletion(completionRequest).getChoices().get(0).getText().trim();
        return response;
    }
}

