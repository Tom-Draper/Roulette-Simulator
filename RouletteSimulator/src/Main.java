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

        /* Exit program */
        if (command.equals("exit")) {
          exit = true;
          /* Reset statistics */
        } else if (command.equals("reset")){
          session.resetStatistics();
          /* Display help menu */
        } else if (command.equals("help")) {
          display.help();
          /* Spin command */
        } else {
          display.spinInfo(chip, placement, spins);

          if (chip != -1 && !placement.equals("-1")) { //Valid spin
            int odds = analyser.getWinOdds(placement);
            display.displayOdds(odds);

            /* Spins */
            for (int roll = 0; roll < spins; roll++) {
              /* Stop spinning if out of money */
              if (!session.subBank(chip)) {
                break;
              }

              int i = numberGen.generateNumber();
              numberProp.getColour(i);
              numberProp.isEven(i);

              /* Check for win or loss */
              if (resultProcessor.processResult(chip, placement, odds, i, session, numberProp)) {
                System.out.println("WIN " + chip * odds);
              } else {
                System.out.println("LOSS " + chip);
              }
              session.displayBank();
              System.out.println("--------");
            }
            session.displayStatistics();
          } else {
            System.out.println("Command invalid.");
          }
        }
    } while (!exit);
  }
}
