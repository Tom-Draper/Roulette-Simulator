public class Session {
  private double initialBank;
  private double currentBank;
  private int spins;
  private int wins;
  private int losses;

  public Session(double initialBank) {
    this.initialBank = initialBank;
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
  }

  public void addLoss() {
    losses++;
  }

  public void addBank(double amount) {
    currentBank = currentBank + amount;
  }

  public void subBank(double amount) {
    if (currentBank - amount < 0) {
      System.out.println("OUT OF MONEY");
    } else {
      currentBank = currentBank - amount;
    }
  }

  private void displaySpins() {
    System.out.println("Spins: " + spins);
  }

  private void displayWins() {
    System.out.println("Wins: " + wins);
  }

  private void displayLosses() {
    System.out.println("Losses: " + losses);
  }

  private void displayWinPercent() {
    System.out.println("Win percentage: " + (wins / losses * 100));
  }

  private void displayBank() {
    System.out.println("Bank: " + currentBank);
  }

  private void displayProfit() {
    System.out.println("Profit: " + (initialBank - this.getBank()));
  }

  public void displayStatistics() {
    displaySpins();
    displayWinPercent();
    displayBank();
    displayProfit();
  }
}
