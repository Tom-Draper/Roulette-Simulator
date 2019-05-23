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

    if (isNumeric(buildSpins.toString())) {
      return Integer.parseInt(buildSpins.toString());
    }

    return 1;
  }

  public int getChips() {

  }

  public String getPlacement() {

  }

  public double getWinOdds() {

  }
}
