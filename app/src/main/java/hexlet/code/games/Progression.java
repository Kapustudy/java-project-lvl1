package hexlet.code.games;

import java.util.Random;
import java.util.Scanner;

public class Progression implements Game {

    private String playersName;
    public String getName() {

        return "Progression";
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

    private int getRandomNumber(int minNumber, int maxNumber) {
        Random random = new Random();
        return random.nextInt(maxNumber - minNumber + 1) + minNumber;
    }

    private int[] genProgression (int startNumber, int step, int numberOfElements) {
        int[] result = new int[numberOfElements];
        for (int i = 0; i < result.length; i++) {
            result[i] = startNumber;
            startNumber = startNumber + step;

        }
        return result;
    }


    public void startGame() {
        greeting();

        int userAnswer = 0;
        int startNumer;
        int step;
        int numberOfElements;
        int[] progression;
        int secretNumber;
        int counter = 0;
        System.out.println("What number is missing in the progression?");
        Scanner sc = new Scanner(System.in);
        while (counter != 3) {
            startNumer = getRandomNumber(1, 10);
            step = getRandomNumber(1,10);
            numberOfElements = getRandomNumber(5, 10);
            progression = genProgression(startNumer, step, numberOfElements);
            secretNumber = getRandomNumber(0, progression.length - 1);
            System.out.print("Question: " );
            for (int i = 0; i < progression.length; i++) {
                if (i == secretNumber) {
                    System.out.print(".. ");
                    continue;
                }
                System.out.print(progression[i] + " ");
            }
            System.out.println();
            if (sc.hasNextInt()) {
                userAnswer = sc.nextInt();
                System.out.println("Your answer: " + userAnswer);
            }
            if (userAnswer == progression[secretNumber]) {
                System.out.println("Correct!");
                counter++;
            } else {
                System.out.println("'"
                                 + userAnswer
                                 + "'"
                                 + " is wrong answer ;(. Correct answer was "
                                 + "'"
                                 + progression[secretNumber]
                                 + "'");
                System.out.println("Let's try again, " + playersName + "!");
                return;
            }
        }
        System.out.println("Congratulations, " + playersName + "!");
    }
}
