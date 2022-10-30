package hexlet.code.games;

import java.util.Scanner;

public class Greet implements Game {

    public String getName() {
        return "Greet";
    }

    private void greeting() {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextLine()) {
            System.out.println("Hello, " + sc.nextLine());
        }
    }
    public void startGame() {
       greeting();
    }
}
