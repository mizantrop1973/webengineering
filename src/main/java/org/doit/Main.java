package org.doit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
       // Variant with xml config context.xml
       ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
       //Variant with java config
       //ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);

        // set default ID simpleMessageRenderer in variant with component!!!
        MessageRenderer renderer = context.getBean("simpleMessageRenderer", MessageRenderer.class);
        renderer.render();
    }
}