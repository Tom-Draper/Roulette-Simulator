public class Strategy {

  public double doubleEachTime(double chip, double initialChip, boolean lose) {

    if (lose) {
      chip = chip * 2;
      System.out.println("DOUBLE NEXT");
    } else {
      chip = initialChip;
    }

    return chip;
  }
}
