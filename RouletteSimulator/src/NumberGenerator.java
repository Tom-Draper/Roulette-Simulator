import java.util.Random;

public class NumberGenerator {

  public int generateNumber() {

    Random random = new Random();
    int randomNumber = Math.abs(random.nextInt()) % 37;

    System.out.println(randomNumber);
    
    return randomNumber;
  }
}
