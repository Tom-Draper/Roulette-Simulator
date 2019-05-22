import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        NumberProperties numberProp = new NumberProperties();
        NumberGenerator numberGen = new NumberGenerator();
        Display display = new Display();

        Scanner scanner = new Scanner(System.in);

        display.enterBank();
        Session session = new Session(scanner.nextDouble());

        display.possibleChips();
        System.out.println();
        for (int roll = 0; roll < 10; roll++) {

            int i = numberGen.generateNumber();
            numberProp.getColour(i);
            numberProp.isEven(i);
            System.out.println("--------");
        }
    }
}
