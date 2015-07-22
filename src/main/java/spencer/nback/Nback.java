package spencer.nback;

public class Nback {

  private int number;
  private boolean answer;

  public Nback(int n, boolean a) {
    number = n;
    answer = a;
  }

  public int getNumber() {
    return number;
  }

  public boolean getAnswer() {
    return answer;
  }

  @Override public String toString() {
    return number + ": " + answer;
  }
}
