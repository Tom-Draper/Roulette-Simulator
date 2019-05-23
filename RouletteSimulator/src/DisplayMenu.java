public class DisplayMenu {

  public void enterBank() {
    System.out.println("Enter starting bank value:");
  }

  public void possibleChips() {
    System.out.println("0.5   1   2   5   10   20   50   100");
  }

  public void help() {
    System.out.println("Enter chip amount then board placement");
    System.out.println("Examples: \"2 r\"   or   \"5 31\"   or   \"0.5 col1\"   or   \"20 1st12\"");
    System.out.println("b/B/black/Black/BLACK");
    System.out.println("r/R/red/Red/RED");
    System.out.println("1st12");
    System.out.println("2nd12");
    System.out.println("3rd12");
    System.out.println("column1/col1/c1");
    System.out.println("column2/col2/c2");
    System.out.println("column3/col3/c3");
    System.out.println("1to18");
    System.out.println("19to36");
  }

}
