import java.util.Arrays;
import java.util.List;

/**
 * Collection of functions that can extract options from a command entered.
 */
public class InputAnalyser {

  public List<Character> strategyFlags = Arrays.asList('d'); //Hold usable strategy flags

  /**
   * Returns whether the string entered is numeric.
   */
  public boolean isNumeric(String string) {
    try {
      Double.parseDouble(string);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }

  public int getFlagValue(String input, char flag) {
    StringBuilder buildSpins = new StringBuilder();

    try {
      for (int i = 0; i < input.length(); i++) { //To find the flag
        if (i + 1 != input.length() - 1) {
          if (input.charAt(i) == '-' && (input.charAt(i + 1) == flag)) {
            for (int j = i + 3; j < input.length(); j++) { //Starting on first digit of spins value
              buildSpins.append(input.charAt(j));

              if (j != input.length() - 1) {
                if (input.charAt(j + 1) == ' ') { //Ending when next space comes
                  break;
                }
              }
            }
            break;
          }
        }
      }
    } catch (IndexOutOfBoundsException e) {
      System.out.println("Error: getting spins from input");
    }

    if (isNumeric(buildSpins.toString())) {
      return Integer.parseInt(buildSpins.toString());
    }

    return -1;
  }

  public double getChip(String input) {
    int i = 0;
    StringBuilder buildChip = new StringBuilder();

    if (Character.isDigit(input.charAt(i))) {
      try {
        if (input.length() > 1) {
          while (input.charAt(i) != ' ') {
            buildChip.append(input.charAt(i));
            i++;
          }
        }

        if (isNumeric(buildChip.toString())) {
          return Double.parseDouble(buildChip.toString());
        }
      } catch (IndexOutOfBoundsException e) {
        System.out.println("Error: getting chip from input");
      }
    }

    return -1;
  }

  public char getStrategy(String input, int spins) {
    if (spins > 1) {
      try {
        for (int i = 0; i < input.length(); i++) {
          if (i != input.length() - 1) {
            if (input.charAt(i) == '-' && strategyFlags.contains(input.charAt(i + 1))) {
              return input.charAt(i + 1);
            }
          }
        }
      } catch (IndexOutOfBoundsException e) {
        System.out.println("Error: getting strategy from input");
      }
    }

    return 1;
  }


  private boolean checkPlacementRed(String placement) {
    if (placement.equals("r") || placement.equals("R") || placement.equals("red") || placement.equals("Red")) {
      return true;
    }
    return false;
  }

  private boolean checkPlacementBlack(String placement) {
    if (placement.equals("b") || placement.equals("B") || placement.equals("black") || placement.equals("Black")) {
      return true;
    }
    return false;
  }

  private boolean checkPlacementEven(String placement) {
    if (placement.equals("e") || placement.equals("E") || placement.equals("even") || placement.equals("Even")) {
      return true;
    }
    return false;
  }

  private boolean checkPlacementOdd(String placement) {
    if (placement.equals("o") || placement.equals("O") || placement.equals("odd") || placement.equals("Odd")) {
      return true;
    }
    return false;
  }

  private boolean checkPlacementCol1(String placement) {
    if (placement.equals("column1") || placement.equals("col1") || placement.equals("c1")) {
      return true;
    }
    return false;
  }

  private boolean checkPlacementCol2(String placement) {
    if (placement.equals("column2") || placement.equals("col2") || placement.equals("c2")) {
      return true;
    }
    return false;
  }

  private boolean checkPlacementCol3(String placement) {
    if (placement.equals("column3") || placement.equals("col3") || placement.equals("c3")) {
      return true;
    }
    return false;
  }

  private boolean validPlacement(String placement) {
    try {
      if (checkPlacementRed(placement) || checkPlacementBlack(placement) ||
              checkPlacementEven(placement) || checkPlacementOdd(placement) ||
              checkPlacementCol1(placement) || checkPlacementCol2(placement) || checkPlacementCol3(placement) ||
              placement.equals("1st12") || placement.equals("2nd12") || placement.equals("3rd12") ||
              placement.equals("1to18") || placement.equals("19to36")) {
        return true;
      } else if (Integer.parseInt(placement) > -1 && Integer.parseInt(placement) < 37) {
        return true;
      }
    } catch (NumberFormatException e) {
      System.out.println("Error: invalid placement input");
    }

    return false;
  }

  private String formatPlacement(String placement) {
    if (checkPlacementRed(placement)) {
      return "r";
    } else if (checkPlacementBlack(placement)) {
      return "b";
    } else if (checkPlacementEven(placement)) {
      return "e";
    } else if (checkPlacementOdd(placement)) {
      return "o";
    } else if (checkPlacementCol1(placement)) {
      return "c1";
    } else if (checkPlacementCol2(placement)) {
      return "c2";
    } else if (checkPlacementCol3(placement)) {
      return "c3";
    } else {
      return placement;
    }
  }

  public String getPlacement(String input) {
    StringBuilder buildPlacement = new StringBuilder();

    if (Character.isDigit(input.charAt(0))) {
      try {
        for (int i = 0; i < input.length(); i++) {
          if (input.charAt(i) == ' ' && input.charAt(i + 1) != ' ') {
            int j = i + 1;

            while (input.charAt(j) != ' ') {
              buildPlacement.append(input.charAt(j));
              j++;
              if (j == input.length()) {
                break;
              }
            }
            break;
          }
        }
      } catch (IndexOutOfBoundsException e) {
        System.out.println("Error: getting placement from input");
      }

      String placement = buildPlacement.toString();

      if (validPlacement(placement)) {
        return formatPlacement(placement);
      }
    }

    return "-1";
  }

  public int getWinOdds(String placement) {

    if (placement.equals("b") || placement.equals("r") || placement.equals("e") || placement.equals("o") || placement.equals("1to18") || placement.equals("19to36")) {
      return 2;
    } else if (placement.equals("1st12") || placement.equals("2nd12") || placement.equals("3rd12") || placement.equals("c1") || placement.equals("c2") || placement.equals("c3")) {
      return 3;
    } else {
      return 36;
    }
  }
}
