package org.spring.starter.annotation.renderers;

import org.spring.starter.annotation.providers.MessageProvider;

public class MessageRendererImpl implements MessageRenderer {
    private MessageProvider messageProvider;
    @Override
    public void render() {
        if (messageProvider==null) {
            throw new RuntimeException("You must set the property messageProvider of class:"+MessageRendererImpl.class.getName());
        }
        System.out.println(messageProvider.getMessage());
    }

    @Override
    public void setMessageProvider(MessageProvider provider) {
        this.messageProvider = provider;
    }

    @Override
    public MessageProvider getMessageProvider() {
        return this.messageProvider;
    }
}
