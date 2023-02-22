package org.spring;

import org.spring.factories.MessageSupportFactory;
import org.spring.providers.MessageProvider;
import org.spring.renderers.MessageRenderer;

public class Main {
    public static void main(String[] args) {
        MessageProvider messageProvider = MessageSupportFactory.getInstance().getMessageProvider();
        MessageRenderer messageRenderer = MessageSupportFactory.getInstance().getMessageRenderer();
        messageRenderer.setMessageProvider(messageProvider);
        messageRenderer.render();
    }
}