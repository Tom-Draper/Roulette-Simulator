public class ResultProcessor {


  public boolean processResult(double chip, String placement, int odds, int number, Session session, NumberProperties numberProp) {
    boolean win = false;

    if (placement.equals("b") && numberProp.blackList.contains(number) ||
            placement.equals("r") && numberProp.redList.contains(number) ||
            placement.equals("1st12") && numberProp.firstTwelve.contains(number) ||
            placement.equals("2nd12") && numberProp.secondTwelve.contains(number) ||
            placement.equals("3rd12") && numberProp.thirdTwelve.contains(number) ||
            placement.equals("c1") && numberProp.firstCol.contains(number) ||
            placement.equals("c2") && numberProp.secondCol.contains(number) ||
            placement.equals("c3") && numberProp.thirdCol.contains(number) ||
            placement.equals("1to18") && numberProp.oneToEighteen.contains(number) ||
            placement.equals("19to36") && numberProp.nineteenToThirtySix.contains(number)) {
      win = true;
      session.addBank(chip * odds);
    }

    session.addSpin();

    return win;
  }
}
