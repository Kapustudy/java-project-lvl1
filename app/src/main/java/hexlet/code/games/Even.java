package hexlet.code.games;
import java.util.Scanner;
import java.util.Random;

public final class Even implements Game {

    private String playersName;
    private final int winCount = 3;

    public String getName() {

        return "Even";
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
    private int getRandom() {
        final int maxNumber = 100;
        Random random = new Random();
        return random.nextInt(maxNumber);
    }

    private String rightAnswer(int number) {
        if (number % 2 == 0) {
            return "yes";
        }
        return  "no";
    }
    public void startGame() {
        greeting();
        String answer = "";
        int number;
        int counter = 0;
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        Scanner sc = new Scanner(System.in);
        while (counter != winCount) {
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
