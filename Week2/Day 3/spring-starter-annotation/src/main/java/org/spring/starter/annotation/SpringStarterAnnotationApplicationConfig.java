package org.spring.starter.annotation;

import org.spring.starter.annotation.providers.MessageProvider;
import org.spring.starter.annotation.providers.MessageProviderImpl;
import org.spring.starter.annotation.renderers.MessageRenderer;
import org.spring.starter.annotation.renderers.MessageRendererImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringStarterAnnotationApplicationConfig {
    // equivalent to <bean id="provider" class=".."/>
    @Bean
    public MessageProvider provider() {
        return new MessageProviderImpl();
    }
    // equivalent to <bean id="renderer" class=".."/>
    @Bean
    public MessageRenderer renderer(){
        MessageRenderer renderer = new MessageRendererImpl();
        renderer.setMessageProvider(provider());
        return renderer;
    }
}
