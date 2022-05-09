package com.spring.autowiring;

import org.springframework.stereotype.Component;

@Component
public class Rectangle implements Shape{

    @Override
    public void calcArea(int x, int y) {

        System.out.println("In Rectangle");
        System.out.println(x*y);

    }
}
