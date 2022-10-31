package hexlet.code.games;

import java.util.Random;
import java.util.Scanner;

public class GCD implements Game {

    private String playersName;
    public String getName() {

        return "GCD";
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

    private int getRandomNumber() {
        int maxNumber = 100;
        Random random = new Random();
        return random.nextInt(maxNumber);
    }

    private int getGCD(int firstNumber, int secondNumber) {
        if (firstNumber == 0) {
            return secondNumber;
        }

        if (secondNumber == 0) {
            return firstNumber;
        }

        if (firstNumber < secondNumber) {
            int tmp = firstNumber;
            firstNumber = secondNumber;
            secondNumber = tmp;
        }

        while (secondNumber != 0) {
            int tmp2 = firstNumber % secondNumber;
            firstNumber = secondNumber;
            secondNumber = tmp2;
        }
        return firstNumber;
    }
    public void startGame() {
        greeting();
        int rightAnswer;
        int userAnswer = 0;
        int firstNumber;
        int secondNumber;
        int counter = 0;
        System.out.println("Find the greatest common divisor of given numbers.");
        Scanner sc = new Scanner(System.in);
        while (counter != 3) {
            firstNumber = getRandomNumber();
            secondNumber = getRandomNumber();
            rightAnswer = getGCD(firstNumber, secondNumber);
            System.out.println("Question: " + firstNumber + " " + secondNumber);
            if (sc.hasNextInt()) {
                userAnswer = sc.nextInt();
                System.out.println("Your answer: " + userAnswer);
            }
            if (userAnswer == rightAnswer) {
                System.out.println("Correct!");
                counter++;
            } else {
                System.out.println("'"
                                 + userAnswer
                                 + "'"
                                 + " is wrong answer ;(. Correct answer was "
                                 + "'"
                                 + rightAnswer
                                 + "'");
                System.out.println("Let's try again, " + playersName + "!");
                return;
            }
        }
        System.out.println("Congratulations, " + playersName + "!");
    }
}
