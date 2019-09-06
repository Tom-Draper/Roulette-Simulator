/**
 * Gives functions to optional strategies that can be enabled by command input.
 */
public class Strategy {

  private double doubleStratMax;
  private double down;

  public Strategy() {
    doubleStratMax = -1;
    down = 0;
  }

  /**
   *
   * @param value
   */
  public void setDoubleStratMax(double value) {
    doubleStratMax = value;
    if (doubleStratMax != -1) {
      System.out.println("MAX BET £" + doubleStratMax);
    }
  }

  /**
   *
   * @param chip
   * @param initialChip
   * @param lose
   * @return
   */
  public double doubleEachTime(double chip, double initialChip, boolean lose) {

    if (lose) {
      down = down + chip;

      if (doubleStratMax == -1) { //Max not been set
        chip = chip * 2;
      } else {
        if ((down + (chip * 2)) < doubleStratMax) { //Still under max loss
          chip = chip * 2;
        } else {
          chip = initialChip;
          down = 0;
          System.out.println("Going over max loss, resetting chip");
        }
      }
      System.out.println("DOUBLE NEXT");
    } else {
      chip = initialChip;
      down = 0;
    }

    return chip;
  }
}
