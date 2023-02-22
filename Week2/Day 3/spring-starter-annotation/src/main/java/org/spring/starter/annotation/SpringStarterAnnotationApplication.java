package org.spring.starter.annotation;

import org.spring.starter.annotation.renderers.MessageRenderer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringStarterAnnotationApplication {

	public static void main(String[] args) {
		ApplicationContext context =
				new AnnotationConfigApplicationContext
						(SpringStarterAnnotationApplicationConfig.class);
		MessageRenderer messageRenderer = context.getBean("renderer", MessageRenderer.class);
		messageRenderer.render();

	}

}
