package main;

import gameUI.GameFrame;
import model.*;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Manager gameManager;
    private GameFrame gameFrame;
    private List<Player> players;

    public Game() {
        //  players
        players = new ArrayList<>();
        players.add(new Player("Player1"));
        players.add(new Player("Player2"));

        //  game manager
        gameManager = new Manager(players);

        //  game interface
        gameFrame = new GameFrame();
    }

    public static void main(String[] args) {
        new Game();
    }
}