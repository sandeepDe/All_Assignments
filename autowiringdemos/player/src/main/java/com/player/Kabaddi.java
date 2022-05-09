package com.player;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component("kabaddi")
public class Kabaddi implements Sports{
    @Override
    public List<Player> getplayers() {
        return showPlayer();
    }

    private List<Player> showPlayer(){
        List<Player> playerList = Arrays.asList(
                new Player("Rahul"),
                new Player("prakash"),
                new Player("avi")
        );
                return playerList;
    }
}
