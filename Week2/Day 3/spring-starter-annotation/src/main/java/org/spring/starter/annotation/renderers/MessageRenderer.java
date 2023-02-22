package org.spring.starter.annotation.renderers;

import org.spring.starter.annotation.providers.MessageProvider;

public interface MessageRenderer {
    void render();

    void setMessageProvider(MessageProvider provider);

    MessageProvider getMessageProvider();
}
