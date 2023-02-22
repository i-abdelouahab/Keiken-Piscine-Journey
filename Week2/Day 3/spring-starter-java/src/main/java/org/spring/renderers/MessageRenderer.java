package org.spring.renderers;

import org.spring.providers.MessageProvider;

public interface MessageRenderer {
    void render();

    void setMessageProvider(MessageProvider provider);

    MessageProvider getMessageProvider();
}
