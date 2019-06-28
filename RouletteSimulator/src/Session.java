public class Session {
  private double initialBank;
  private double currentBank;
  private int winStreak;
  private int lossStreak;
  private int highestWinStreak;
  private int highestLossStreak;
  private int highestWinStreakRoll;
  private int highestLossStreakRoll;
  private int totalSpins;
  private int wins;
  private int losses;

  private boolean simulating;
  private int simSpins;
  private int simOutOfMoney;
  private double simMaxProfit;
  private double simAverageProfit;
  private double simAverageWinPercentage;

  public Session(double initialBank) {
    this.initialBank = initialBank;
    this.currentBank = initialBank;
    simulating = false;
    System.out.println("Bank: £" + initialBank);
  }

  public void addSpin() {
    totalSpins++;
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
    if ((currentBank - initialBank) > simMaxProfit) {
      simMaxProfit = currentBank;
    }
  }

  public boolean subBank(double amount) {
    if (currentBank - amount < 0) {
      System.out.println("OUT OF MONEY");

      if (simulating) {
        simOutOfMoney++;
      }
      return false;
    } else {
      currentBank = currentBank - amount;
      return true;
    }
  }

  public void resetStatistics(Display display) {
    currentBank = initialBank;
    totalSpins = 0;
    wins = 0;
    losses = 0;
    winStreak = 0;
    lossStreak = 0;
    highestWinStreak = 0;
    highestLossStreak = 0;
    highestWinStreakRoll = 0;
    highestLossStreakRoll = 0;
    display.displayResetStatistics();
  }

  private double calculateWinPercentage() {
    return ((double) wins/ ((double) wins + (double) losses)) * 100;
  }

  private void displaySpins(int realSpins) {
    System.out.println("Spins: " + realSpins);
  }

  private void displayTotalSpins() {
    System.out.println("Total spins: " + totalSpins);
  }

  private void displayHighestWinStreak() {
    System.out.println("Highest win streak: " + highestWinStreak + " (at position " + highestWinStreakRoll + ")");
  }

  private void displayHighestLossStreak() {
    System.out.println("Highest loss streak: " + highestLossStreak + " (at position " + highestLossStreakRoll + ")");
  }

  private void displayWinPercent() {
    System.out.print("Win percentage: ");

    if (wins == 0) {
      System.out.println("0%");
    } else if (losses == 0) {
      System.out.println("100%");
    } else {
      double winPercentage = calculateWinPercentage();
      System.out.println(String.format("%.2f", winPercentage) + "%");
    }
  }

  public void displayBank() {
    System.out.println("Bank: £" + currentBank);
  }

  private void displayProfit() {
    System.out.println("Profit: £" + (currentBank - initialBank));
  }

  private void displayExpectedWinPercentage(double odds) {
    double expectedWinPer = (1/odds) * 100;
    System.out.println("Expected win percentage: " + String.format("%.2f", expectedWinPer) + "%");
  }

  private void displaySimNum(int sim) {
    System.out.println("Simulation " + sim);
  }

  public void displayStatistics(int realSpins, int sim, double odds) {
    if (sim != 0) {
      displaySimNum(sim + 1);
    }
    displaySpins(realSpins);
    displayTotalSpins();
    displayExpectedWinPercentage(odds);
    displayWinPercent();
    displayHighestWinStreak();
    displayHighestLossStreak();
    System.out.println();
    displayBank();
    displayProfit();
    System.out.println("---------------");
  }

  public void displayGeneralStatistics() {
    displayTotalSpins();
    displayWinPercent();
    displayHighestWinStreak();
    displayHighestLossStreak();
    displayBank();
    displayProfit();
  }


  /* Simulation */

  public void resetSim() {
    simSpins = 0;
    simAverageWinPercentage = 0;
    simMaxProfit = 0;
    simOutOfMoney = 0;
    simAverageProfit = 0;
  }

  public void setSimulating(boolean value) {
    simulating = value;
  }

  private void displayTotalSims(int simulations) {
    System.out.println("Number of simulations: "+ simulations);
  }

  private void displaySimSpins() {
    System.out.println("Total spins: " + simSpins);
  }

  private void displayAverageWinPercentage() {
    System.out.println("Average win percentage: " + String.format("%.2f", simAverageWinPercentage) + "%");
  }

  private void displayOutOfMoney() {
    System.out.println("Out of money: " + simOutOfMoney);
  }

  private void displayMaxProfit() {
    System.out.println("Max profit made: £" + simMaxProfit);
  }

  private void displayAverageProfit() {
    System.out.println("Average profit: £" + String.format("%.2f", simAverageProfit) + "%");
  }

  public void handleSimulations(int sim, int simulations, int spins) {
    simAverageProfit = simAverageProfit + (((currentBank - initialBank) - simAverageProfit) / (sim + 1));
    simSpins += spins;
    simAverageWinPercentage = simAverageWinPercentage + ((calculateWinPercentage() - simAverageWinPercentage) / (sim + 1));
    currentBank = initialBank;

    if (sim + 1 == simulations) {
      displaySimStatistics(simulations);
    }
  }

  public void displaySimStatistics(int simulations) {
    displayTotalSims(simulations);
    displaySimSpins();
    displayAverageWinPercentage();
    displayOutOfMoney();
    displayMaxProfit();
    displayAverageProfit();
  }
}
