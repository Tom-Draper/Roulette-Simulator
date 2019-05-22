import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Session session = new Session();
        NumberProperties numberProp = new NumberProperties();
        NumberGenerator numberGen = new NumberGenerator();
        Display display = new Display();

        Scanner scanner = new Scanner(System.in);

        display.enterBank();
        session.setBank(scanner.nextDouble());

        int i = numberGen.generateNumber();
        numberProp.getColour(i);
        numberProp.isEven(i);
    }
}
