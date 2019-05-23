import java.util.Arrays;
import java.util.List;

public class NumberProperties {
  public List<Integer> redList = Arrays.asList(1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, 36);
  public List<Integer> blackList = Arrays.asList(2, 4, 6, 8, 10, 11, 13, 15, 17, 20, 22, 24, 26, 28, 29, 31, 33, 35);
  public List<Integer> firstCol = Arrays.asList(1, 4, 7, 10, 13, 16, 19, 22, 25, 28, 31, 34);
  public List<Integer> secondCol = Arrays.asList(2, 5, 8, 11, 14, 17, 20, 23, 26, 29, 32, 35);
  public List<Integer> thirdCol = Arrays.asList(3, 6, 9, 12, 15, 18, 21, 24, 27, 30, 33, 36);
  public List<Integer> firstTwelve = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
  public List<Integer> secondTwelve = Arrays.asList(13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24);
  public List<Integer> thirdTwelve = Arrays.asList(25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36);
  public List<Integer> oneToEighteen = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18);
  public List<Integer> nineteenToThirtySix = Arrays.asList(19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36);

  /**
   * Checks whether an integer is even.
   * @param i - integer to check.
   * @return - whether integer is odd.
   */
  public boolean isEven(int i) {
    if (i % 2 == 0) {
      System.out.println("EVEN");
      return true;
    }
    System.out.println("ODD");
    return false;
  }

  /**
   * Returns the roulette colour of a particular number.
   * @param i - integer number to check.
   * @return - colour of the number.
   */
  public char getColour(int i) {
    if (redList.contains(i)) {
      System.out.println("RED");
      return 'R'; //Red
    } else if (blackList.contains(i)) {
      System.out.println("BLACK");
      return 'B'; //Black
    } else if (i == 0) {
      System.out.println("GREEN");
      return 'G'; //Green
    }

    System.out.println("Error");
    return 'E'; //Error
  }
}
