public class ResultProcessor {


  public boolean processResult(double chip, String placement, int number, Session session) {

    session.addSpin();
    return true;
  }
}
