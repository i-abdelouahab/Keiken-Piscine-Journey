package org.spring.providers;

public class MessageProviderImpl implements MessageProvider {
    @Override
    public String getMessage() {
        return "Hello World";
    }
}
