package com.spring.autowiring;

import org.springframework.stereotype.Component;

@Component
public class Triangle implements Shape{

    @Override
    public void calcArea(int x, int y) {
        System.out.println( (x *y) /2);

    }
}
