public class InputAnalyser {

  private boolean isNumeric(String string) {
    try {
      Double.parseDouble(string);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }

  public int getSpins(String input) {
    StringBuilder buildSpins = new StringBuilder();

    try {
      for (int i = 0; i < input.length(); i++) {
        if (i + 1 != input.length() - 1) {
          if (input.charAt(i) == '-' && (input.charAt(i + 1) == 's' || input.charAt(i + 1) == 'S')) {
            for (int j = i + 2; j < input.length(); j++) {
              if (input.charAt(j) != ' ') {
                buildSpins.append(input.charAt(j));
                if (input.charAt(j + 1) == ' ') {
                  break;
                }
              }
            }
            break;
          }
        }
      }
    } catch (IndexOutOfBoundsException e) {
      System.out.println("Error");
    }

    if (isNumeric(buildSpins.toString())) {
      return Integer.parseInt(buildSpins.toString());
    }

    return 1;
  }

  public double getChip(String input) {
    int i = 0;
    StringBuilder buildChip = new StringBuilder();

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
      System.out.println("Error");
    }

    return -1;
  }

  private boolean validPlacement(String placement) {
    if (placement.equals("r") || placement.equals("R") || placement.equals("red") || placement.equals("Red") ||
            placement.equals("b") || placement.equals("B") || placement.equals("black") || placement.equals("Black") ||
            placement.equals("1st12") || placement.equals("2nd12") || placement.equals("3rd12") ||
            placement.equals("column1") || placement.equals("col1") || placement.equals("c1") ||
            placement.equals("column2") || placement.equals("col2") || placement.equals("c2") ||
            placement.equals("column3") || placement.equals("col3") || placement.equals("c3") ||
            placement.equals("1to18") || placement.equals("19to36")) {
      return true;
    }

    return false;
  }

  private String formatPlacement(String placement) {
    if (placement.equals("r") || placement.equals("R") || placement.equals("red") || placement.equals("Red")) {
      return "r";
    } else if (placement.equals("b") || placement.equals("B") || placement.equals("black") || placement.equals("Black")) {
      return "b";
    } else if (placement.equals("column1") || placement.equals("col1") || placement.equals("c1")) {
      return "c1";
    } else if (placement.equals("column2") || placement.equals("col2") || placement.equals("c2")) {
      return "c2";
    } else if (placement.equals("column3") || placement.equals("col3") || placement.equals("c3")) {
      return "c3";
    } else {
      return placement;
    }
  }

  public String getPlacement(String input) {
    StringBuilder buildPlacement = new StringBuilder();

    try {
      for (int i = 0; i < input.length(); i++) {
        if (input.charAt(i) == ' ' && input.charAt(i + 1) != ' ') {
          int j = i + 1;

          while (input.charAt(i) != ' ' || (j + 1 == input.length())) {
            buildPlacement.append(input.charAt(j));
            j++;
          }
          break;
        }
      }
    } catch (IndexOutOfBoundsException e) {
      System.out.println("Error");
    }

    if (validPlacement(buildPlacement.toString())) {
      return formatPlacement(buildPlacement.toString());
    }

    return "-1";
  }

  public double getWinOdds(String placement) {

    return -1;
  }
}
