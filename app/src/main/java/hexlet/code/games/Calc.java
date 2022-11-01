package hexlet.code.games;

import java.util.Random;
import java.util.Scanner;

public class Calc implements Game {

    private String playersName;
    public String getName() {

        return "Calc";
    }
    private void greeting() {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextLine()) {
            playersName = sc.nextLine();
            System.out.println("Hello, " + playersName + "!");
        }
    }
    private char getRandomOperator() {
        int maxNumber = 3;
        Random random = new Random();
        int operatorNumber = random.nextInt(maxNumber);
        switch (operatorNumber) {
            case 0 : return '+';
            case 1 : return '-';
            default : return '*';
        }
    }

    private int getRandomNumber() {
        int maxNumber = 100;
        Random random = new Random();
        return random.nextInt(maxNumber);
    }

    private int makeOperation (int firstNumber, int secondNumber, char operator) {
        switch (operator) {
            case '+' : return firstNumber + secondNumber;
            case '-' : return  firstNumber - secondNumber;
            default : return firstNumber * secondNumber;
        }
    }

    public void startGame() {
        greeting();
        int rightAnswer;
        int userAnswer = 0;
        int firstNumber;
        int secondNumber;
        char operator;
        int counter = 0;
        System.out.println("What is the result of the expression?");
        Scanner sc = new Scanner(System.in);
        while (counter != 3) {
            firstNumber = getRandomNumber();
            secondNumber = getRandomNumber();
            operator = getRandomOperator();
            rightAnswer = makeOperation(firstNumber, secondNumber, operator);
            System.out.println("Question: " + firstNumber + " " + operator + " " + secondNumber);
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
