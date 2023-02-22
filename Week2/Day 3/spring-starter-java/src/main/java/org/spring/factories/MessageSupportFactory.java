package org.spring.factories;

import org.spring.providers.MessageProvider;
import org.spring.renderers.MessageRenderer;

import java.io.IOException;
import java.util.Properties;

public class MessageSupportFactory {
    public static MessageSupportFactory instance;
    private Properties props;
    private MessageRenderer renderer;
    private MessageProvider provider;
    private MessageSupportFactory() {
        props = new Properties();
        try {
            props.load(this.getClass().getResourceAsStream("/msf.properties"));
            String renderClass = props.getProperty("render.class");
            String providerClass = props.getProperty("provider.class");
            renderer = (MessageRenderer) Class.forName(renderClass).newInstance();
            provider = (MessageProvider) Class.forName(providerClass).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static {
        instance = new MessageSupportFactory();
    }

    public static MessageSupportFactory getInstance() {
        return instance;
    }

    public MessageRenderer getMessageRenderer() {
        return renderer;
    }

    public MessageProvider getMessageProvider() {
        return provider;
    }
}
