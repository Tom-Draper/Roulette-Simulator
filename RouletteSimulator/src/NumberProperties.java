import java.util.Arrays;
import java.util.List;

public class NumberProperties {
  private List<Integer> redList = Arrays.asList(1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, 36);
  private List<Integer> blackList = Arrays.asList(2, 4, 6, 8, 10, 11, 13, 15, 17, 20, 22, 24, 26, 28, 29, 31, 33, 35);

  /**
   * Checks whether an integer is even.
   * @param i - integer to check.
   * @return - whether integer is odd.
   */
  public boolean isEven(int i) {
    if (i % 2 == 0) {
      return true;
    }
    return false;
  }

  /**
   * Checks whether an integer is odd.
   * @param i - integer to check.
   * @return - whether integer is odd.
   */
  public boolean isOdd(int i) {
    if (i % 2 == 1) {
      return true;
    }
    return false;
  }

  /**
   * Returns the roulette colour of a particular number.
   * @param i - integer number to check.
   * @return - colour of the number.
   */
  public char getColour(int i) {
    if (redList.contains(i)) {
      return 'r'; //Red
    } else if (blackList.contains(i)) {
      return 'b'; //Black
    } else if (i == 0) {
      return 'g'; //Green
    }

    return 'e'; //Error
  }
}
