/**
 * Functions used to process the result of a spin and compare to the values in the command entered.
 */
public class ResultProcessor {

  /**
   * Compares the command values entered with the result of a spin.
   * Updates bank, wins, loses and spins values based on the result.
   * @param chip - the entered chip value.
   * @param placement - the entered placement value
   * @param odds - the odds of landing on the placement entered.
   * @param number - the number landed on.
   * @param roll - the current consecutive roll number.
   * @param session - session functions.
   * @param numberProp - number properties functions.
   * @return - whether the spin was won.
   */
  public boolean processResult(double chip, String placement, int odds, int number, int roll, Session session, NumberProperties numberProp, InputAnalyser analyser) {
    boolean win = false;

    if (placement.equals("b") && numberProp.blackList.contains(number) ||
            placement.equals("r") && numberProp.redList.contains(number) ||
            placement.equals("e") && numberProp.isEven(number) ||
            placement.equals("o") && !numberProp.isEven(number) ||
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
      session.addWin(roll);
    } else if (analyser.isNumeric(placement)) {
      if (Integer.parseInt(placement) == number) {
        win = true;
        session.addBank(chip * odds);
        session.addWin(roll);
      } else {
        session.addLoss(roll);
      }
    } else {
      session.addLoss(roll);
    }
    session.addSpin();

    return win;
  }
}
