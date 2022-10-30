package hexlet.code;
import java.util.Scanner;

public class Cli {
    public static void interview() {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextLine()) {
            System.out.println("Hello, " + sc.nextLine());
        }
    }
}
