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
      int odds = -1;

      if (!placement.equals("-1")) {
        odds = analyser.getWinOdds(placement);
      }
      int spins = analyser.getSpins(command);
      
        if (command.equals("exit")) {
          exit = true;
        } else if (command.equals("reset")){
          session.resetStatistics();
        } else if (command.equals("help")) {
          display.help();
        } else {
          display.spinInfo(chip, placement, odds, spins);

          if (chip != -1 && !placement.equals("-1") && odds != -1) {
            int i;

            for (int roll = 0; roll < spins; roll++) {
              if (!session.subBank(chip)) {
                break;
              }

              i = numberGen.generateNumber();
              numberProp.getColour(i);
              numberProp.isEven(i);

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
