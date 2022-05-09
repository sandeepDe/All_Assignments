package com.player;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.stream.Stream;

public class MainDemo {
    public static void  main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.player");

        SportsDetails sportsDetails = (SportsDetails) context.getBean("sportsDetails");

        List<Player> playersList = sportsDetails.printPlayersList("c");
        List<Player> playersList1 = sportsDetails.printPlayersList("b");
        List<Player> playersList2 = sportsDetails.printPlayersList("k");


        Stream.of(playersList).forEach(System.out::println);
        Stream.of(playersList1).forEach(System.out::println);
        Stream.of(playersList2).forEach(System.out::println);


    }
}