public class Session {
  private double initialBank;
  private double currentBank;
  private int winStreak;
  private int lossStreak;
  private int highestWinStreak;
  private int highestLossStreak;
  private int highestWinStreakRoll;
  private int highestLossStreakRoll;
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

  public void addWin(int roll) {
    wins++;
    winStreak++;
    lossStreak = 0;

    if (winStreak > highestWinStreak) {
      highestWinStreak = winStreak;
      highestWinStreakRoll = roll + 1;
    }
  }

  public void addLoss(int roll) {
    losses++;
    lossStreak++;
    winStreak = 0;

    if (lossStreak > highestLossStreak) {
      highestLossStreak = lossStreak;
      highestLossStreakRoll = roll + 1;
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
    System.out.println("Statistics have been reset");
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

  private void displayHighestWinStreak() {
    System.out.println("Highest win streak: " + highestWinStreak + " @ " + highestWinStreakRoll);
  }

  private void displayHighestLossStreak() {
    System.out.println("Highest loss streak: " + highestLossStreak + " @ " + highestLossStreakRoll);
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
    displayExpectedWinPercentage(odds);
    displayWinPercent();
    displayHighestWinStreak();
    displayHighestLossStreak();
    System.out.println();
    displayBank();
    displayProfit();
    System.out.println("---------------");
  }
}
