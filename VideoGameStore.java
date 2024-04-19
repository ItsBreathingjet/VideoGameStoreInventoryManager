import java.io.*;
import java.util.*;

public abstract class VideoGameStore {
    private List<Game> games;

    public VideoGameStore() {
        this.games = new ArrayList<>();
    }

    public void addGame(Game game) {
        games.add(game);
    }

    public void displayGames() {
        for (Game game : games) {
            System.out.println(game);
        }
    }
}







































    
