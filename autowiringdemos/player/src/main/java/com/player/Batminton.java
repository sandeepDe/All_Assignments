package com.player;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component("batminton")
public class Batminton implements Sports{
    @Override
    public List<Player> getplayers() {
        return showPlayer();
    }

    private List<Player> showPlayer(){
        List<Player> playerList = Arrays.asList(
                new Player("player1"),
                new Player("player2"),
                new Player("player3")
        );
        return playerList;
    }
}
