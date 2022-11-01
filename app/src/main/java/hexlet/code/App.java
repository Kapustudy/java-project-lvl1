package hexlet.code;
import hexlet.code.games.Game;
import hexlet.code.games.Greet;
import hexlet.code.games.GCD;
import hexlet.code.games.Progression;
import hexlet.code.games.Even;
import hexlet.code.games.Prime;
import hexlet.code.games.Calc;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Game game;
        Game[] listOfGames = {new Greet(), new Even(), new Calc(), new GCD(), new Progression(), new Prime()};

        game = choosingGame(listOfGames);
        if (game != null) {
            game.startGame();
        }
    }

    private static Game choosingGame(Game[] listOfGames) {
        int gameNumber = 0;
        final int greetNumber = 1;
        final int evenNumber = 2;
        final int calcNumber = 3;
        final int gcdNumber = 4;
        final int progressionNumber = 5;
        final int primeNumber = 6;

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
            case greetNumber : return new Greet();
            case evenNumber : return new Even();
            case calcNumber : return  new Calc();
            case gcdNumber : return  new GCD();
            case progressionNumber : return new Progression();
            case primeNumber : return new Prime();
            default: return null;
        }
    }
}
