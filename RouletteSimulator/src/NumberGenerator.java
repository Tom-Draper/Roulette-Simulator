import java.util.Random;

public class NumberGenerator {

  private Random random = new Random();

  public int generateNumber() {
    int randomNumber = Math.abs(random.nextInt()) % 37;

    System.out.println(randomNumber);
    
    return randomNumber;
  }

  public int generateColour() {
    int randomNumber = Math.abs(random.nextInt()) % 2;

    System.out.println(randomNumber);

    return randomNumber;
  }
}
