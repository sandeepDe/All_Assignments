package com.spring.autowiring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class ShapeMain {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.spring");
        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out:: println);
        ShapeFactory shapeFactory =(ShapeFactory) context.getBean("shapeFactory");




       shapeFactory.printArea("t",10,20);
       shapeFactory.printArea("s",12,2);
       shapeFactory.printArea("r",10,5);



    }
}
