import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean exit = false;

        NumberProperties numberProp = new NumberProperties();
        NumberGenerator numberGen = new NumberGenerator();
        DisplayMenu display = new DisplayMenu();
        InputAnalyser analyser = new InputAnalyser();
        ResultProcessor resultProcessor = new ResultProcessor();

        Scanner scanner = new Scanner(System.in);

        display.enterBank();
        Session session = new Session(scanner.nextDouble());

        display.possibleChips();
        System.out.println();

        do {
            scanner = new Scanner(System.in);
            String command = scanner.nextLine();

            double chip = analyser.getChip(command);
            String placement = analyser.getPlacement(command);
            int spins = analyser.getSpins(command);

            System.out.println(chip);
            System.out.println(placement);
            System.out.println(spins);
            System.out.println();

            if (chip != -1 && !placement.equals("-1")) {
                if (command.equals("exit")) {
                    exit = true;
                } else {
                    int i;

                    for (int roll = 0; roll < spins; roll++) {
                        i = numberGen.generateNumber();

                        numberProp.getColour(i);
                        numberProp.isEven(i);
                        System.out.println("--------");

                        if (resultProcessor.processResult(chip, placement, i, session)) {
                            System.out.println("WIN");
                        } else {
                            System.out.println("LOSS");
                        }
                    }
                }
            } else {
                System.out.println("Command invalid.");
            }

        } while (!exit);
    }
}
