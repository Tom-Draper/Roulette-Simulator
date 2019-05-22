public class Main {

    public static void main(String[] args) {
        NumberProperties numberProp = new NumberProperties();
        NumberGenerator numberGen = new NumberGenerator();


        int i = numberGen.generateNumber();
        numberProp.getColour(i);
        numberProp.isEven(i);
    }
}
