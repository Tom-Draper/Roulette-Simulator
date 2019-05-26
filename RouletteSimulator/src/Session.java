public class Session {
  private double initialBank;
  private double currentBank;
  private int winStreak;
  private int lossStreak;
  private int highestWinStreak;
  private int highestLossStreak;
  private int spins;
  private int wins;
  private int losses;

  public Session(double initialBank) {
    this.initialBank = initialBank;
    this.currentBank = initialBank;
    System.out.println("Bank: £" + initialBank);
  }

  public double getBank() {
    return currentBank;
  }

  public void addSpin() {
    spins++;
  }

  public void addWin() {
    wins++;
    winStreak++;
    lossStreak = 0;

    if (winStreak > highestWinStreak) {
      highestWinStreak = winStreak;
    }
  }

  public void addLoss() {
    losses++;
    lossStreak++;
    winStreak = 0;

    if (lossStreak > highestLossStreak) {
      highestLossStreak = lossStreak;
    }
  }

  public void addBank(double amount) {
    currentBank = currentBank + amount;
  }

  public boolean subBank(double amount) {
    if (currentBank - amount < 0) {
      System.out.println("OUT OF MONEY");
      return false;
    } else {
      currentBank = currentBank - amount;
      return true;
    }
  }

  public void resetStatistics() {
    currentBank = initialBank;
    spins = 0;
    losses = 0;
    wins = 0;
    winStreak = 0;
    lossStreak = 0;
    highestWinStreak = 0;
    highestLossStreak = 0;
  }

  private void displaySpins() {
    System.out.println("Spins: " + spins);
  }

  private void displayRealSpins(int realSpins) {
    System.out.println("Spins: " + realSpins);
  }

  private void displayWins() {
    System.out.println("Wins: " + wins);
  }

  private void displayLosses() {
    System.out.println("Losses: " + losses);
  }

  private void displayWinPercent() {
    System.out.print("Win percentage: ");

    if (wins == 0) {
      System.out.println("0%");
    } else if (losses == 0) {
      System.out.println("100%");
    } else {
      double winPercentage = ((double) wins/ ((double) wins + (double) losses)) * 100;
      System.out.println(String.format("%.2f", winPercentage) + "%");
    }
  }

  private void displayExpectedWinPercentage(double odds) {
    double expectedWinPer = (1/odds) * 100;
    System.out.println("Expected win percentage: " + String.format("%.2f", expectedWinPer) + "%");
  }

  public void displayBank() {
    System.out.println("Bank: £" + currentBank);
  }

  private void displayProfit() {
    System.out.println("Profit: £" + (currentBank - initialBank));
  }

  public void displayStatistics(int realSpins, double odds) {
    displayRealSpins(realSpins);
    displayWinPercent();
    displayExpectedWinPercentage(odds);
    displayBank();
    displayProfit();
    System.out.println("---------------");
  }
}
