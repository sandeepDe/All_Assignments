package com.spring.autowiring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ShapeFactory {


        @Autowired
         @Qualifier("rectangle")
        Shape shape ;

        //@Autowired


        @Autowired
        Shape rectangle;

        Shape triangle;

    public ShapeFactory(Shape triangle) {
        this.triangle = triangle;
    }


    void printArea(String choice, int x , int y){
            System.out.println("Printing area");
            if(choice.equalsIgnoreCase("t")){
                triangle.calcArea(10,20);

            }

        if(choice.equalsIgnoreCase("r")){
            rectangle.calcArea(10,20);

        }



    /*        shape.calcArea(10,20);
            rectangle.calcArea(5,2);
            triangle.calcArea(2,4);
*/
        }





    }

