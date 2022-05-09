package com.spring.autowiring;


import org.springframework.stereotype.Component;

@Component("Squaree")

public class Square implements Shape{
    @Override
    public void calcArea(int x, int y) {
        System.out.println(x*y);

    }
}
