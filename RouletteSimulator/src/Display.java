public class Display {

  private boolean display = true;

  public void enterBank() {
    if (display) {
      System.out.println("Enter starting bank value:");
      System.out.print("£");
    }
  }

  public void possibleChips() {
    if (display) {
      System.out.println("0.5   1   2   5   10   20   50   100");
      System.out.println();
    }
  }

  public void commandFormat() {
    if (display) {
      System.out.println("Chip Placement (Flag FlagValue)");
      System.out.println();
    }
  }

  public void spinInfo(double chip, String placement, int spins) {
    if (display) {
      System.out.println("Chip: " + chip);
      System.out.println("Placement: " + placement);
      System.out.println("Spins: " + spins);
    }
  }

  public void displayOdds(double odds) {
    if (display) {
      System.out.println("Odds: " + odds);
      System.out.println();
    }
  }

  public void displayBank(Session session) {
    if (display) {
      session.displayBank();
    }
  }

  public void help() {
    if (display) {
      System.out.println("Examples: \"2 r\"   or   \"5 31\"   or   \"0.5 col1\"   or   \"20 1st12\"");
      System.out.println("b/B/black/Black");
      System.out.println("r/R/red/Red");
      System.out.println("e/E/even/Even");
      System.out.println("o/O/odd/Odd");
      System.out.println("1st12");
      System.out.println("2nd12");
      System.out.println("3rd12");
      System.out.println("column1/col1/c1");
      System.out.println("column2/col2/c2");
      System.out.println("column3/col3/c3");
      System.out.println("1to18");
      System.out.println("19to36");
    }
  }

  public void flags() {
    if (display) {
      System.out.println("Available flags:");
      System.out.println("-s (value)   - number of spins");
      System.out.println("-d           - double each time");
    }
  }

  public void displayNumber(NumberProperties numberProp, double chip, int number, int roll) {
    if (display) {
      char col = numberProp.getColour(number);
      boolean even = numberProp.isEven(number);

      System.out.println(" -" + (roll + 1) + "-");
      System.out.print(number);

      if (col == 'R') {
        System.out.print(" RED");
      } else if (col == 'B') {
        System.out.print(" BLACK");
      } else if (col == 'G') {
        System.out.print(" GREEN");
      } else {
        System.out.print(" colour not found");
      }

      if (even) {
        System.out.println(" EVEN");
      } else {
        System.out.println(" ODD");
      }

      System.out.println("CHIP: " + chip);
    }
  }

  public void displayWin(double chip, double odds) {
    if (display) {
      System.out.println("WIN: £" + chip * odds + " <----WIN----WIN----WIN----WIN-----");
    }
  }

  public void displayLoss(double chip) {
    if (display) {
      System.out.println("LOSS: £" + chip);
    }
  }

  public void displayStrategy(char strategy) {
    if (display) {
      if (strategy == 'd') {
        System.out.println("Double each time enabled");
      }
    }
  }

  public void displayResetStatistics() {
    if (display) {
      System.out.println("Statistics have been reset");
    }
  }


  public void displaySpinDivider() {
    if (display) {
      System.out.println("--------");
    }
  }
}
