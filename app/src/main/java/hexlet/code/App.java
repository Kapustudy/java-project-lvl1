package hexlet.code;
import hexlet.code.games.Calc;
import hexlet.code.games.Game;
import hexlet.code.games.Greet;
import hexlet.code.games.Even;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Game game;
        Game[] listOfGames = {new Greet(), new Even(), new Calc()};

        game = choosingGame(listOfGames);
        if (game != null) {
            game.startGame();
        }
    }

    private static Game choosingGame(Game[] listOfGames) {
        int gameNumber = 0;
        System.out.println("Please enter the game number and press Enter.");
        if (listOfGames == null) {
            return null;
        }
        for (int i = 0; i < listOfGames.length; i++) {
            System.out.println((i + 1) + " - " + listOfGames[i].getName());
        }
        System.out.println("0 - Exit");
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            gameNumber = sc.nextInt();
            System.out.println("Your choice: " + gameNumber);
        }
        switch (gameNumber) {
            case 1 : return new Greet();
            case 2 : return new Even();
            case 3 : return  new Calc();
            default: return null;
        }
    }
}
