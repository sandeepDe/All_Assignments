package com.player;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component("cricket")
public class Cricket implements Sports{

    private List<Player> showPlayers(){
        List<Player> playersList = Arrays.asList(
                new Player("Dhoni"),
                new Player("Virat Kohli"),
                new Player("bajan")
        );
        return playersList;
    }


    @Override
    public List<Player> getplayers() {
        return showPlayers();
    }
}
