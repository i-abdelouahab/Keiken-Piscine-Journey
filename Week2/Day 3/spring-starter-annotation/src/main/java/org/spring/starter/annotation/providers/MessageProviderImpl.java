package org.spring.starter.annotation.providers;

public class MessageProviderImpl implements MessageProvider {
    @Override
    public String getMessage() {
        return "Hello World";
    }
}