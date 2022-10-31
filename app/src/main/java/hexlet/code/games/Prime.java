package hexlet.code.games;

import java.util.Random;
import java.util.Scanner;

public class Prime implements Game {

    private String playersName;
    public String getName() {

        return "Prime";
    }
    private void greeting() {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextLine()) {
            playersName = sc.nextLine();
            System.out.println("Hello, " + playersName);
        }
    }
    private int getRandom() {
        int maxNumber = 100;
        Random random = new Random();
        return random.nextInt(maxNumber);
    }

    private String rightAnswer(int number) {
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return "no";
            }
        }
        return  "yes";
    }
    public void startGame() {
        greeting();
        String answer = "";
        int number;
        int counter = 0;
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
        Scanner sc = new Scanner(System.in);
        while (counter != 3) {
            number = getRandom();
            System.out.println("Question: " + number);
            if (sc.hasNextLine()) {
                answer = sc.nextLine();
                System.out.println("Your answer: " + answer);
            }
            if (answer.equals(rightAnswer(number))) {
                System.out.println("Correct!");
                counter++;
            } else {
                System.out.println("'"
                                 + answer
                                 + "'"
                                 + " is wrong answer ;(. Correct answer was "
                                 + "'"
                                 + rightAnswer(number)
                                 + "'");
                System.out.println("Let's try again, " + playersName + "!");
                return;
            }
        }
        System.out.println("Congratulations, " + playersName + "!");
    }
}
