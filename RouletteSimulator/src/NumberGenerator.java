import java.util.Random;

/**
 * Collection of functions to generate variety of values.
 */
public class NumberGenerator {

  private Random random = new Random();

  /**
   * Generate random number on the European roulette board.
   * @return - randomly selected number.
   */
  public int generateEuropeanNumber() {
    return Math.abs(random.nextInt()) % 37;
  }

  /**
   * Generate random number on the American roulette board.
   * @return - randomly selected number.
   */
  public int generateAmericanNumber() {
    return Math.abs(random.nextInt()) % 38;
  }

  /**
   * Generate a random colour (red or black).
   * @return - randomly selected colour.
   */
  public int generateColour() {
    return Math.abs(random.nextInt()) % 2;
  }
}
