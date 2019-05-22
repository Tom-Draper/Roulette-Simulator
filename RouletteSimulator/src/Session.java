public class Session {
  private double bank;

  public Session(double initialBank) {
    bank = initialBank;
    System.out.println("Bank: £" + bank);
  }

  public void subtractBank(double value) {
    bank = bank - value;

  }

  public void addBank(double value) {
    bank = bank + value;
  }
}
