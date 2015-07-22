package spencer.nback;

import java.util.List;

public class Main {
  public static void main(String[] args) {
    NbackGenerator generator = new NbackGenerator.Builder().build();
    List<Nback> nbacks = generator.getNbacks();
    for (Nback nback : nbacks) {
      System.out.println(nback);
    }
  }
}
