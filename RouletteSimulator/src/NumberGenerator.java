import java.util.Random;

public class NumberGenerator {

  private Random random = new Random();

  /**
   * Generate random number on the roulette board.
   * @return - randomly selected number.
   */
  public int generateNumber() {
    return Math.abs(random.nextInt()) % 37;
  }

  /**
   * Generate a random colour (red or black).
   * @return - randomly selected colour.
   */
  public int generateColour() {
    return Math.abs(random.nextInt()) % 2;
  }
}
