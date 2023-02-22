package org.spring.springstarterxml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringStarterXmlApplication {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
		MessageRenderer messageRenderer = context.getBean("renderer", MessageRenderer.class);
		messageRenderer.render();
	}

}
