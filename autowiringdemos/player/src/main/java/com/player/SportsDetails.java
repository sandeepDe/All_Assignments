package com.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SportsDetails {

    List<Player> playerList= new ArrayList<Player>();

    @Autowired
    @Qualifier("cricket")
    Sports cricket;

    @Autowired
    @Qualifier("batminton")
    Sports batminton;

    @Autowired
    @Qualifier("kabaddi")
    Sports kabaddi;



    public List<Player> printPlayersList(String choice) {
        if (choice.equalsIgnoreCase("c"))
            playerList=cricket.getplayers();
        else if (choice.equalsIgnoreCase("b"))
            playerList= batminton.getplayers();
        else if  (choice.equalsIgnoreCase("k"))
            playerList=kabaddi.getplayers();

        return playerList;
    }
}



