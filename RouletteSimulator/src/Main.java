import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    boolean exit = false;
    boolean lose;

    NumberProperties numberProp = new NumberProperties();
    NumberGenerator numberGen = new NumberGenerator();
    Display display = new Display();
    InputAnalyser analyser = new InputAnalyser();
    ResultProcessor resultProcessor = new ResultProcessor();
    Strategy strategy = new Strategy();

    Scanner scanner = new Scanner(System.in);

    display.enterBank();
    Session session = new Session(scanner.nextDouble());

    display.possibleChips();
    display.commandFormat();

    do {
      scanner = new Scanner(System.in);
      String command = scanner.nextLine();

      double initialChip = analyser.getChip(command);
      double chip = initialChip;
      String placement = analyser.getPlacement(command);
      int spins = analyser.getSpins(command);
      char strat = analyser.getStrategy(command, spins);

      display.displayStrategy(strat);

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
        } else if (command.equals("flags")) {
          display.flags();
        } else {
          display.spinInfo(chip, placement, spins);

          if (chip != -1 && !placement.equals("-1")) { //Valid spin
            int odds = analyser.getWinOdds(placement);
            int realSpins = spins;
            display.displayOdds(odds);

            /* Spins */
            for (int roll = 0; roll < spins; roll++) {
              /* Stop spinning if out of money */
              if (!session.subBank(chip)) {
                realSpins = roll; //Record spins taken
                break;
              }

              int number = numberGen.generateNumber(); //Generate number

              /* Display number, black/red, odd/even */
              display.displayNumber(numberProp, chip, number, roll);

              /* Check for win or loss */
              if (resultProcessor.processResult(chip, placement, odds, number, session, numberProp)) {
                display.displayWin(chip, odds);
                lose = false;
              } else {
                display.displayLoss(chip);
                lose = true;
              }

              /* Strategies */
              if (strat == 'd') {
                chip = strategy.doubleEachTime(chip, initialChip, lose);
              }

              session.displayBank();
              System.out.println("--------");
            }
            session.displayStatistics(realSpins, odds);
          } else {
            System.out.println("Command invalid.");
          }
        }
    } while (!exit);
  }
}
