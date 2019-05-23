import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean exit = false;

        NumberProperties numberProp = new NumberProperties();
        NumberGenerator numberGen = new NumberGenerator();
        DisplayMenu display = new DisplayMenu();

        Scanner scanner = new Scanner(System.in);

        display.enterBank();
        Session session = new Session(scanner.nextDouble());

        display.possibleChips();
        System.out.println();

        do {
            String command = scanner.nextLine();
            int chip;
            String placement;
            int spins = 1;



            if (!command.equals("exit")) {
                exit = true;
            } else {
                for (int roll = 0; roll < spins; roll++) {
                    int i = numberGen.generateNumber();

                    numberProp.getColour(i);
                    numberProp.isEven(i);
                    System.out.println("--------");
                }
            }

        } while (!exit);
    }
}
