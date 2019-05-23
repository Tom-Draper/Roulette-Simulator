public class Session {
  private double bank;
  private Statistics stats;

  public Session(double initialBank) {
    bank = initialBank;
    System.out.println("Bank: £" + bank);
    stats = new Statistics();
  }

  public Statistics getStatistics() {
    return stats;
  }

  public void subtractBank(double value) {
    bank = bank - value;

  }

  public void addBank(double value) {
    bank = bank + value;
  }
}
